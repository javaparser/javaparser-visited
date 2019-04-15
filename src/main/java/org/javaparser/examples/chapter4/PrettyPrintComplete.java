package org.javaparser.examples.chapter4;

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.comments.LineComment;
import com.github.javaparser.printer.PrettyPrinter;
import com.github.javaparser.printer.PrettyPrinterConfiguration;

public class PrettyPrintComplete {

    public static void main(String[] args) {
        ClassOrInterfaceDeclaration myClass = new ClassOrInterfaceDeclaration();
        myClass.setComment(new LineComment("A very cool class!"));
        myClass.setName("MyClass");
        myClass.addField("String", "foo");

        PrettyPrinterConfiguration conf = new PrettyPrinterConfiguration();
        conf.setIndentSize(1);
        conf.setIndentType(PrettyPrinterConfiguration.IndentType.SPACES);
        conf.setPrintComments(false);
        PrettyPrinter prettyPrinter = new PrettyPrinter(conf);
        System.out.println(prettyPrinter.print(myClass));
    }
}
