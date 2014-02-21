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
public class IncludesOrderCheckerTest extends BaseTest {

    private IChecker checker = new IncludesOrderChecker(configProperty);

//    #include "base/basictypes.h"
//    #include "base/commandlineflags.h"
//    #include "foo/public/bar.h"
//    #include <sys/types.h>
    public void testUnreasonableOrders() {
        IASTTranslationUnit translationUnit = parseCPP(getCommentAbove());
        List<CheckResult> checkResults = checker.check(translationUnit);
        assertEquals(1, checkResults.size());
        assertEquals(ErrorItem.INCLUDES_ORDER, checkResults.get(0).getErrorItem());
    }

//    #include <sys/types.h>
//    #include <unistd.h>
//
//    #include <hash_map>
//    #include <vector>
//
//    #include "base/basictypes.h"
//    #include "base/commandlineflags.h"
//    #include "foo/public/bar.h"
    public void testGoodOrders() {
        IASTTranslationUnit translationUnit = parseCPP(getCommentAbove());
        List<CheckResult> checkResults = checker.check(translationUnit);
        assertEquals(0, checkResults.size());
    }
}
