package com.michaelsnowden.yalcil;

import java.util.List;

/**
 * Created by michael.snowden on 4/28/16.
 */
class NeqFunction extends AbstractFunction {
    public static NeqFunction INSTANCE = new NeqFunction();

    @Override
    public RuntimeObject computeResult(StackFrame lookup, List<RuntimeObject> args) {
        return args.stream().reduce((a, b) -> new IntObject(a.asInt(lookup).compareTo(b.asInt(lookup)) != 0 ? 1 : 0))
                .get();
    }
}