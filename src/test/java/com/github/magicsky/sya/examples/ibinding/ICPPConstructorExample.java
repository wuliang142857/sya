package com.github.magicsky.sya.examples.ibinding;

import com.github.magicsky.sya.ast.visitors.ASTNamesVisitor;
import com.github.magicsky.sya.checkers.BaseTest;
import org.eclipse.cdt.core.dom.ast.IASTName;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPClassType;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPConstructor;

/**
 * @author garcia.wul@alibaba-inc.com
 */
public class ICPPConstructorExample extends BaseTest {

    // class D { public: int x; };
	// class C : public virtual D {};
	// class B : public virtual D {};
	// class A : public B, public C {};
	// void main() {
	//    A * a = new A();
	//    a->x;
	// }
    public void testExample() {
        IASTTranslationUnit translationUnit = parseCPP(getCommentAbove());
        ASTNamesVisitor namesVisitor = new ASTNamesVisitor();
        translationUnit.accept(namesVisitor);
        // class A : public B, public C {};中的A
        IASTName name = namesVisitor.getNames().get(6);
        ICPPClassType classType = (ICPPClassType) name.resolveBinding();
        // A(void)
        ICPPConstructor constructor = classType.getConstructors()[0];
        assertEquals("A(void)", constructor.toString());
    }
}
