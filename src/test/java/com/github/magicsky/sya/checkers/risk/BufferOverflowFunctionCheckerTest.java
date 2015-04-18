package com.github.magicsky.sya.checkers.risk;

import com.github.magicsky.sya.checkers.BaseTest;
import com.github.magicsky.sya.checkers.IChecker;
import com.github.magicsky.sya.enumerators.ErrorItem;
import com.github.magicsky.sya.model.CheckResult;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;

import java.util.List;

/**
 * @author 
 */
public class BufferOverflowFunctionCheckerTest extends BaseTest {

    private IChecker checker = new BufferOverflowFunctionChecker(configProperty);

//    int main () {
//        char str1[] = "Sample string";
//        char str2[40];
//        strcpy (str2,str1);
//        return 0;
//    }
    public void testUsingStrcpy() {
        String code = getCommentAbove();
        IASTTranslationUnit translationUnit = parseCPP(code);
        List<CheckResult> checkResults = checker.check(translationUnit);
        assertTrue(checkResults.size() > 0);
        CheckResult checkResult = checkResults.get(0);
        assertEquals(ErrorItem.BUFFER_OVERFLOW_FUNCTION.getValue(), checkResult.getErrorItem().getValue());
    }
}
