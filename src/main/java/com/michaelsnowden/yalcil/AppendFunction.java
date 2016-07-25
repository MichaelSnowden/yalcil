package com.michaelsnowden.yalcil;

import java.util.List;
import java.util.function.BinaryOperator;

/**
 * Created by michael.snowden on 5/10/16.
 */
public class AppendFunction extends AbstractFunction {
    public static final AppendFunction INSTANCE = new AppendFunction();

    @Override
    protected RuntimeObject computeResult(StackFrame lookup, List<RuntimeObject> args) {
        final RuntimeObject object = args.get(0);
        if (object.getType() != RuntimeType.NODE && object.getType() != RuntimeType.NIL) {
            throw new RuntimeException("Cannot append to non-node non-nil");
        }
        return args.stream().reduce(new BinaryOperator<RuntimeObject>() {
            @Override
            public RuntimeObject apply(RuntimeObject a, RuntimeObject b) {
                if (a.isNil()) {
                    return b;
                } else if (b.isNil()) {
                    return a;
                }
                Node link = a.asNode(lookup);
                while (link.getLink() != null) {
                    link = link.getLink();
                }
                link.setLink(b.asNode(lookup));
                return a;
            }
        }).get();
    }
}
