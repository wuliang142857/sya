package com.github.magicsky.sya.examples.declation;

import com.github.magicsky.sya.ast.visitors.ASTDeclarationsVisitor;
import com.github.magicsky.sya.checkers.BaseTest;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPASTFunctionWithTryBlock;

/**
 * @author garcia.wul@alibaba-inc.com
 */
public class ICPPASTFunctionWithTryBlockExample extends BaseTest {

    // int f(int);
    // class C {
    //  int i;
    //  double d;
    // public:
    //  C(int, double);
    // };
    // C::C(int ii, double id)
    // try
    // : i(f(ii)), d(id)
    // {}
    // catch(...) {}
    public void testExample() {
        IASTTranslationUnit translationUnit = parseCPP(getCommentAbove());
        ASTDeclarationsVisitor declarationsVisitor = new ASTDeclarationsVisitor();
        translationUnit.accept(declarationsVisitor);
        assertTrue(declarationsVisitor.getDeclarations().get(declarationsVisitor.getDeclarations().size() - 1) instanceof ICPPASTFunctionWithTryBlock);
    }
}
