package com.github.magicsky.sya.examples.declarator;

import com.github.magicsky.sya.checkers.BaseTest;
import org.eclipse.cdt.core.dom.ast.IASTFunctionDeclarator;
import org.eclipse.cdt.core.dom.ast.IASTFunctionDefinition;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;

/**
 * @author 
 */
public class IASTFunctionDeclaratorExample extends BaseTest {

    // int x;
	// void f(int y) {
	//    int z = x + y;
	// }
    public void testExample() {
        IASTTranslationUnit translationUnit = parseCPP(getCommentAbove());
        IASTFunctionDefinition functionDefinition = (IASTFunctionDefinition) translationUnit.getDeclarations()[1];
        // f(int y)
        assertTrue(functionDefinition.getDeclarator() instanceof IASTFunctionDeclarator);
    }
}
