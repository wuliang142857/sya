package com.github.magicsky.sya.examples.declspecifier;

import com.github.magicsky.sya.checkers.BaseTest;
import org.eclipse.cdt.core.dom.ast.IASTSimpleDeclaration;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;
import org.eclipse.cdt.core.dom.ast.c.ICASTCompositeTypeSpecifier;

/**
 * @author garcia.wul@alibaba-inc.com
 */
public class ICASTCompositeTypeSpecifierExample extends BaseTest {
    // struct A { static int i; };
    public void testExample() {
        IASTTranslationUnit translationUnit = parseC(getCommentAbove());
        IASTSimpleDeclaration simpleDeclaration = (IASTSimpleDeclaration) translationUnit.getDeclarations()[0];
        ICASTCompositeTypeSpecifier typeSpecifier = (ICASTCompositeTypeSpecifier) simpleDeclaration.getDeclSpecifier();
        assertTrue(simpleDeclaration.getDeclSpecifier() instanceof ICASTCompositeTypeSpecifier);
    }
}
