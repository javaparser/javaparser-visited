package org.javaparser.examples.chapter2;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

public class CommentReporterComplete {

    private static final String FILE_PATH = "src/main/java/org/javaparser/samples/ReversePolishNotation.java";

    public static void main(String[] args) throws Exception {

        CompilationUnit cu = StaticJavaParser.parse(new File(FILE_PATH));

        List<CommentReportEntry> comments = cu.getAllContainedComments()
                .stream()
                .map(p -> new CommentReportEntry(p.getClass().getSimpleName(),
                        p.getContent(),
                        p.getRange().map(r -> r.begin.line).orElse(-1),
                        !p.getCommentedNode().isPresent()))
                .collect(Collectors.toList());

        comments.forEach(System.out::println);
    }


    private static class CommentReportEntry {
        private String type;
        private String text;
        private int lineNumber;
        private boolean isOrphan;

        CommentReportEntry(String type, String text, int lineNumber, boolean isOrphan) {
            this.type = type;
            this.text = text;
            this.lineNumber = lineNumber;
            this.isOrphan = isOrphan;
        }

        @Override
        public String toString() {
            return lineNumber + "|" + type + "|" + isOrphan + "|" + text.replaceAll("\\n","").trim();
        }
    }
}
