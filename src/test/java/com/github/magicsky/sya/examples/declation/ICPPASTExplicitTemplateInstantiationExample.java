package com.github.magicsky.sya.examples.declation;

import com.github.magicsky.sya.checkers.BaseTest;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPASTExplicitTemplateInstantiation;

/**
 * @author garcia.wul@alibaba-inc.com
 */
public class ICPPASTExplicitTemplateInstantiationExample extends BaseTest {

    //	template<typename T> class CT {};
	//	extern template class CT<int>;
    public void testExample() {
        IASTTranslationUnit translationUnit = parseCPP(getCommentAbove());
        assertTrue(translationUnit.getDeclarations()[1] instanceof ICPPASTExplicitTemplateInstantiation);
    }
}
