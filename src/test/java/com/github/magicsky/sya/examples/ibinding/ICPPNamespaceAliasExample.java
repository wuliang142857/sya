package com.github.magicsky.sya.examples.ibinding;

import com.github.magicsky.sya.ast.visitors.ASTNamesVisitor;
import com.github.magicsky.sya.checkers.BaseTest;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPNamespace;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPNamespaceAlias;

/**
 * @author 
 */
public class ICPPNamespaceAliasExample extends BaseTest {

    // namespace A { int x; }
	// namespace B = A;
	// int f(){ B::x;  }
    public void testExample() {
        IASTTranslationUnit translationUnit = parseCPP(getCommentAbove());
        ASTNamesVisitor namesVisitor = new ASTNamesVisitor();
        translationUnit.accept(namesVisitor);

        ICPPNamespace A = (ICPPNamespace) namesVisitor.getNames().get(0).resolveBinding();
        ICPPNamespace B = (ICPPNamespace) namesVisitor.getNames().get(2).resolveBinding();
        assertSame(((ICPPNamespaceAlias) B).getBinding(), A);
    }
}
