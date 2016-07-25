package com.michaelsnowden.yalcil;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by michael.snowden on 5/6/16.
 */
public class NilObject extends RuntimeObject {
    public static final NilObject INSTANCE = new NilObject();

    private NilObject() {}

    @Override
    RuntimeType getType() {
        return RuntimeType.NIL;
    }

    @Override
    Object asObject(StackFrame lookup) {
        return null;
    }

    @Override
    public BigDecimal asDecimal(StackFrame lookup) {
        throw new RuntimeException("Cannot cast nil to float");
    }

    @Override
    public BigInteger asInt(StackFrame lookup) {
        throw new RuntimeException("Cannot cast nil to int");
    }

    @Override
    public String asString(StackFrame lookup) {
        return "nil";
    }

    @Override
    public Node asNode(StackFrame lookup) {
        return null;
    }

    public boolean equals(Object o) {
        return this == o;
    }

    @Override
    public int hashCode() {
        return this.getClass().hashCode();
    }

    public boolean isNil() {
        return true;
    }
}