package com.michaelsnowden.yalcil;

import java.util.List;

/**
 * Created by michael.snowden on 6/2/16.
 */
public class ApplyFunction extends AbstractFunction {
    public static final ApplyFunction INSTANCE = new ApplyFunction();

    private ApplyFunction() {}

    @Override
    protected RuntimeObject computeResult(StackFrame lookup, List<RuntimeObject> args) {
        return null;
    }
}