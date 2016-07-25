package com.michaelsnowden.yalcil;

import org.antlr.v4.runtime.ANTLRFileStream;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by michael.snowden on 4/29/16.
 */
class OpenFunction extends AbstractFunction {
    public static final OpenFunction INSTANCE = new OpenFunction();

    private OpenFunction() {}

    @Override
    public RuntimeObject computeResult(StackFrame lookup, List<RuntimeObject> args) {
        if (args.get(0).getType() != RuntimeType.STRING) {
            throw new RuntimeException("Can only open files with a string path, not: " + args.get(0).toString());
        }
        final String s = args.get(0).asString(lookup);
        String fileName = s + ".txt";
        ANTLRFileStream fileStream;
        try {
            fileStream = new ANTLRFileStream(fileName);
        } catch (IOException e) {
            throw new RuntimeException("Could not open the file " + fileName);
        }
        YalcilParser parser = Runtime.getParser(fileStream);
        try {
            final RuntimeObject file = Runtime.run(parser.expression(), lookup);
            return file;
        } catch (IOException e) {
            throw new RuntimeException(e.getLocalizedMessage());
        }
    }

//    TODO: Fix this
//    @Override
//    public boolean canCache() {
//        return false;
//    }
}
