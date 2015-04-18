package com.github.magicsky.sya.examples.ibinding;

import com.github.magicsky.sya.ast.visitors.ASTNamesVisitor;
import com.github.magicsky.sya.checkers.BaseTest;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPNamespace;

/**
 * @author 
 */
public class ICPPNamespaceExample extends BaseTest {

    // namespace A{
	//    int a;
	// }
	// namespace B{
	//    using namespace A;
	// }
	// namespace C{
	//    using namespace A;
	// }
	//
	// namespace BC{
	//    using namespace B;
	//    using namespace C;
	// }
	//
	// void f(){
	//    BC::a++; //ok
	// }
    public void testExample() {
        IASTTranslationUnit translationUnit = parseCPP(getCommentAbove());
        ASTNamesVisitor namesVisitor = new ASTNamesVisitor();
        translationUnit.accept(namesVisitor);
        ICPPNamespace namespace = (ICPPNamespace) namesVisitor.getNames().get(0).resolveBinding();
        assertEquals("A", namespace.getName());
    }
}
