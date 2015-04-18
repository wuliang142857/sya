package com.github.magicsky.sya.examples.declspecifier;

import com.github.magicsky.sya.checkers.BaseTest;
import org.eclipse.cdt.core.dom.ast.IASTSimpleDeclaration;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;
import org.eclipse.cdt.core.dom.ast.c.ICASTSimpleDeclSpecifier;

/**
 * @author 
 */
public class ICASTSimpleDeclSpecifierExample extends BaseTest {

    // float _Complex x;
    public void testExample() {
        IASTTranslationUnit translationUnit = parseC(getCommentAbove());
        IASTSimpleDeclaration simpleDeclaration = (IASTSimpleDeclaration) translationUnit.getDeclarations()[0];
        assertTrue(simpleDeclaration.getDeclSpecifier() instanceof ICASTSimpleDeclSpecifier);
    }
}
