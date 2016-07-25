package com.michaelsnowden.yalcil;

import java.util.List;

/**
 * Created by michael.snowden on 5/6/16.
 */
public class IsNodeFunction extends AbstractFunction {
    public static final IsNodeFunction INSTANCE = new IsNodeFunction();

    @Override
    public RuntimeObject computeResult(StackFrame lookup, List<RuntimeObject> args) {
        return new IntObject(args.get(0).getType() == RuntimeType.NODE ? 1 : 0);
    }
}
