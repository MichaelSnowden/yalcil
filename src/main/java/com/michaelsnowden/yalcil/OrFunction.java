package com.michaelsnowden.yalcil;

import java.util.List;
import java.util.function.BinaryOperator;

/**
 * Created by michael.snowden on 5/12/16.
 */
public class OrFunction extends AbstractFunction {
    public static final OrFunction INSTANCE = new OrFunction();

    @Override
    protected RuntimeObject computeResult(StackFrame lookup, List<RuntimeObject> args) {
        return args.stream().reduce(new BinaryOperator<RuntimeObject>() {
            @Override
            public RuntimeObject apply(RuntimeObject a, RuntimeObject b) {
                return new IntObject(a.asInt(lookup).or(b.asInt(lookup)));
            }
        }).get();
    }
}
