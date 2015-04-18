package com.github.magicsky.sya.examples.name;

import com.github.magicsky.sya.ast.visitors.ASTNamesVisitor;
import com.github.magicsky.sya.checkers.BaseTest;
import org.eclipse.cdt.core.dom.ast.IASTImplicitName;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;

/**
 * @author 
 */
public class IASTImplicitNameExample extends BaseTest {

    //	struct X {};
	//	struct Y {
	//	  X x;
	//	};
	//
	//	X* operator&(X);
	//	X* operator&(Y);
	//
	//	void test(X x, Y y) {
	//	  X (Y::*px1) = &Y::x;  // not the overloaded operator
	//	  X* px2 = &y; // overloaded
	//	}
    public void testExample() {
        IASTTranslationUnit translationUnit = parseCPP(getCommentAbove());
        ASTNamesVisitor namesVisitor = new ASTNamesVisitor();
        translationUnit.accept(namesVisitor);
        // &y中的&，因为它被重载了
        assertTrue(namesVisitor.getNames().get(namesVisitor.getNames().size() - 2) instanceof IASTImplicitName);
    }
}
