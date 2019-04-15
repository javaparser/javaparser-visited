package org.javaparser.examples.chapter4;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.printer.lexicalpreservation.LexicalPreservingPrinter;

public class LexicalPreservationStarter {

    public static void main(String[] args) {
        String code = "class A { }";
        CompilationUnit cu = StaticJavaParser.parse(code);
        LexicalPreservingPrinter.setup(cu);
        System.out.println(LexicalPreservingPrinter.print(cu));
    }

}
