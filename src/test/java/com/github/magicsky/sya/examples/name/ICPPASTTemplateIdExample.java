package com.github.magicsky.sya.examples.name;

import com.github.magicsky.sya.ast.visitors.ASTNamesVisitor;
import com.github.magicsky.sya.checkers.BaseTest;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPASTTemplateId;

/**
 * @author garcia.wul@alibaba-inc.com
 */
public class ICPPASTTemplateIdExample extends BaseTest {

    // template <class T>
	// struct S {
	// T *p;
	// };
	// S<int()> x; // typeid
	// S<int(1)> y; // expression (illformed)
    public void testExample() {
        IASTTranslationUnit translationUnit = parseCPP(getCommentAbove());
        ASTNamesVisitor namesVisitor = new ASTNamesVisitor();
        translationUnit.accept(namesVisitor);
        // S<int()>
        assertTrue(namesVisitor.getNames().get(4) instanceof ICPPASTTemplateId);
    }
}
