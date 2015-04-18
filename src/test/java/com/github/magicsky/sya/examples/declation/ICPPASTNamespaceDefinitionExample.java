package com.github.magicsky.sya.examples.declation;

import com.github.magicsky.sya.checkers.BaseTest;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPASTNamespaceDefinition;

/**
 * @author 
 */
public class ICPPASTNamespaceDefinitionExample extends BaseTest {

    //	namespace source {
	//		class cls {
	//		};
	//		void fs();
	//		void fs(int a);
	//
	//	}
    public void testExample() {
        IASTTranslationUnit translationUnit = parseCPP(getCommentAbove());
        assertTrue(translationUnit.getDeclarations()[0] instanceof ICPPASTNamespaceDefinition);
    }
}
