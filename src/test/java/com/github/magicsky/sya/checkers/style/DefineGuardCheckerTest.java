package com.github.magicsky.sya.checkers.style;

import com.github.magicsky.sya.checkers.BaseTest;
import com.github.magicsky.sya.checkers.IChecker;
import com.github.magicsky.sya.enumerators.ErrorItem;
import com.github.magicsky.sya.model.CheckResult;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;

import java.util.List;

/**
 * @author garcia.wul@alibaba-inc.com
 */
public class DefineGuardCheckerTest extends BaseTest {

    {
        configProperty.getHeaderEndsWith().add("<testcode>");
    }

    private IChecker checker = new DefineGuardChecker(configProperty);

    // class A {};
    public void testMissingDefineGuard() {
        IASTTranslationUnit translationUnit = parseCPP(getCommentAbove());
        List<CheckResult> checkResults = checker.check(translationUnit);
        assertTrue(checkResults.size() > 0);
        assertEquals(ErrorItem.DEFINE_GUARD, checkResults.get(0).getErrorItem());
    }

    // #ifndef TEST_H_
    // #define TEST_H_
    // class A() {};
    // #endif // TEST_H_
    public void testUsingDefineGuard() {
        IASTTranslationUnit translationUnit = parseCPP(getCommentAbove());
        List<CheckResult> checkResults = checker.check(translationUnit);
        assertTrue(checkResults.size() == 0);
    }
}
