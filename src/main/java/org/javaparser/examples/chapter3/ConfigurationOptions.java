package org.javaparser.examples.chapter3;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParserConfiguration;

public class ConfigurationOptions {


    public void ignoreComments() {

        ParserConfiguration parserConfiguration = new ParserConfiguration()
                .setAttributeComments(false);

        JavaParser.setStaticConfiguration(parserConfiguration);

    }
    
    public void ignoreFloatingComments() {

        ParserConfiguration parserConfiguration = new ParserConfiguration()
                .setDoNotAssignCommentsPrecedingEmptyLines(true);

        JavaParser.setStaticConfiguration(parserConfiguration);
    }
}
