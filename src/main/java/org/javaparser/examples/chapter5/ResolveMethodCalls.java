package org.javaparser.examples.chapter5;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.symbolsolver.javaparser.Navigator;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;
import com.github.javaparser.symbolsolver.model.resolution.TypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.ReflectionTypeSolver;

import java.io.FileInputStream;
import java.util.List;

public class ResolveMethodCalls {

    private static final String FILE_PATH = "src/main/java/org/javaparser/examples/chapter5/A.java";

    public static void main(String[] args) throws Exception {
        TypeSolver typeSolver = new ReflectionTypeSolver();
        CompilationUnit cu = JavaParser.parse(new FileInputStream(FILE_PATH));

        List<MethodCallExpr> methodCalls = Navigator.findAllNodesOfGivenClass(cu,
                MethodCallExpr.class);
        methodCalls.forEach(mc ->
                System.out.println(
                        JavaParserFacade.get(typeSolver).solve(mc)
                                .getCorrespondingDeclaration().getQualifiedSignature()));
    }
}
