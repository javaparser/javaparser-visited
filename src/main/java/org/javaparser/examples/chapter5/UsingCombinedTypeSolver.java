package org.javaparser.examples.chapter5;

import com.github.javaparser.symbolsolver.model.resolution.TypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.CombinedTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.JarTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.JavaParserTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.ReflectionTypeSolver;

import java.io.File;
import java.io.IOException;

public class UsingCombinedTypeSolver {

    public static void main(String[] args) throws IOException {
        TypeSolver myTypeSolver = new CombinedTypeSolver(
                new ReflectionTypeSolver(),
                JarTypeSolver.getJarTypeSolver("jars/library1.jar"),
                JarTypeSolver.getJarTypeSolver("jars/library2.jar"),
                JarTypeSolver.getJarTypeSolver("jars/library3.jar"),
                new JavaParserTypeSolver(new File("src/main/java")),
                new JavaParserTypeSolver(new File("generated_code"))
        );
        // using myTypeSolver
    }
}
