package com.github.magicsky.sya.unittests.checkers;


import com.github.magicsky.sya.ast.ASTTranslationUnitCore;
import com.github.magicsky.sya.ast.IASTTranslationUnitCore;
import junit.framework.TestCase;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;
import org.eclipse.cdt.core.parser.ParserLanguage;

import java.io.IOException;

/**
 * @author garcia.wul@alibaba-inc.com
 */
public class BaseTest extends TestCase {

    protected String rootPath = "/Users/wul/zone/sya/src/test/java";
    protected IASTTranslationUnitCore translationUnitCore = new ASTTranslationUnitCore();

    protected String getCommentAbove() {
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

    protected IASTTranslationUnit parseCPP(String code) {
        return translationUnitCore.parseCode(code, ParserLanguage.CPP, true, false);
    }
}
