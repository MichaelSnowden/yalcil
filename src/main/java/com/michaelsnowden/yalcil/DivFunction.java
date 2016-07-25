package com.michaelsnowden.yalcil;

import java.math.RoundingMode;
import java.util.List;

/**
 * Created by michael.snowden on 4/28/16.
 */
class DivFunction extends AbstractFunction {
    public static final DivFunction INSTANCE = new DivFunction();

    @Override
    public RuntimeObject computeResult(StackFrame lookup, List<RuntimeObject> args) {
        final RuntimeObject a = args.get(0);
        final RuntimeObject b = args.get(1);
        if (a.getType() == RuntimeType.INT && b.getType() == RuntimeType.INT) {
            return new IntObject(a.asInt(lookup).divide(b.asInt(lookup)));
        } else if (a.getType() == RuntimeType.INT && b.getType() == RuntimeType.DECIMAL) {
            return new DecimalObject(a.asDecimal(lookup).divide(b.asDecimal(lookup), RoundingMode.HALF_UP));
        } else if (a.getType() == RuntimeType.DECIMAL && b.getType() == RuntimeType.INT) {
            return new DecimalObject(a.asDecimal(lookup).divide(b.asDecimal(lookup), RoundingMode.HALF_UP));
        } else {
            return new DecimalObject(a.asDecimal(lookup).divide(b.asDecimal(lookup), RoundingMode.HALF_UP));
        }
    }
}