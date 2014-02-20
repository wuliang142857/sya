package com.github.magicsky.sya.examples.name;

import com.github.magicsky.sya.checkers.BaseTest;
import org.eclipse.cdt.core.dom.ast.IASTDeclarator;
import org.eclipse.cdt.core.dom.ast.IASTName;
import org.eclipse.cdt.core.dom.ast.IASTSimpleDeclaration;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;

/**
 * @author garcia.wul@alibaba-inc.com
 */
public class IASTNameExample extends BaseTest {

    // int x;
	// void f(int y) {
	//    int z = x + y;
	// }
    public void testExample() {
        IASTTranslationUnit translationUnit = parseCPP(getCommentAbove());
        IASTSimpleDeclaration simpleDeclaration = (IASTSimpleDeclaration) translationUnit.getDeclarations()[0];
        IASTDeclarator declarator = simpleDeclaration.getDeclarators()[0];
        IASTName name = declarator.getName();
        assertEquals("x", name.toString());
    }
}

