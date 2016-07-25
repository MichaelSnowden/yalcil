package com.michaelsnowden.yalcil;

import java.util.List;

/**
 * Created by michael.snowden on 4/28/16.
 */
class EqFunction extends AbstractFunction {
    public static EqFunction INSTANCE = new EqFunction();

    @Override
    public RuntimeObject computeResult(StackFrame lookup, List<RuntimeObject> args) {
        return args.stream().reduce((a, b) -> new IntObject(a.asInt(lookup).compareTo(b.asInt(lookup)) == 0 ? 1 : 0))
                .get();
    }
}