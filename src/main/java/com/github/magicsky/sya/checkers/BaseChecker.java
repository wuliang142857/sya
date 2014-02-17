package com.github.magicsky.sya.checkers;

import com.github.magicsky.sya.model.CheckResult;
import com.github.mustachejava.Mustache;
import com.google.common.collect.Maps;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

/**
 * @author garcia.wul@alibaba-inc.com
 */
public abstract class BaseChecker implements IChecker {

    protected Logger logger = Logger.getLogger(getClass());

    protected String compileErrorMessage(Mustache template, CheckResult checkResult) {
        Map<String, Object> scopes = Maps.newHashMap();
        scopes.put("checkResult", checkResult);
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
