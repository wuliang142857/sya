package com.github.magicsky.sya.examples.declation;

import com.github.magicsky.sya.ast.visitors.ASTDeclarationsVisitor;
import com.github.magicsky.sya.checkers.BaseTest;
import org.eclipse.cdt.core.dom.ast.IASTASMDeclaration;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;

/**
 * @author 
 */
public class IASTASMDeclarationExample extends BaseTest {

    // __asm__("CODE");
    public void testExample() {
        IASTTranslationUnit translationUnit = parseCPP(getCommentAbove());
        ASTDeclarationsVisitor declarationsVisitor = new ASTDeclarationsVisitor();
        translationUnit.accept(declarationsVisitor);
        assertTrue(declarationsVisitor.getDeclarations().get(0) instanceof IASTASMDeclaration);
    }
}
