package com.michaelsnowden.yalcil;

import java.util.List;

/**
 * Created by michael.snowden on 5/5/16.
 */
public class ConsFunction extends AbstractFunction {
    public static final ConsFunction INSTANCE = new ConsFunction();

    @Override
    public RuntimeObject computeResult(StackFrame lookup, List<RuntimeObject> args) {
        if (args.size() != 2) {
            throw new RuntimeException("Cons takes exactly two arguments");
        }
        final RuntimeObject a = args.get(0);
        final RuntimeObject b = args.get(1);
        if (b.getType() != RuntimeType.NODE && b.getType() != RuntimeType.NIL) {
            throw new RuntimeException("Cannot cons a non-node");
        }
        return new Node(a, b.asNode(lookup));
    }
}
