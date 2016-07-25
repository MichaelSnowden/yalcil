package com.michaelsnowden.yalcil;

import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by michael.snowden on 4/30/16.
 */
class LambdaFunction extends AbstractFunction {
    private final YalcilParser.AbstractionContext context;

    LambdaFunction(YalcilParser.AbstractionContext context) {
        super();
        this.context = context;
    }

    @Override
    public RuntimeObject computeResult(StackFrame lookup, List<RuntimeObject> args) {
        StackFrame child = new StackFrame(lookup);
        if (context.name != null) {
            child.setObject(context.name.getText(), this);
            for (int i = 0; i < args.size(); ++i) {
                child.setObject(context.IDENTIFIER(i + 1).getText(), args.get(i));
            }
        } else {
            for (int i = 0; i < args.size(); ++i) {
                child.setObject(context.IDENTIFIER(i).getText(), args.get(i));
            }
        }
        try {
            return Runtime.run(context.expression(), child);
        } catch (IOException e) {
            throw new RuntimeException(e.getLocalizedMessage());
        }
    }

    @Override
    public String asString(StackFrame ignored) {
        return "Function{" + context.IDENTIFIER().stream().map(TerminalNode::toString).collect
                (Collectors.joining(", ")) + "}";
    }

//    TODO: Fix this
//    @Override
//    public boolean canCache() {
//        return false;
//    }
}
