package org.javaparser.examples.chapter5;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.symbolsolver.JavaSymbolSolver;
import com.github.javaparser.symbolsolver.model.resolution.TypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.ReflectionTypeSolver;

import java.io.File;

public class ResolveMethodCalls {

    private static final String FILE_PATH = "src/main/java/org/javaparser/examples/chapter5/A.java";

    public static void main(String[] args) throws Exception {
        TypeSolver combinedTypeSolver = new ReflectionTypeSolver();

        JavaSymbolSolver symbolSolver = new JavaSymbolSolver(combinedTypeSolver);
        JavaParser.getStaticConfiguration().setSymbolResolver(symbolSolver);

        CompilationUnit cu = JavaParser.parse(new File(FILE_PATH));

        cu.findAll(MethodCallExpr.class).forEach(mce ->
                System.out.println(mce.resolveInvokedMethod().getQualifiedSignature()));
    }
}
