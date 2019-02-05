package org.javaparser.examples.chapter4;

import com.github.javaparser.ParseResult;
import com.github.javaparser.ParseStart;
import com.github.javaparser.StringProvider;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.printer.lexicalpreservation.LexicalPreservingPrinter;
import com.github.javaparser.utils.Pair;

public class LexicalPreservationComplete {

    public static void main(String[] args) {
        String code = "// Hey, this is a comment\n\n\n// Another one\n\nclass A { }";
        Pair<ParseResult<CompilationUnit>, LexicalPreservingPrinter> result = LexicalPreservingPrinter.setup(
                ParseStart.COMPILATION_UNIT, new StringProvider(code));
        CompilationUnit cu = result.a.getResult().get();
        LexicalPreservingPrinter lpp = result.b;
        System.out.println(lpp.print(cu));

        System.out.println("----------------");

        ClassOrInterfaceDeclaration myClass = cu.getClassByName("A").get();
        myClass.setName("MyNewClassName");
        System.out.println(lpp.print(cu));

        System.out.println("----------------");

        myClass = cu.getClassByName("MyNewClassName").get();
        myClass.setName("MyNewClassName");
        myClass.addModifier(Modifier.Keyword.PUBLIC);
        System.out.println(lpp.print(cu));

        System.out.println("----------------");

        myClass = cu.getClassByName("MyNewClassName").get();
        myClass.setName("MyNewClassName");
        myClass.addModifier(Modifier.Keyword.PUBLIC);
        cu.setPackageDeclaration("org.javaparser.samples");
        System.out.println(lpp.print(cu));
    }
}
