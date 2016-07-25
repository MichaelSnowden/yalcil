package com.michaelsnowden.yalcil;

import java.util.List;

/**
 * Created by michael.snowden on 5/10/16.
 */
public class ListFunction extends AbstractFunction {
    public static final ListFunction INSTANCE = new ListFunction();

    @Override
    protected RuntimeObject computeResult(StackFrame lookup, List<RuntimeObject> args) {
        Node node = new Node(args.get(0), null);
        Node head = node;
        for (int i = 1; i < args.size(); ++i) {
            Node link = new Node(args.get(i), null);
            node.setLink(link);
            node = link;
        }
        return head;
    }
}
