package com.michaelsnowden.yalcil;

import java.util.List;
import java.util.function.BinaryOperator;

/**
 * Created by michael.snowden on 5/12/16.
 */
public class AndFunction extends AbstractFunction {
    public static final AndFunction INSTANCE = new AndFunction();

    @Override
    protected RuntimeObject computeResult(StackFrame lookup, List<RuntimeObject> args) {
        return args.stream().reduce(new BinaryOperator<RuntimeObject>() {
            @Override
            public RuntimeObject apply(RuntimeObject a, RuntimeObject b) {
                return new IntObject(a.asInt(lookup).and(b.asInt(lookup)));
            }
        }).get();
    }
}