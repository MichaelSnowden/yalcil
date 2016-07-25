package com.michaelsnowden.yalcil;

import java.util.List;

/**
 * Created by michael.snowden on 5/5/16.
 */
public class CarFunction extends AbstractFunction {
    public static final CarFunction INSTANCE = new CarFunction();

    @Override
    public RuntimeObject computeResult(StackFrame lookup, List<RuntimeObject> args) {
        final RuntimeObject object = args.get(0);
        if (object.getType() == RuntimeType.NODE) {
            return object.asNode(lookup).getData();
        }
        if (object.getType() == RuntimeType.STRING) {
            return new StringObject(object.asString(lookup).substring(0, 1));
        }
        throw new RuntimeException("Cannot get the car of a non-none non-string");
    }
}