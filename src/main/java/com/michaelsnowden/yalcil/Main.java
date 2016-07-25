package com.michaelsnowden.yalcil;

import jline.console.ConsoleReader;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.apache.commons.cli.ParseException;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * Created by michael.snowden on 4/29/16.
 */
public class Main {
    public static void run(String[] args) throws IOException, ParseException {
        java.lang.Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.out.println();
            }
        });
        if (args.length > 0) {
            final String arg = args[0];
            final String run = Runtime.run(new ANTLRFileStream(arg));
            System.out.println(run);
            return;
        }
        ConsoleReader console = new ConsoleReader();
        console.setPrompt("yalcil> ");
        String line;
        while ((line = console.readLine()) != null) {
            try {
                String evaluate = Runtime.run(new ANTLRInputStream(new ByteArrayInputStream(line.getBytes())));
                System.out.println(evaluate);
            } catch (Error | Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException, ParseException {
        run(args);
    }
}