package com.michaelsnowden.yalcil;

import java.math.BigDecimal;

/**
 * Created by michael.snowden on 4/28/16.
 */
class DecimalObject extends RuntimeObject {
    private final BigDecimal data;

    DecimalObject(BigDecimal data) {
        this.data = data;
    }

    public DecimalObject(double v) {
        this(BigDecimal.valueOf(v));
    }

    @Override
    public RuntimeType getType() {
        return RuntimeType.DECIMAL;
    }

    @Override
    public Object asObject(StackFrame lookup) {
        return data;
    }

    @Override
    public BigDecimal asDecimal(StackFrame lookup) {
        return data;
    }

    @Override
    public String asString(StackFrame lookup) {
        return String.valueOf(data);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DecimalObject that = (DecimalObject) o;

        return data != null ? data.equals(that.data) : that.data == null;

    }

    @Override
    public int hashCode() {
        return data != null ? data.hashCode() : 0;
    }
}