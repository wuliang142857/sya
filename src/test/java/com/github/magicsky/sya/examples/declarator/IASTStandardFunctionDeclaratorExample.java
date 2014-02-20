package com.github.magicsky.sya.examples.declarator;

import com.github.magicsky.sya.checkers.BaseTest;
import org.eclipse.cdt.core.dom.ast.IASTSimpleDeclaration;
import org.eclipse.cdt.core.dom.ast.IASTStandardFunctionDeclarator;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;

/**
 * @author garcia.wul@alibaba-inc.com
 */
public class IASTStandardFunctionDeclaratorExample extends BaseTest {

    // int (*pfi)();
    public void testExample() {
        IASTTranslationUnit translationUnit = parseCPP(getCommentAbove());
        IASTSimpleDeclaration simpleDeclaration = (IASTSimpleDeclaration) translationUnit.getDeclarations()[0];
        // (*pfi)()
        assertTrue(simpleDeclaration.getDeclarators()[0] instanceof IASTStandardFunctionDeclarator);
    }
}
