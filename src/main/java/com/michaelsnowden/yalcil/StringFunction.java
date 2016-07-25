package com.michaelsnowden.yalcil;

import java.util.List;

/**
 * Created by michael.snowden on 5/6/16.
 */
public class StringFunction extends AbstractFunction {
    public static final StringFunction INSTANCE = new StringFunction();

    @Override
    public RuntimeObject computeResult(StackFrame lookup, List<RuntimeObject> args) {
        return new StringObject(args.get(0).asString(lookup));
    }
}