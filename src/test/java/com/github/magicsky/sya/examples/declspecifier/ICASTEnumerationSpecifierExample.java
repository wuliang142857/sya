package com.github.magicsky.sya.examples.declspecifier;

import com.github.magicsky.sya.checkers.BaseTest;
import org.eclipse.cdt.core.dom.ast.IASTSimpleDeclaration;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;
import org.eclipse.cdt.core.dom.ast.c.ICASTEnumerationSpecifier;

/**
 * @author garcia.wul@alibaba-inc.com
 */
public class ICASTEnumerationSpecifierExample extends BaseTest {

    // enum hue { red, blue, green };
	// enum hue col, *cp;
	// void f() {
	//    col = blue;
	//    cp = &col;
	//    if (*cp != red)
	//       return;
	// }
    public void testExample() {
        IASTTranslationUnit translationUnit = parseC(getCommentAbove());
        IASTSimpleDeclaration simpleDeclaration = (IASTSimpleDeclaration) translationUnit.getDeclarations()[0];
        assertTrue(simpleDeclaration.getDeclSpecifier() instanceof ICASTEnumerationSpecifier);
    }
}
