package com.github.magicsky.sya.examples.declarator;

import com.github.magicsky.sya.checkers.BaseTest;
import org.eclipse.cdt.core.dom.ast.IASTFunctionDefinition;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;
import org.eclipse.cdt.core.dom.ast.gnu.c.ICASTKnRFunctionDeclarator;

/**
 * @author 
 */
public class ICASTKnRFunctionDeclaratorExample extends BaseTest {

    // int isroot (x, y)
    // int x;
    // int y;
    // { return x == 0; }
    public void testExample() {
        IASTTranslationUnit translationUnit = parseC(getCommentAbove());
        IASTFunctionDefinition functionDefinition = (IASTFunctionDefinition) translationUnit.getDeclarations()[0];
        assertTrue(functionDefinition.getDeclarator() instanceof ICASTKnRFunctionDeclarator);
    }
}
