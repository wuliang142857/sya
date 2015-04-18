package com.github.magicsky.sya.examples.ibinding;

import com.github.magicsky.sya.ast.visitors.ASTNamesVisitor;
import com.github.magicsky.sya.checkers.BaseTest;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;
import org.eclipse.cdt.core.dom.ast.IParameter;

/**
 * @author 
 */
public class IParameterExample extends BaseTest {

    // void f(int a);
	// void f(int b){
	//    b;
	// }
    public void testExample() {
        IASTTranslationUnit translationUnit = parseCPP(getCommentAbove());
        ASTNamesVisitor namesVisitor = new ASTNamesVisitor();
        translationUnit.accept(namesVisitor);
        IParameter parameter = (IParameter) namesVisitor.getNames().get(1).resolveBinding();
        assertEquals("a", parameter.getName());
    }
}
