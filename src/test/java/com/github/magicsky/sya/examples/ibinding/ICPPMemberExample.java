package com.github.magicsky.sya.examples.ibinding;

import com.github.magicsky.sya.ast.visitors.ASTNamesVisitor;
import com.github.magicsky.sya.checkers.BaseTest;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPMember;

/**
 * @author garcia.wul@alibaba-inc.com
 */
public class ICPPMemberExample extends BaseTest {

    // class X { int a; };
    public void testExample() {
        IASTTranslationUnit translationUnit = parseCPP(getCommentAbove());
        ASTNamesVisitor namesVisitor = new ASTNamesVisitor();
        translationUnit.accept(namesVisitor);
        ICPPMember field = (ICPPMember) namesVisitor.getNames().get(1).resolveBinding();
        assertEquals("a", field.getName());
        assertEquals(ICPPMember.v_private, field.getVisibility());
    }
}
