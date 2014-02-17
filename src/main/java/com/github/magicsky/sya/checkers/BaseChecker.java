package com.github.magicsky.sya.checkers;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

/**
 * @author garcia.wul@alibaba-inc.com
 */
public abstract class BaseChecker implements IChecker {

    protected Logger logger = Logger.getLogger(getClass());

    private MustacheFactory mustacheFactory = new DefaultMustacheFactory();

    protected String compileErrorMessage(String message, Map<String, Object> scopes) {
        Mustache template = mustacheFactory.compile(new StringReader(message), "example");

        Writer writer = new StringWriter();
        template.execute(writer, scopes);
        try {
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return writer.toString();
    }
}
