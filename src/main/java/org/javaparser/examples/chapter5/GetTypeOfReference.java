package org.javaparser.examples.chapter5;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.expr.AssignExpr;
import com.github.javaparser.resolution.types.ResolvedType;
import com.github.javaparser.symbolsolver.JavaSymbolSolver;
import com.github.javaparser.symbolsolver.model.resolution.TypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.CombinedTypeSolver;

import java.io.File;
import java.io.FileNotFoundException;

public class GetTypeOfReference {

    private static final String FILE_PATH = "src/main/java/org/javaparser/examples/chapter5/Bar.java";

    public static void main(String[] args) throws FileNotFoundException {
        TypeSolver typeSolver = new CombinedTypeSolver();

        JavaSymbolSolver symbolSolver = new JavaSymbolSolver(typeSolver);
        JavaParser.getStaticConfiguration().setSymbolResolver(symbolSolver);

        CompilationUnit cu = JavaParser.parse(new File(FILE_PATH));

        cu.findAll(AssignExpr.class).forEach(ae -> {
            ResolvedType resolvedType = ae.calculateResolvedType();
            System.out.println(ae.toString() + " is a: " + resolvedType);
        });
    }
}
