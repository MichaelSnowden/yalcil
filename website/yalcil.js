RuntimeType = {
    FUNCTION: 0,
    FLOAT: 1,
    INT: 2,
    STRING: 3
};

class SymbolLookup {
    constructor(parent) {
        this.parent = parent;
        this.map = {};
    }

    get(key) {
        if (key in this.map) {
            return this.map[key];
        } else if (this.parent != null) {
            return this.parent.get(key);
        } else {
            return null;
        }
    }

    put(key, value) {
        this.map[key] = value;
    }
}

class RuntimeObject {
    getType() {
        throw "Unimplemented";
    }

    asObject(lookup) {
        throw "Unimplemented";
    }

    asFloat(lookup) {
        return this.asObject(lookup);
    }

    asInt(lookup) {
        return this.asObject(lookup);
    }

    asString(lookup) {
        return this.asObject(lookup);
    }

    asFunction(lookup) {
        return this.asObject(lookup);
    }
}

class AbstractFunction extends RuntimeObject {
    getType() {
        return RuntimeType.FUNCTION;
    }

    asObject(lookup) {
        return this;
    }

    call(lookup, args) {
        throw "Unimplemented";
    }
}

class FloatObject extends RuntimeObject {
    constructor(data) {
        super();
        this.data = data;
    }

    getType() {
        return RuntimeType.FLOAT;
    }

    asObject(lookup) {
        return this.data;
    }

    asInt(lookup) {
        return Math.floor(data);
    }
}

class IntObject extends RuntimeObject {
    constructor(data) {
        super();
        this.data = data;
    }

    getType() {
        return RuntimeType.INT;
    }

    asObject(lookup) {
        return this.data;
    }
}

class StringObject extends RuntimeObject {
    constructor(data) {
        super();
        this.data = data;
    }

    getType() {
        return RuntimeType.STRING;
    }

    asObject(lookup) {
        return this.data;
    }
}

class AddFunction extends AbstractFunction {
    call(lookup, args) {
        return args.reduce(function (a, b) {
            if (a.getType() == RuntimeType.INT && b.getType() == RuntimeType.INT) {
                return new IntObject(a.asInt(lookup) + b.asInt(lookup));
            } else if (a.getType() == RuntimeType.INT && b.getType() == RuntimeType.FLOAT) {
                return new FloatObject(a.asInt(lookup) + b.asFloat(lookup));
            } else if (a.getType() == RuntimeType.FLOAT && b.getType() == RuntimeType.INT) {
                return new FloatObject(a.asFloat(lookup) + b.asInt(lookup));
            } else if (a.getType() == RuntimeType.STRING && b.getType() == RuntimeType.STRING) {
                return new StringObject(a.asString(lookup) + b.asString(lookup));
            } else {
                return new FloatObject(a.asFloat(lookup) + b.asFloat(lookup));
            }
        });
    }
}

class IfFunction extends AbstractFunction {
    call(lookup, args) {
        var child = new SymbolLookup(lookup);
        var truthiness;
        if (args[0].getType() == RuntimeType.INT) {
            truthiness = args[0].asInt(child) != 0;
        } else if (args[0].getType() == RuntimeType.FLOAT) {
            truthiness = args[0].asFloat(child) != 0;
        } else if (args[0].getType() == RuntimeType.FUNCTION) {
            throw "Cannot evaluate the truthiness of a function";
        } else {
            throw "Unknown type";
        }
        if (truthiness) {
            return args[1];
        } else {
            return args[2]
        }
    }
}

class EqFunction extends AbstractFunction {
    call(lookup, args) {
        var child = new SymbolLookup(lookup);
        return new IntObject(args[0].asObject(child) == args[1].asObject(child));
    }
}

class SubFunction extends AbstractFunction {
    call(lookup, args) {
        return args.reduce(function (a, b) {
            if (a.getType() == RuntimeType.INT && b.getType() == RuntimeType.INT) {
                return new IntObject(a.asInt(lookup) - b.asInt(lookup));
            } else if (a.getType() == RuntimeType.INT && b.getType() == RuntimeType.FLOAT) {
                return new FloatObject(a.asInt(lookup) - b.asFloat(lookup));
            } else if (a.getType() == RuntimeType.FLOAT && b.getType() == RuntimeType.INT) {
                return new FloatObject(a.asFloat(lookup) - b.asInt(lookup));
            } else if (a.getType() == RuntimeType.STRING && b.getType() == RuntimeType.STRING) {
                return new StringObject(a.asString(lookup) - b.asString(lookup));
            } else {
                return new FloatObject(a.asFloat(lookup) - b.asFloat(lookup));
            }
        });
    }
}

