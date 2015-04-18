package com.github.magicsky.sya.examples.name;

import com.github.magicsky.sya.ast.visitors.ASTNamesVisitor;
import com.github.magicsky.sya.checkers.BaseTest;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPASTConversionName;

/**
 * @author 
 */
public class ICPPASTConversionNameExample extends BaseTest {

    // class Foo {
	// public:
	// operator int();
	// char& operator[](unsigned int);
	// };
    public void testExample() {
        IASTTranslationUnit translationUnit = parseCPP(getCommentAbove());
        ASTNamesVisitor namesVisitor = new ASTNamesVisitor();
        translationUnit.accept(namesVisitor);
        // operator int
        assertTrue(namesVisitor.getNames().get(1) instanceof ICPPASTConversionName);
    }
}
