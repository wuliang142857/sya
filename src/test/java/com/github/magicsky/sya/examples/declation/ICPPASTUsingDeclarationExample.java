package com.github.magicsky.sya.examples.declation;

import com.github.magicsky.sya.checkers.BaseTest;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPASTUsingDeclaration;

/**
 * @author 
 */
public class ICPPASTUsingDeclarationExample extends BaseTest {

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
        assertTrue(translationUnit.getDeclarations()[2] instanceof ICPPASTUsingDeclaration);
    }
}