class MulFunction extends AbstractFunction {
    call(lookup, args) {
        return args.reduce(function (a, b) {
            if (a.getType() == RuntimeType.INT && b.getType() == RuntimeType.INT) {
                return new IntObject(a.asInt(lookup) * b.asInt(lookup));
            } else if (a.getType() == RuntimeType.INT && b.getType() == RuntimeType.FLOAT) {
                return new FloatObject(a.asInt(lookup) * b.asFloat(lookup));
            } else if (a.getType() == RuntimeType.FLOAT && b.getType() == RuntimeType.INT) {
                return new FloatObject(a.asFloat(lookup) * b.asInt(lookup));
            } else if (a.getType() == RuntimeType.STRING && b.getType() == RuntimeType.INT) {
                return new StringObject(a.asString(lookup).repeat(b.asInt(lookup)));
            } else if (a.getType() == RuntimeType.INT && b.getType() == RuntimeType.STRING) {
                return new StringObject(b.asString(lookup).repeat(a.asInt(lookup)));
            } else {
                return new FloatObject(a.asFloat(lookup) * b.asFloat(lookup));
            }
        });
    }
}

class LambdaFunction extends AbstractFunction {
    constructor(context) {
        super();
        this.context = context;
    }

    call(lookup, args) {
        var child = new SymbolLookup(lookup);
        for (var i = 0; i < args.length; ++i) {
            child.put(this.context.IDENTIFIER()[i].getText(), args[i]);
        }
        return Runtime.runExpression(this.context.expression(), child);
    }
}

class Suspension extends RuntimeObject {
    constructor(lookup, argContexts, fn) {
        super();
        this.cached = false;
        this.result = null;
        this.lookup = lookup;
        this.argContexts = argContexts;
        this.fn = fn;
    }

    getResult() {
        if (!this.cached) {
            this.result = this.computeResult();
            this.cached = true;
        }
        return this.result;
    }

    computeResult() {
        var args = [];
        for (var i = 0; i < this.argContexts.length; ++i) {
            args.push(Runtime.runExpression(this.argContexts[i], this.lookup));
        }
        return this.fn.call(this.lookup, args);
    }

    asObject(ignored) {
        return this.getResult().asObject(this.lookup);
    }

    asString() {
        return this.getResult().asString(this.lookup);
    }

    asFloat() {
        return this.getResult().asFloat(this.lookup);
    }

    asInt() {
        return this.getResult().asInt(this.lookup);
    }

    getType() {
        return this.getResult().getType();
    }
}

class Runtime {
    static runProgram(context) {
        if (context.expression() != null) {
            var root = new SymbolLookup(null);
            root.put("+", new AddFunction());
            root.put("?", new IfFunction());
            root.put("-", new SubFunction());
            root.put("*", new MulFunction());
            root.put("=", new EqFunction());
            var run = Runtime.runExpression(context.expression(), root);
            return run.asString();
        } else {
            return "";
        }
    }

    static runExpression(context, lookup) {
        if (context.lambdaAbstraction() != null) {
            return Runtime.runAbstraction(context.lambdaAbstraction(), lookup);
        } else if (context.application() != null) {
            return Runtime.runApplication(context.application(), lookup);
        } else if (context.literal() != null) {
            return Runtime.runLiteral(context.literal(), lookup);
        } else {
            throw "Invalid expression";
        }
    }

    static runLiteral(context, lookup) {
        if (context.IDENTIFIER() != null) {
            return lookup.get(context.getText());
        } else if (context.INTEGER_LITERAL() != null) {
            return new IntObject(parseInt(context.getText()));
        } else if (context.FLOAT_LITERAL() != null) {
            return new FloatObject(parseFloat(context.getText()));
        } else if (context.STRING_LITERAL() != null) {
            const text = context.getText();
            return new StringObject(text.substring(1, text.length - 1));
        } else {
            throw "Invalid Literal";
        }
    }

    static runApplication(context, lookup) {
        var argContexts = context.expression();
        var functionContext = argContexts[0];
        var runtimeObject = Runtime.runExpression(functionContext, lookup);
        if (runtimeObject.getType() != RuntimeType.FUNCTION) {
            throw "Expected a function as first argument to application";
        }
        var fn = runtimeObject.asFunction(lookup);
        return new Suspension(lookup, argContexts.slice(1), fn);
    }

    static runAbstraction(context, ignored) {
        return new LambdaFunction(context);
    }
}