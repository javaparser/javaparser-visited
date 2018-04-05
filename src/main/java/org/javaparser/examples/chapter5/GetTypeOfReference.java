package org.javaparser.examples.chapter5;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.expr.AssignExpr;
import com.github.javaparser.symbolsolver.javaparser.Navigator;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;
import com.github.javaparser.symbolsolver.model.resolution.TypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.CombinedTypeSolver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GetTypeOfReference {

    private static final String FILE_PATH = "src/main/java/org/javaparser/examples/chapter5/Bar.java";

    public static void main(String[] args) throws FileNotFoundException {
        TypeSolver typeSolver = new CombinedTypeSolver();

        CompilationUnit cu = JavaParser.parse(new FileInputStream(FILE_PATH));
        AssignExpr assignExpr = Navigator.findNodeOfGivenClass(cu, AssignExpr.class);

        System.out.println(String.format("Type of %s is %s",
                assignExpr, JavaParserFacade.get(typeSolver).getType(assignExpr)));
    }
}
