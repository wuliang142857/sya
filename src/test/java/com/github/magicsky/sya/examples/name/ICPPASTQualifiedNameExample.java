package com.github.magicsky.sya.examples.name;

import com.github.magicsky.sya.checkers.BaseTest;
import org.eclipse.cdt.core.dom.ast.IASTFunctionDeclarator;
import org.eclipse.cdt.core.dom.ast.IASTFunctionDefinition;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPASTQualifiedName;

/**
 * @author 
 */
public class ICPPASTQualifiedNameExample extends BaseTest {

    //  class A { void f();  };
	//  void A::f() { }
    public void testExample() {
        IASTTranslationUnit translationUnit = parseCPP(getCommentAbove());
        IASTFunctionDefinition functionDefinition = (IASTFunctionDefinition) translationUnit.getDeclarations()[1];
        IASTFunctionDeclarator functionDeclarator = functionDefinition.getDeclarator();
        // A::f()
        assertTrue(functionDeclarator.getName() instanceof ICPPASTQualifiedName);
    }
}
