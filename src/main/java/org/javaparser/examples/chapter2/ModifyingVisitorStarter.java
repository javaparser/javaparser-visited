package org.javaparser.examples.chapter2;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;

import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ModifyingVisitorStarter {
    private static final String FILE_PATH
            = "src/main/java/org/javaparser/samples/ReversePolishNotation.java";

    public static void main(String[] args) throws Exception {

        CompilationUnit cu = StaticJavaParser
                .parse(Files.newInputStream(Paths.get(FILE_PATH)));
    }
}
