package com.michaelsnowden.yalcil;

/**
 * Created by michael.snowden on 5/5/16.
 */
public class Node extends RuntimeObject {
    private RuntimeObject data;
    private Node right;

    public Node(RuntimeObject data) {
        this(data, null);
    }

    public Node(RuntimeObject data, Node right) {
        this.right = right;
        this.data = data;
    }

    @Override
    RuntimeType getType() {
        return RuntimeType.NODE;
    }

    @Override
    Object asObject(StackFrame lookup) {
        return this;
    }

    @Override
    public Node asNode(StackFrame lookup) {
        return this;
    }

    public Node getLink() {
        return right;
    }

    public void setLink(Node right) {
        this.right = right;
    }

    public RuntimeObject getData() {
        return data;
    }

    public void setData(RuntimeObject data) {
        this.data = data;
    }

    @Override
    public String asString(StackFrame ignored) {
//        if (data.getType() == RuntimeType.NODE) {
//            return "(" + data + ")" + (right == null ? "" : " " + right);
//        }
//        return data.toString() + (right == null ? "" : " " + right);
//        return "(" + data + " " + (right == null ? "nil" : right) + ")";
        String s = "(";
        Node node = this;
        while (node != null) {
            s += node.data;
            node = node.getLink();
            if (node != null) {
                s += " ";
            }
        }
        s += ")";
        return s;
    }

    public int getLength() {
        if (right == null) {
            return 1;
        }
        return 1 + right.getLength();
    }

    @Override
    public boolean equals(Object o) {
        return this == o;
    }

    @Override
    public int hashCode() {
        return System.identityHashCode(this);
    }
}
