package com.github.magicsky.sya.examples.declation;

import com.github.magicsky.sya.ast.visitors.ASTDeclarationsVisitor;
import com.github.magicsky.sya.checkers.BaseTest;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPASTFunctionDefinition;

/**
 * @author garcia.wul@alibaba-inc.com
 */
public class ICPPASTFunctionDefinitionExample extends BaseTest {

    // struct X {
    //  X();
    // };
    // X::X() = default;
    public void testExample() {
        IASTTranslationUnit translationUnit = parseCPP(getCommentAbove());
        ASTDeclarationsVisitor declarationsVisitor = new ASTDeclarationsVisitor();
        translationUnit.accept(declarationsVisitor);
        assertTrue(declarationsVisitor.getDeclarations().get(2) instanceof ICPPASTFunctionDefinition);
    }

    // struct X {
    //  X() {}
    // };
    public void testExample2() {
        IASTTranslationUnit translationUnit = parseCPP(getCommentAbove());
        ASTDeclarationsVisitor declarationsVisitor = new ASTDeclarationsVisitor();
        translationUnit.accept(declarationsVisitor);
        assertTrue(declarationsVisitor.getDeclarations().get(1) instanceof ICPPASTFunctionDefinition);
    }
}
