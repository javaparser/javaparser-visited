package org.javaparser.examples.chapter2;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.comments.Comment;

import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CommentReporterStarter {

    private static final String FILE_PATH =
            "src/main/java/org/javaparser/samples/ReversePolishNotation.java";

    public static void main(String[] args) throws Exception {

        CompilationUnit cu = StaticJavaParser
                .parse(Files.newInputStream(Paths.get(FILE_PATH)));

        List<Comment> comments = cu.getAllContainedComments();
    }
}
