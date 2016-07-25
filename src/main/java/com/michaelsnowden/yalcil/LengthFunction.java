package com.michaelsnowden.yalcil;

import java.util.List;

/**
 * Created by michael.snowden on 5/5/16.
 */
public class LengthFunction extends AbstractFunction {
    public static final LengthFunction INSTANCE = new LengthFunction();

    @Override
    public RuntimeObject computeResult(StackFrame lookup, List<RuntimeObject> args) {
        final RuntimeObject object = args.get(0);
        if (object.getType() == RuntimeType.STRING) {
            return new IntObject(object.asString(lookup).length());
        }
        if (object.getType() == RuntimeType.NODE) {
            return new IntObject(object.asNode(lookup).getLength());
        }
        throw new RuntimeException("Cannot get the length of a non-string non-node");
    }
}