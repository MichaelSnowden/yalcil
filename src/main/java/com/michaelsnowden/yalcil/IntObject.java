package com.michaelsnowden.yalcil;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by michael.snowden on 4/28/16.
 */
class IntObject extends RuntimeObject {
    private final BigInteger data;

    IntObject(BigInteger data) {
        this.data = data;
    }

    public IntObject(int i) {
        this(BigInteger.valueOf(i));
    }

    public static IntObject fromBoolean(boolean b) {
        return new IntObject(BigInteger.valueOf(b ? 1 : 0));
    }

    @Override
    public RuntimeType getType() {
        return RuntimeType.INT;
    }

    @Override
    public Object asObject(StackFrame lookup) {
        return data;
    }

    @Override
    public BigDecimal asDecimal(StackFrame lookup) {
        return new BigDecimal(data);
    }

    @Override
    public String asString(StackFrame lookup) {
        return String.valueOf(data);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IntObject intObject = (IntObject) o;

        return data != null ? data.equals(intObject.data) : intObject.data == null;

    }

    @Override
    public int hashCode() {
        return data != null ? data.hashCode() : 0;
    }
}
