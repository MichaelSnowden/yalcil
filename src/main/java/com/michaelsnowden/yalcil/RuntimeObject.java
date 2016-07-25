package com.michaelsnowden.yalcil;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by michael.snowden on 4/28/16.
 */
public abstract class RuntimeObject {
    abstract RuntimeType getType();

    abstract Object asObject(StackFrame lookup);

    public BigDecimal asDecimal(StackFrame lookup) {
        return (BigDecimal) asObject(lookup);
    }

    public BigInteger asInt(StackFrame lookup) {
        return (BigInteger) asObject(lookup);
    }

    public String asString(StackFrame lookup) {
        return (String) asObject(lookup);
    }

    public Node asNode(StackFrame lookup) {
        return (Node) asObject(lookup);
    }

    public String asRepr(StackFrame lookup) {
        return asString(lookup);
    }

    @Override
    public String toString() {
        return asString(null);
    }

    public boolean canCache() {
        return true;
    }

    public boolean isNil() {
        return false;
    }

    boolean isInt() {
        return getType() == RuntimeType.INT;
    }

    boolean isDecimal() {
        return getType() == RuntimeType.DECIMAL;
    }

    boolean isString() {
        return getType() == RuntimeType.STRING;
    }
}