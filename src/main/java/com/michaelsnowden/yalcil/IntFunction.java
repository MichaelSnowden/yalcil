package com.michaelsnowden.yalcil;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 * Created by michael.snowden on 5/16/16.
 */
public class IntFunction extends AbstractFunction {
    public static final IntFunction INSTANCE = new IntFunction();

    private IntFunction() {}

    @Override
    protected RuntimeObject computeResult(StackFrame lookup, List<RuntimeObject> args) {
        final RuntimeObject a = args.get(0);
        if (a.isInt()) {
            return a;
        } else if (a.isDecimal()) {
            return new IntObject(a.asDecimal(lookup).toBigInteger());
        } else if (a.isString()) {
            return new IntObject(new BigDecimal(a.asString(lookup)).toBigInteger());
        } else {
            throw new RuntimeException("Don't know how to convert this to an int: " + a.toString());
        }
    }

}
