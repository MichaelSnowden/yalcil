package com.michaelsnowden.yalcil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by michael.snowden on 4/28/16.
 */
abstract class AbstractFunction extends RuntimeObject {
    private final Map<List<RuntimeObject>, RuntimeObject> map;

    protected AbstractFunction() {
        this.map = new HashMap<>();
    }

    @Override
    public RuntimeType getType() {
        return RuntimeType.FUNCTION;
    }

    @Override
    public Object asObject(StackFrame lookup) {
        return this;
    }

    protected abstract RuntimeObject computeResult(StackFrame lookup, List<RuntimeObject> args);

    public RuntimeObject getResult(StackFrame lookup, List<RuntimeObject> args) {
        if (!canCache()) {
            return this.computeResult(lookup, args);
        }
        if (map.containsKey(args)) {
            return get(args);
        }
        RuntimeObject result = computeResult(lookup, args);
        map.put(args, result);
        return result;
    }

    private RuntimeObject get(List<RuntimeObject> args) {
        return map.get(args);
    }

    @Override
    public String asString(StackFrame lookup) {
        return this.getClass().toString();
    }

    @Override
    public boolean equals(Object o) {
        return this == o;
    }

    @Override
    public int hashCode() {
        return this.getClass().hashCode();
    }

    @Override
    public final boolean canCache() {
        return false;
    }
}