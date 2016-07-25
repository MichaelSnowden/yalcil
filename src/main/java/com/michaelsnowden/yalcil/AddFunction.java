package com.michaelsnowden.yalcil;

import java.util.List;
import java.util.function.BinaryOperator;

/**
 * Created by michael.snowden on 4/28/16.
 */
class AddFunction extends AbstractFunction {
    public static final AddFunction INSTANCE = new AddFunction();

    @Override
    public RuntimeObject computeResult(StackFrame lookup, List<RuntimeObject> args) {
        return args.stream().reduce(new BinaryOperator<RuntimeObject>() {
            @Override
            public RuntimeObject apply(RuntimeObject a, RuntimeObject b) {
                if (a.getType() == RuntimeType.INT && b.getType() == RuntimeType.INT) {
                    return new IntObject(a.asInt(lookup).add(b.asInt(lookup)));
                } else if (a.getType() == RuntimeType.INT && b.getType() == RuntimeType.DECIMAL) {
                    return new DecimalObject(a.asDecimal(lookup).add(b.asDecimal(lookup)));
                } else if (a.getType() == RuntimeType.DECIMAL && b.getType() == RuntimeType.INT) {
                    return new DecimalObject(a.asDecimal(lookup).add(b.asDecimal(lookup)));
                } else if (a.getType() == RuntimeType.STRING && b.getType() == RuntimeType.STRING) {
                    return new StringObject(a.asString(lookup) + b.asString(lookup));
                } else {
                    return new DecimalObject(a.asDecimal(lookup).add(b.asDecimal(lookup)));
                }
            }
        }).get();
    }
}