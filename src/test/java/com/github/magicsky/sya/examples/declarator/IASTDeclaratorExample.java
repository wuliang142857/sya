package com.github.magicsky.sya.examples.declarator;

import com.github.magicsky.sya.ast.visitors.ASTDeclarationsVisitor;
import com.github.magicsky.sya.checkers.BaseTest;
import org.eclipse.cdt.core.dom.ast.IASTDeclarator;
import org.eclipse.cdt.core.dom.ast.IASTSimpleDeclaration;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;

/**
 * @author garcia.wul@alibaba-inc.com
 */
public class IASTDeclaratorExample extends BaseTest {

    // int x;
    public void testExample() {
        IASTTranslationUnit translationUnit = parseCPP(getCommentAbove());
        ASTDeclarationsVisitor declarationsVisitor = new ASTDeclarationsVisitor();
        translationUnit.accept(declarationsVisitor);
        IASTSimpleDeclaration simpleDeclaration = (IASTSimpleDeclaration) declarationsVisitor.getDeclarations().get(0);
        assertTrue(simpleDeclaration.getDeclarators()[0] instanceof IASTDeclarator);
        assertEquals("x", simpleDeclaration.getDeclarators()[0].getName().toString());
    }
}
