package com.michaelsnowden.yalcil;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by michael.snowden on 4/30/16.
 */
class Promise extends RuntimeObject {
    private final StackFrame lookup;
    private final List<YalcilParser.ExpressionContext> argContexts;
    private final AbstractFunction function;
    private boolean cached = false;
    private RuntimeObject result = null;

    public Promise(StackFrame lookup, List<YalcilParser.ExpressionContext> argContexts,
                   AbstractFunction function) {
        this.lookup = lookup;
        this.argContexts = argContexts;
        this.function = function;
    }

    RuntimeObject computeResult() {
        List<RuntimeObject> args = new ArrayList<>(argContexts.size() - 1);
        for (int i = 1; i < argContexts.size(); ++i) {
            try {
                args.add(Runtime.run(argContexts.get(i), lookup));
            } catch (IOException e) {
                throw new RuntimeException(e.getLocalizedMessage());
            }
        }
        return function.getResult(lookup, args);
    }

    @Override
    public RuntimeType getType() {
        return getResult().getType();
    }

    RuntimeObject getResult() {
        if (!cached) {
            result = computeResult();
            cached = true;
        }
        return result;
    }

    @Override
    public Object asObject(StackFrame ignored) {
        return getResult().asObject(lookup);
    }

    @Override
    public String asString(StackFrame ignored) {
        return getResult().asString(lookup);
    }

    @Override
    public BigDecimal asDecimal(StackFrame ignored) {
        return getResult().asDecimal(lookup);
    }

    @Override
    public BigInteger asInt(StackFrame ignored) {
        return getResult().asInt(lookup);
    }

    @Override
    public Node asNode(StackFrame ignored) {
        return getResult().asNode(lookup);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Promise that = (Promise) o;

        return getResult() != null ? getResult().equals(that.getResult()) : that.getResult() == null;

    }

    @Override
    public int hashCode() {
        return getResult() != null ? getResult().hashCode() : 0;
    }

    @Override
    public String toString() {
        return asString(null);
    }

    @Override
    public boolean isNil() {
        return getResult().isNil();
    }

    @Override
    public boolean canCache() {
        return false;
    }
}