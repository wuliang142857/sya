package com.github.magicsky.sya.checkers;


import com.github.magicsky.sya.ast.ASTTranslationUnitCore;
import com.github.magicsky.sya.ast.IASTTranslationUnitCore;
import com.github.magicsky.sya.model.ConfigProperty;
import junit.framework.TestCase;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;
import org.eclipse.cdt.core.parser.ParserLanguage;

import java.io.IOException;

/**
 * @author 
 */
public class BaseTest extends TestCase {

    protected ConfigProperty configProperty = new ConfigProperty();

    protected String rootPath = "/Users/wul/zone/sya/src/test/java";
    public IASTTranslationUnitCore translationUnitCore = new ASTTranslationUnitCore();

    public String getCommentAbove() {
        CharSequence[] charSequences = new CharSequence[0];
        try {
            charSequences = TestSourceReader.getContentsForTest(
                rootPath, getClass(), getName(), 1
            );
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return charSequences[0].toString();
    }

    public IASTTranslationUnit parseCPP(String code) {
        return translationUnitCore.parseCode(code, ParserLanguage.CPP, false, false);
    }

    public IASTTranslationUnit parseC(String code) {
        return translationUnitCore.parseCode(code, ParserLanguage.C, true, false);
    }

}
