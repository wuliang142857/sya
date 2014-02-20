package com.github.magicsky.sya.examples.ibinding;

import com.github.magicsky.sya.checkers.BaseTest;
import org.eclipse.cdt.core.dom.ast.*;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPClassType;

/**
 * @author garcia.wul@alibaba-inc.com
 */
public class ICompositeTypeExample extends BaseTest {

    // class A { } a;
    public void testExample() {
        IASTTranslationUnit translationUnit = parseCPP(getCommentAbove());
        IASTSimpleDeclaration simpleDeclaration = (IASTSimpleDeclaration) translationUnit.getDeclarations()[0];
        IASTCompositeTypeSpecifier compositeTypeSpecifier = (IASTCompositeTypeSpecifier) simpleDeclaration.getDeclSpecifier();
        IASTName name = compositeTypeSpecifier.getName();
        ICompositeType compositeType = (ICompositeType) name.resolveBinding();
        assertTrue(compositeType.getKey() == ICPPClassType.k_class);
    }
}
