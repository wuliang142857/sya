package com.github.magicsky.sya.examples.declspecifier;

import com.github.magicsky.sya.ast.visitors.ASTDeclarationsVisitor;
import com.github.magicsky.sya.checkers.BaseTest;
import org.eclipse.cdt.core.dom.ast.IASTCompositeTypeSpecifier;
import org.eclipse.cdt.core.dom.ast.IASTSimpleDeclaration;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;

/**
 * @author garcia.wul@alibaba-inc.com
 */
public class IASTCompositeTypeSpecifierExample extends BaseTest {

    // struct X {
    // int test;
    // };
    public void testExample() {
        IASTTranslationUnit translationUnit = parseCPP(getCommentAbove());
        ASTDeclarationsVisitor declarationsVisitor = new ASTDeclarationsVisitor();
        translationUnit.accept(declarationsVisitor);
        IASTSimpleDeclaration simpleDeclaration = (IASTSimpleDeclaration) declarationsVisitor.getDeclarations().get(0);
        assertTrue(simpleDeclaration.getDeclSpecifier() instanceof IASTCompositeTypeSpecifier);
    }
}
