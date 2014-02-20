package com.github.magicsky.sya.examples.declspecifier;

import com.github.magicsky.sya.checkers.BaseTest;
import org.eclipse.cdt.core.dom.ast.IASTEnumerationSpecifier;
import org.eclipse.cdt.core.dom.ast.IASTSimpleDeclaration;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;

/**
 * @author garcia.wul@alibaba-inc.com
 */
public class IASTEnumerationSpecifierExample extends BaseTest {

    //enum
	//{
	//    _ISalnum = 11 < 8 ? 1 : 2,
	//    _ISalnum2 = 11 > 8 ? 1 : 2
	//};
	//
    public void testExample() {
        IASTTranslationUnit translationUnit = parseCPP(getCommentAbove());
        IASTSimpleDeclaration simpleDeclaration = (IASTSimpleDeclaration) translationUnit.getDeclarations()[0];
        assertTrue(simpleDeclaration.getDeclSpecifier() instanceof IASTEnumerationSpecifier);
    }
}
