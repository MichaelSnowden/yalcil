package com.michaelsnowden.yalcil;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.misc.NotNull;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.apache.commons.lang3.StringEscapeUtils.escapeHtml4;

/**
 * Created by michael.snowden on 4/29/16.
 */
public class SyntaxHighlighter {

    static String highlight(CharStream charStream) throws IOException {
        YalcilParser parser = Runtime.getParser(charStream);
        final String[] output = {""};
        final int[] depth = {0};
        parser.addParseListener(new YalcilBaseListener() {

            @Override
            public void enterApplication(@NotNull YalcilParser.ApplicationContext ctx) {
                super.enterApplication(ctx);
                output[0] += String.format("<code class=parentheses-%d>(</code>", depth[0]++);
            }

            @Override
            public void exitLiteral(@NotNull YalcilParser.LiteralContext ctx) {
                String klass;
                super.exitLiteral(ctx);
                if (ctx.IDENTIFIER() != null) {
                    klass = "identifier";
                } else if (ctx.INTEGER_LITERAL() != null) {
                    klass = "number";
                } else if (ctx.FLOAT_LITERAL() != null) {
                    klass = "number";
                } else if (ctx.STRING_LITERAL() != null) {
                    klass = "string";
                } else {
                    throw new RuntimeException("I don't know how this is possible");
                }
                output[0] += String.format("<code class=\"" + klass + "\">%s </code>", escapeHtml4(ctx.getText()));
            }

            @Override
            public void exitApplication(@NotNull YalcilParser.ApplicationContext ctx) {
                super.exitApplication(ctx);
                output[0] = output[0].substring(0, output[0].lastIndexOf("<") - 1);
                output[0] += String.format("</code><code class=parentheses-%d>) </code>", depth[0]--);
            }
        });
        parser.program();
        String templateString = "<link rel='stylesheet' type='text/css' href='template.css'>";
        output[0] = String.format("<pre class=yalcil>%s</pre>", output[0]);
        output[0] = templateString + output[0];
        return output[0];
    }

    public static void writeFile(String s, String outfile) throws IOException {
        final FileOutputStream fileOutputStream = new FileOutputStream(outfile, false);
        fileOutputStream.write(s.getBytes());
        fileOutputStream.close();
    }

    public static void main(String[] args) throws IOException {
        String functionName = "bsearch";
        String inputName = functionName + ".txt";
        String outputName = "_" + functionName + ".html";
        String s = highlight(new ANTLRInputStream(SyntaxHighlighter.class.getClassLoader().getResourceAsStream(inputName)));
//        String highlighted = highlight(new ANTLRInputStream(new ByteArrayInputStream("(+ (* 'Hello ' 2) 'World')"
//                .getBytes())));
        writeFile(s, outputName);
    }
}
