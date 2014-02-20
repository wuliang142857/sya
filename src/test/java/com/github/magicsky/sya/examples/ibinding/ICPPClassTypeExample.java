package com.github.magicsky.sya.examples.ibinding;

import com.github.magicsky.sya.ast.visitors.ASTNamesVisitor;
import com.github.magicsky.sya.checkers.BaseTest;
import org.eclipse.cdt.core.dom.ast.IASTName;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPClassType;

/**
 * @author garcia.wul@alibaba-inc.com
 */
public class ICPPClassTypeExample extends BaseTest {

    // class A {  int f; };
    public void testExample() {
        IASTTranslationUnit translationUnit = parseCPP(getCommentAbove());
        ASTNamesVisitor namesVisitor = new ASTNamesVisitor();
        translationUnit.accept(namesVisitor);
        IASTName name = namesVisitor.getNames().get(0);
        // A
        assertTrue(name.resolveBinding() instanceof ICPPClassType);
    }
}
