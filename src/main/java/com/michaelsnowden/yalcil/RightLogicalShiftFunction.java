package com.michaelsnowden.yalcil;

import java.util.List;

/**
 * Created by michael.snowden on 5/7/16.
 */
public class RightLogicalShiftFunction extends AbstractFunction {
    public static final RightLogicalShiftFunction INSTANCE = new RightLogicalShiftFunction();

    @Override
    protected RuntimeObject computeResult(StackFrame lookup, List<RuntimeObject> args) {
        final RuntimeObject a = args.get(0);
        final RuntimeObject b = args.get(1);
        if (a.getType() != RuntimeType.INT || b.getType() != RuntimeType.INT) {
            throw new RuntimeException("Cannot compute the right logical shift of " + a + " >> " + b);
        }
        return new IntObject(a.asInt(lookup).shiftRight(b.asInt(lookup).intValue()));
    }
}
