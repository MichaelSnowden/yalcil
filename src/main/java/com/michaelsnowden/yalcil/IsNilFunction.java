package com.michaelsnowden.yalcil;

import java.util.List;

/**
 * Created by michael.snowden on 5/6/16.
 */
public class IsNilFunction extends AbstractFunction {
    public static final IsNilFunction INSTANCE = new IsNilFunction();

    @Override
    public RuntimeObject computeResult(StackFrame lookup, List<RuntimeObject> args) {
        return new IntObject(args.get(0).getType() == RuntimeType.NIL ? 1 : 0);
    }
}
