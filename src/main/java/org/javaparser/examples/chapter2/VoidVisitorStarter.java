package org.javaparser.examples.chapter2;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;

import java.io.FileInputStream;

public class VoidVisitorStarter {

    private static final String FILE_PATH = "src/main/java/org/javaparser/samples/ReversePolishNotation.java";

    public static void main(String[] args) throws Exception {

        CompilationUnit cu = JavaParser.parse(new FileInputStream(FILE_PATH));

    }

}
