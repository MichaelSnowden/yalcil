package com.michaelsnowden.yalcil;

import java.util.List;

/**
 * Created by michael.snowden on 5/7/16.
 */
public class XorFunction extends AbstractFunction {
    public static final XorFunction INSTANCE = new XorFunction();

    @Override
    public RuntimeObject computeResult(StackFrame lookup, List<RuntimeObject> args) {
        if (args.get(0).getType() != RuntimeType.INT || args.get(1).getType() != RuntimeType.INT) {
            throw new RuntimeException("Cannot XOR non-int types: " + args.get(0).getType() + ", " + args.get(1)
                    .getType());
        }
        return new IntObject(args.get(0).asInt(lookup).xor(args.get(1).asInt(lookup)));
    }
}
