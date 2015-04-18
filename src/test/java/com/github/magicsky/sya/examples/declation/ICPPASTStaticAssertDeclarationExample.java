package com.github.magicsky.sya.examples.declation;

import com.github.magicsky.sya.checkers.BaseTest;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPASTStaticAssertDeclaration;

/**
 * @author 
 */
public class ICPPASTStaticAssertDeclarationExample extends BaseTest {

    // static_assert(sizeof(long) >= 8, "64-bit code generation required for this library.");
    public void test() {
        IASTTranslationUnit translationUnit = parseCPP(getCommentAbove());
        assertTrue(translationUnit.getDeclarations()[0] instanceof ICPPASTStaticAssertDeclaration);

    }
}
