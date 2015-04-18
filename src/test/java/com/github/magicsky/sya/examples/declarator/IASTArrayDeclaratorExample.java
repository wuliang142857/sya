package com.github.magicsky.sya.examples.declarator;

import com.github.magicsky.sya.checkers.BaseTest;
import org.eclipse.cdt.core.dom.ast.IASTArrayDeclarator;
import org.eclipse.cdt.core.dom.ast.IASTSimpleDeclaration;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;

/**
 * @author 
 */
public class IASTArrayDeclaratorExample extends BaseTest {

    // const int x = 10;
	// int y [ const static x ];
    public void testExample() {
        IASTTranslationUnit translationUnit = parseC(getCommentAbove());
        IASTSimpleDeclaration simpleDeclaration = (IASTSimpleDeclaration) translationUnit.getDeclarations()[1];
        // y [ const static x ]
        assertTrue(simpleDeclaration.getDeclarators()[0] instanceof IASTArrayDeclarator);
    }
}
