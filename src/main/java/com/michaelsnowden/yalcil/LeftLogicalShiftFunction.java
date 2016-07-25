package com.michaelsnowden.yalcil;

import java.util.List;

/**
 * Created by michael.snowden on 5/7/16.
 */
public class LeftLogicalShiftFunction extends AbstractFunction {
    public static final LeftLogicalShiftFunction INSTANCE = new LeftLogicalShiftFunction();

    @Override
    protected RuntimeObject computeResult(StackFrame lookup, List<RuntimeObject> args) {
        final RuntimeObject a = args.get(0);
        final RuntimeObject b = args.get(1);
        if (a.getType() != RuntimeType.INT || b.getType() != RuntimeType.INT) {
            throw new RuntimeException("Cannot compute the left logical shift of " + a + " >> " + b);
        }
        return new IntObject(a.asInt(lookup).shiftLeft(b.asInt(lookup).intValue()));
    }
}
