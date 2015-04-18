package com.github.magicsky.sya.examples.declspecifier;

import com.github.magicsky.sya.checkers.BaseTest;
import org.eclipse.cdt.core.dom.ast.IASTSimpleDeclaration;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPASTNamedTypeSpecifier;

/**
 * @author 
 */
public class ICPPASTNamedTypeSpecifierExample extends BaseTest {

    // typedef int INT;
    // typedef INT (FOO) (INT);
    public void testExample() {
        IASTTranslationUnit translationUnit = parseCPP(getCommentAbove());
        IASTSimpleDeclaration simpleDeclaration = (IASTSimpleDeclaration) translationUnit.getDeclarations()[1];
        // typedef INT
        assertTrue(simpleDeclaration.getDeclSpecifier() instanceof ICPPASTNamedTypeSpecifier);
    }
}
