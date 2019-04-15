package org.javaparser.examples.chapter4;

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.comments.LineComment;
import com.github.javaparser.ast.expr.MarkerAnnotationExpr;
import com.github.javaparser.ast.expr.NormalAnnotationExpr;
import com.github.javaparser.ast.expr.SingleMemberAnnotationExpr;
import com.github.javaparser.printer.PrettyPrintVisitor;
import com.github.javaparser.printer.PrettyPrinter;
import com.github.javaparser.printer.PrettyPrinterConfiguration;

public class PrettyPrintVisitorComplete {

    public static void main(String[] args) {
        ClassOrInterfaceDeclaration myClass = new ClassOrInterfaceDeclaration();
        myClass.setComment(new LineComment("A very cool class!"));
        myClass.setName("MyClass");
        myClass.addField("String", "foo");
        myClass.addAnnotation("MySecretAnnotation");

        PrettyPrinterConfiguration conf = new PrettyPrinterConfiguration();
        conf.setIndentSize(2);
        conf.setIndentType(PrettyPrinterConfiguration.IndentType.SPACES);
        conf.setPrintComments(false);
        conf.setVisitorFactory(prettyPrinterConfiguration -> new PrettyPrintVisitor(conf) {

            @Override
            public void visit(MarkerAnnotationExpr n, Void arg) {
                // ignore
            }

            @Override
            public void visit(SingleMemberAnnotationExpr n, Void arg) {
                // ignore
            }

            @Override
            public void visit(NormalAnnotationExpr n, Void arg) {
                // ignore
            }

        });
        PrettyPrinter prettyPrinter = new PrettyPrinter(conf);
        System.out.println(prettyPrinter.print(myClass));
    }

}
