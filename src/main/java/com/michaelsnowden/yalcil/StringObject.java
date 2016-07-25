package com.michaelsnowden.yalcil;

/**
 * Created by michael.snowden on 4/28/16.
 */
class StringObject extends RuntimeObject {
    private final String text;

    StringObject(String text) {
        this.text = text.replace("\\n", System.lineSeparator());
    }

    @Override
    public RuntimeType getType() {
        return RuntimeType.STRING;
    }

    @Override
    public Object asObject(StackFrame lookup) {
        return text;
    }

    @Override
    public String asString(StackFrame lookup) {
        return text;
    }

    @Override
    public String toString() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StringObject that = (StringObject) o;

        return text != null ? text.equals(that.text) : that.text == null;

    }

    @Override
    public int hashCode() {
        return text != null ? text.hashCode() : 0;
    }
}