package com.michaelsnowden.yalcil;

import java.util.List;

/**
 * Created by michael.snowden on 5/5/16.
 */
public class CdrFunction extends AbstractFunction {
    public static final CdrFunction INSTANCE = new CdrFunction();

    @Override
    public RuntimeObject computeResult(StackFrame lookup, List<RuntimeObject> args) {
        final RuntimeObject object = args.get(0);
        if (object.getType() == RuntimeType.NODE) {
            final Node link = object.asNode(lookup).getLink();
            if (link == null) {
                return NilObject.INSTANCE;
            } else {
                return link;
            }
        }
        if (object.getType() == RuntimeType.STRING) {
            return new StringObject(object.asString(lookup).substring(1));
        }
        throw new RuntimeException("Cannot get the head of a non-node non-string");
    }
}
