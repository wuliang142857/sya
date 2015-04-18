package com.github.magicsky.sya.checkers.style;

import com.github.magicsky.sya.checkers.BaseTest;
import com.github.magicsky.sya.checkers.IChecker;
import com.github.magicsky.sya.enumerators.ErrorItem;
import com.github.magicsky.sya.model.CheckResult;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;

import java.util.List;

/**
 * @author 
 */
public class InlineFunctionCheckerTest extends BaseTest {

    private IChecker checker = new InlineFunctionChecker(configProperty);

    // inline void Foo(int x, int y) {
    //  x = 0;
    //  y = 1;
    //  int a = x;
    //  int b = y;
    //  int c = a + b;
    //  int d = a * b;
    //  int e = a - b;
    //  int f = a / b;
    //  ++ x;
    //  ++ y;
    // }
    public void testLongInlineFunction() {
        IASTTranslationUnit translationUnit = parseCPP(getCommentAbove());
        List<CheckResult> checkResults = checker.check(translationUnit);
        assertEquals(1, checkResults.size());
        CheckResult checkResult = checkResults.get(0);
        assertEquals(ErrorItem.INLINE_FUNCTION, checkResult.getErrorItem());
    }

    // inline int main(int x, int y) {
    //  return x + y;
    // }
    public void testMainFunction() {
        IASTTranslationUnit translationUnit = parseCPP(getCommentAbove());
        List<CheckResult> checkResults = checker.check(translationUnit);
        assertEquals(1, checkResults.size());
        CheckResult checkResult = checkResults.get(0);
        assertEquals(ErrorItem.INLINE_FUNCTION, checkResult.getErrorItem());
    }

    // inline int add(int x, int y) {
    //  int r = x + y;
    //  return r > 10 ? r : add(x, y);
    // }
    public void testRecursiveFunction() {
        IASTTranslationUnit translationUnit = parseCPP(getCommentAbove());
        List<CheckResult> checkResults = checker.check(translationUnit);
        assertEquals(1, checkResults.size());
        CheckResult checkResult = checkResults.get(0);
        assertEquals(ErrorItem.INLINE_FUNCTION, checkResult.getErrorItem());
    }

    // inline int add(int x) {
    //  int i = 0;
    //  for (; i < 10; ++i) {
    //      ++ x;
    //  }
    // }
    public void testHasLoopFunction() {
        IASTTranslationUnit translationUnit = parseCPP(getCommentAbove());
        List<CheckResult> checkResults = checker.check(translationUnit);
        assertEquals(1, checkResults.size());
        CheckResult checkResult = checkResults.get(0);
        assertEquals(ErrorItem.INLINE_FUNCTION, checkResult.getErrorItem());
    }

    // class A {
    //  inline ~A() {}
    // };
    public void testIsDestructor() {
        IASTTranslationUnit translationUnit = parseCPP(getCommentAbove());
        List<CheckResult> checkResults = checker.check(translationUnit);
        assertEquals(1, checkResults.size());
        CheckResult checkResult = checkResults.get(0);
        assertEquals(ErrorItem.INLINE_FUNCTION, checkResult.getErrorItem());
    }
}
