package com.github.magicsky.sya.examples.declation;

import com.github.magicsky.sya.ast.visitors.ASTDeclarationsVisitor;
import com.github.magicsky.sya.checkers.BaseTest;
import org.eclipse.cdt.core.dom.ast.IASTProblemDeclaration;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;

/**
 * @author 
 */
public class IASTProblemDeclarationExample extends BaseTest {

    // void test() {}
    // +
    public void testExample() {
        IASTTranslationUnit translationUnit = parseCPP(getCommentAbove());
        ASTDeclarationsVisitor declarationsVisitor = new ASTDeclarationsVisitor();
        translationUnit.accept(declarationsVisitor);
        assertTrue(declarationsVisitor.getDeclarations().get(1) instanceof IASTProblemDeclaration);
    }
}
