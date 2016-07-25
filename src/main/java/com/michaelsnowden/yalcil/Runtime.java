package com.michaelsnowden.yalcil;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * Created by michael.snowden on 4/28/16.
 */
public class Runtime {
    public static String run(CharStream charStream) throws IOException {
        return run(getParser(charStream).program());
    }

    static String run(YalcilParser.ProgramContext context) throws IOException {
        if (context.expression() != null) {
            StackFrame root = new StackFrame(null);
            root.setObject("if", IfFunction.INSTANCE);
            root.setObject("+", AddFunction.INSTANCE);
            root.setObject("-", SubFunction.INSTANCE);
            root.setObject("*", MulFunction.INSTANCE);
            root.setObject("/", DivFunction.INSTANCE);
            root.setObject("=", EqFunction.INSTANCE);
            root.setObject("!=", NeqFunction.INSTANCE);
            root.setObject("open", OpenFunction.INSTANCE);
            root.setObject("cons", ConsFunction.INSTANCE);
            root.setObject("car", CarFunction.INSTANCE);
            root.setObject("cdr", CdrFunction.INSTANCE);
            root.setObject("len", LengthFunction.INSTANCE);
            root.setObject("list?", IsNodeFunction.INSTANCE);
            root.setObject("str", StringFunction.INSTANCE);
            root.setObject("nil?", IsNilFunction.INSTANCE);
            root.setObject("<", LessThanFunction.INSTANCE);
            root.setObject(">", GreaterThanFunction.INSTANCE);
            root.setObject("^", XorFunction.INSTANCE);
            root.setObject("or", OrFunction.INSTANCE);
            root.setObject("and", AndFunction.INSTANCE);
            root.setObject(">>", RightLogicalShiftFunction.INSTANCE);
            root.setObject("<<", LeftLogicalShiftFunction.INSTANCE);
            root.setObject("%", ModFunction.INSTANCE);
            root.setObject("nil", NilObject.INSTANCE);
            root.setObject("**", PowerFunction.INSTANCE);
            root.setObject("list", ListFunction.INSTANCE);
            root.setObject("append", AppendFunction.INSTANCE);
            root.setObject("int", IntFunction.INSTANCE);
            root.setObject("apply", ApplyFunction.INSTANCE);
            RuntimeObject run = run(context.expression(), root);
            return run.asString(null);
        } else {
            return "";
        }
    }

    static RuntimeObject run(YalcilParser.ExpressionContext context, StackFrame lookup) throws IOException {
        if (context.abstraction() != null) {
            return run(context.abstraction(), lookup);
        } else if (context.application() != null) {
            return run(context.application(), lookup);
        } else if (context.literal() != null) {
            return run(context.literal(), lookup);
        } else {
            throw new RuntimeException("Invalid Expression");
        }
    }

    static RuntimeObject run(YalcilParser.LiteralContext context, StackFrame lookup) throws IOException {
        if (context.IDENTIFIER() != null) {
            final TerminalNode identifier = context.IDENTIFIER();
            final RuntimeObject object = lookup.getObject(identifier.getText());
            if (object == null) {
                final RuntimeObject file = openFile(identifier, lookup);
                lookup.setObject(identifier.getText(), file);
                return file;
            } else {
                return object;
            }
        } else if (context.INTEGER_LITERAL() != null) {
            return new IntObject(Integer.parseInt(context.getText()));
        } else if (context.FLOAT_LITERAL() != null) {
            return new DecimalObject(Float.parseFloat(context.getText()));
        } else if (context.STRING_LITERAL() != null) {
            return new StringObject(context.getText().substring(1, context.getText().length() - 1));
        } else {
            throw new RuntimeException("Invalid Literal");
        }
    }

    private static RuntimeObject openFile(TerminalNode file, StackFrame lookup) {
        StringObject fileName = new StringObject(file.getText());
        final List<RuntimeObject> args = Collections.singletonList(fileName);
        return OpenFunction.INSTANCE.getResult(lookup, args);
    }

    static RuntimeObject run(YalcilParser.ApplicationContext context, StackFrame lookup) throws IOException {
        List<YalcilParser.ExpressionContext> argContexts = context.expression();
        YalcilParser.ExpressionContext functionContext = argContexts.get(0);
        RuntimeObject runtimeObject = run(functionContext, lookup);
        if (runtimeObject.getType() != RuntimeType.FUNCTION) {
            throw new RuntimeException("Expected a function as first argument to application");
        }
        AbstractFunction function = (AbstractFunction) runtimeObject.asObject(lookup);

        return new Promise(lookup, argContexts, function);
    }

    static RuntimeObject run(YalcilParser.AbstractionContext context, StackFrame ignored) {
        return new LambdaFunction(context);
    }

    static YalcilParser getParser(CharStream charStream) {
        return new YalcilParser(new CommonTokenStream(new YalcilLexer(charStream)));
    }

}