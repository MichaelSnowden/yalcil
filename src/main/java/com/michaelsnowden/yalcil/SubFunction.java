package com.michaelsnowden.yalcil;

import java.util.List;
import java.util.function.BinaryOperator;

/**
 * Created by michael.snowden on 4/28/16.
 */
class SubFunction extends AbstractFunction {
    public static final SubFunction INSTANCE = new SubFunction();
    @Override
    public RuntimeObject computeResult(StackFrame lookup, List<RuntimeObject> args) {
        return args.stream().reduce(new BinaryOperator<RuntimeObject>() {
            @Override
            public RuntimeObject apply(RuntimeObject a, RuntimeObject b) {
                if (a.getType() == RuntimeType.INT && b.getType() == RuntimeType.INT) {
                    return new IntObject(a.asInt(lookup).subtract(b.asInt(lookup)));
                } else if (a.getType() == RuntimeType.INT && b.getType() == RuntimeType.DECIMAL) {
                    return new DecimalObject(a.asDecimal(lookup).subtract(b.asDecimal(lookup)));
                } else if (a.getType() == RuntimeType.DECIMAL && b.getType() == RuntimeType.INT) {
                    return new DecimalObject(a.asDecimal(lookup).subtract(b.asDecimal(lookup)));
                } else {
                    return new DecimalObject(a.asDecimal(lookup).subtract(b.asDecimal(lookup)));
                }
            }
        }).get();
    }
}