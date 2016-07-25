package com.michaelsnowden.yalcil;

import java.util.List;
import java.util.function.BinaryOperator;

import static com.michaelsnowden.yalcil.RuntimeType.*;
import static java.util.Collections.nCopies;

/**
 * Created by michael.snowden on 4/28/16.
 */
class MulFunction extends AbstractFunction {
    public static final MulFunction INSTANCE = new MulFunction();

    @Override
    public RuntimeObject computeResult(StackFrame lookup, List<RuntimeObject> args) {
        return args.stream().reduce(new BinaryOperator<RuntimeObject>() {
            @Override
            public RuntimeObject apply(RuntimeObject a, RuntimeObject b) {
                RuntimeType at = a.getType();
                RuntimeType bt = b.getType();
                if (at == INT && bt == INT) {
                    return new IntObject(a.asInt(lookup).multiply(b.asInt(lookup)));
                } else if (at == INT && bt == DECIMAL) {
                    return new DecimalObject(a.asDecimal(lookup).multiply(b.asDecimal(lookup)));
                } else if (at == DECIMAL && bt == INT) {
                    return new DecimalObject(a.asDecimal(lookup).multiply(b.asDecimal(lookup)));
                } else if (at == STRING && bt == INT) {
                    return new StringObject(String.join("", nCopies(b.asInt(lookup).intValue(), a.asString(lookup))));
                } else if (at == INT && bt == STRING) {
                    return new StringObject(String.join("", nCopies(a.asInt(lookup).intValue(), b.asString(lookup))));
                } else if (at == DECIMAL && bt == DECIMAL) {
                    return new DecimalObject(a.asDecimal(lookup).multiply(b.asDecimal(lookup)));
                } else {
                    throw new UnsupportedOperationException(String.format("Cannot multiply types %s and %s", at, bt));
                }
            }
        }).get();
    }
}
