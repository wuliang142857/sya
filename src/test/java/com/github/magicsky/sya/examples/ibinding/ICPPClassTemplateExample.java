package com.github.magicsky.sya.examples.ibinding;

import com.github.magicsky.sya.ast.visitors.ASTNamesVisitor;
import com.github.magicsky.sya.checkers.BaseTest;
import org.eclipse.cdt.core.dom.ast.IASTName;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPClassTemplate;

/**
 * @author 
 */
public class ICPPClassTemplateExample extends BaseTest {

    // template <class T> class A{ T t; };
    public void testExample() {
        IASTTranslationUnit translationUnit = parseCPP(getCommentAbove());
        ASTNamesVisitor namesVisitor = new ASTNamesVisitor();
        translationUnit.accept(namesVisitor);
        IASTName name = namesVisitor.getNames().get(1);
        // A
        assertTrue(name.resolveBinding() instanceof ICPPClassTemplate);
    }
}
