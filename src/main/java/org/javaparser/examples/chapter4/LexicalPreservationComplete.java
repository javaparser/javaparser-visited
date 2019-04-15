package org.javaparser.examples.chapter4;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.printer.lexicalpreservation.LexicalPreservingPrinter;

public class LexicalPreservationComplete {

    public static void main(String[] args) {
        String code = "// Hey, this is a comment\n\n\n// Another one\n\nclass A { }";
        CompilationUnit cu = StaticJavaParser.parse(code);
        LexicalPreservingPrinter.setup(cu);

        System.out.println(LexicalPreservingPrinter.print(cu));

        System.out.println("----------------");

        ClassOrInterfaceDeclaration myClass = cu.getClassByName("A").get();
        myClass.setName("MyNewClassName");
        System.out.println(LexicalPreservingPrinter.print(cu));

        System.out.println("----------------");

        myClass = cu.getClassByName("MyNewClassName").get();
        myClass.setName("MyNewClassName");
        myClass.addModifier(Modifier.Keyword.PUBLIC);
        System.out.println(LexicalPreservingPrinter.print(cu));

        System.out.println("----------------");

        myClass = cu.getClassByName("MyNewClassName").get();
        myClass.setName("MyNewClassName");
        myClass.addModifier(Modifier.Keyword.PUBLIC);
        cu.setPackageDeclaration("org.javaparser.samples");
        System.out.println(LexicalPreservingPrinter.print(cu));
    }
}
