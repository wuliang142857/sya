package com.github.magicsky.sya.examples.declation;

import com.github.magicsky.sya.checkers.BaseTest;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPASTUsingDeclaration;

/**
 * @author garcia.wul@alibaba-inc.com
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
        System.out.println(translationUnit.getDeclarations()[2].getRawSignature());
        assertTrue(translationUnit.getDeclarations()[2] instanceof ICPPASTUsingDeclaration);
    }
}
