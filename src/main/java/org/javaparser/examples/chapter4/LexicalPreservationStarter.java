package org.javaparser.examples.chapter4;

import com.github.javaparser.ParseResult;
import com.github.javaparser.ParseStart;
import com.github.javaparser.StringProvider;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.printer.lexicalpreservation.LexicalPreservingPrinter;
import com.github.javaparser.utils.Pair;

public class LexicalPreservationStarter {

    public static void main(String[] args) {
        String code = "class A { }";
        Pair<ParseResult<CompilationUnit>, LexicalPreservingPrinter> result = LexicalPreservingPrinter.setup(
                ParseStart.COMPILATION_UNIT, new StringProvider(code));
        CompilationUnit cu = result.a.getResult().get();
        LexicalPreservingPrinter lpp = result.b;
        System.out.println(lpp.print(cu));
    }

}
