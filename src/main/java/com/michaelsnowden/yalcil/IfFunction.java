package com.michaelsnowden.yalcil;

import java.util.List;

/**
 * Created by michael.snowden on 4/28/16.
 */
class IfFunction extends AbstractFunction {
    public static final IfFunction INSTANCE = new IfFunction();

    @Override
    public RuntimeObject computeResult(StackFrame lookup, List<RuntimeObject> args) {
        boolean truthiness;
        if (args.get(0).getType() == RuntimeType.INT) {
            truthiness = args.get(0).asInt(lookup).intValue() != 0;
        } else if (args.get(0).getType() == RuntimeType.DECIMAL) {
            truthiness = args.get(0).asDecimal(lookup).doubleValue() != 0.0;
        } else if (args.get(0).getType() == RuntimeType.FUNCTION) {
            throw new RuntimeException("Cannot evaluate the truthiness of a function");
        } else {
            throw new RuntimeException("Unknown type");
        }
        if (truthiness) {
            return args.get(1);
        } else {
            return args.get(2);
        }
    }

//    TODO: Fix this
//    @Override
//    public boolean canCache() {
//        return false;
//    }
}
