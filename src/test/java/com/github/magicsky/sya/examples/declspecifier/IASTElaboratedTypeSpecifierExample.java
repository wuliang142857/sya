package com.github.magicsky.sya.examples.declspecifier;

import com.github.magicsky.sya.checkers.BaseTest;
import org.eclipse.cdt.core.dom.ast.IASTElaboratedTypeSpecifier;
import org.eclipse.cdt.core.dom.ast.IASTSimpleDeclaration;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;

/**
 * @author garcia.wul@alibaba-inc.com
 */
public class IASTElaboratedTypeSpecifierExample extends BaseTest {

    // struct A;
	// int * f(int i, char c);
	// void (*g) (struct A *);
	// void (* (*h)(struct A**)) (int d);
    public void testExample() {
        IASTTranslationUnit translationUnit = parseCPP(getCommentAbove());
        IASTSimpleDeclaration simpleDeclaration = (IASTSimpleDeclaration) translationUnit.getDeclarations()[0];
        // struct A
        assertTrue(simpleDeclaration.getDeclSpecifier() instanceof IASTElaboratedTypeSpecifier);
    }
}
