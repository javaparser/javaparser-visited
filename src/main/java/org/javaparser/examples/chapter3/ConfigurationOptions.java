package org.javaparser.examples.chapter3;

import com.github.javaparser.ParserConfiguration;
import com.github.javaparser.StaticJavaParser;

public class ConfigurationOptions {


    public void ignoreComments() {

        ParserConfiguration parserConfiguration = new ParserConfiguration()
                .setAttributeComments(false);

        StaticJavaParser.setConfiguration(parserConfiguration);

    }

    public void ignoreFloatingComments() {

        ParserConfiguration parserConfiguration = new ParserConfiguration()
                .setDoNotAssignCommentsPrecedingEmptyLines(true);

        StaticJavaParser.setConfiguration(parserConfiguration);
    }
}
