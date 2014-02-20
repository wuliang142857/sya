package com.github.magicsky.sya.examples.declarator;

import com.github.magicsky.sya.checkers.BaseTest;
import org.eclipse.cdt.core.dom.ast.IASTSimpleDeclaration;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPASTFunctionDeclarator;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPASTNamespaceDefinition;

/**
 * @author garcia.wul@alibaba-inc.com
 */
public class ICPPASTFunctionDeclaratorExample extends BaseTest {

    //	namespace source {
	//		class cls {
	//		};
	//		void fs();
	//		void fs(int a);
	//
	//	}
	//  void test1() {
	//		source::fs();
	//		source::fs(1);
	//		source::cls c2;
	//  }
	//
	//	using source::cls;
	//	using source::fs;
	//
	//	void test() {
	//		cls c2;
	//		fs();
	//		fs(1);
	//	}
    public void testExample() {
        IASTTranslationUnit translationUnit = parseCPP(getCommentAbove());
        ICPPASTNamespaceDefinition namespaceDefinition = (ICPPASTNamespaceDefinition) translationUnit.getDeclarations()[0];
        IASTSimpleDeclaration simpleDeclaration = (IASTSimpleDeclaration) namespaceDefinition.getDeclarations()[1];
        // fs()
        assertTrue(simpleDeclaration.getDeclarators()[0] instanceof ICPPASTFunctionDeclarator);
    }
}
