package com.michaelsnowden.yalcil;

import java.util.List;

/**
 * Created by michael.snowden on 5/6/16.
 */
public class GreaterThanFunction extends AbstractFunction {
    public static final GreaterThanFunction INSTANCE = new GreaterThanFunction();

    @Override
    public RuntimeObject computeResult(StackFrame lookup, List<RuntimeObject> args) {
        if (args.get(0).getType() == RuntimeType.INT && args.get(1).getType() == RuntimeType.INT) {
            return new IntObject(args.get(0).asInt(lookup).compareTo(args.get(1).asInt(lookup)) == 1 ? 1 : 0);
        } else {
            throw new RuntimeException("Less than comparison hasn't been implemented for types: " + args.get(0)
                    .getType()
                    + ", " + args.get(1).getType());
        }
    }
}
