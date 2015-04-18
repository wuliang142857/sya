package com.github.magicsky.sya.examples.ibinding;

import com.github.magicsky.sya.ast.visitors.ASTNamesVisitor;
import com.github.magicsky.sya.checkers.BaseTest;
import org.eclipse.cdt.core.dom.ast.IASTName;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPFunctionTemplate;

/**
 * @author 
 */
public class ICPPFunctionTemplateExample extends BaseTest {

    // typedef int F(int);
	// template<typename T> F functionTemplate;
	// class C {
	//   F method;
	//   friend F friendFunction;
	//   template<typename T> F methodTemplate;
	// };
    public void testExample() {
        IASTTranslationUnit translationUnit = parseCPP(getCommentAbove());
        ASTNamesVisitor namesVisitor = new ASTNamesVisitor();
        translationUnit.accept(namesVisitor);
        for (IASTName name: namesVisitor.getNames()) {
            if (name.resolveBinding() instanceof ICPPFunctionTemplate) {
                ICPPFunctionTemplate functionTemplate = (ICPPFunctionTemplate) name.resolveBinding();
                assertEquals("functionTemplate", functionTemplate.getName());
                break;
            }
        }
    }
}
