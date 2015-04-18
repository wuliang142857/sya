package com.github.magicsky.sya.examples.ibinding;

import com.github.magicsky.sya.ast.visitors.ASTNamesVisitor;
import com.github.magicsky.sya.checkers.BaseTest;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPVariable;

/**
 * @author 
 */
public class ICPPVariableExample extends BaseTest {

    // namespace B { int b; }
	// namespace A { using namespace B;  int a;  }
	// namespace B { using namespace A; }
	// void f() { B::a++;  }
    public void testExample() {
        IASTTranslationUnit translationUnit = parseCPP(getCommentAbove());
        ASTNamesVisitor namesVisitor = new ASTNamesVisitor();
        translationUnit.accept(namesVisitor);
        ICPPVariable aVariable = (ICPPVariable) namesVisitor.getNames().get(4).resolveBinding();
        assertEquals("a", aVariable.getName());
    }
}
