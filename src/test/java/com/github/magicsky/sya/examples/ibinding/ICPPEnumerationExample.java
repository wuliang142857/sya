package com.github.magicsky.sya.examples.ibinding;

import com.github.magicsky.sya.ast.visitors.ASTNamesVisitor;
import com.github.magicsky.sya.checkers.BaseTest;
import org.eclipse.cdt.core.dom.ast.IASTName;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPEnumeration;

/**
 * @author 
 */
public class ICPPEnumerationExample extends BaseTest {

    // enum class EScoped1 {a1};
	// enum class EScoped2 : short {a2};
	// enum class EScoped3;
	// enum EUnscoped1 {b1};
	// enum EUnscoped2 : long {b2};
	// enum EUnscoped3 : int;
    public void testExample() {
        IASTTranslationUnit translationUnit = parseCPP(getCommentAbove());
        ASTNamesVisitor namesVisitor = new ASTNamesVisitor();
        translationUnit.accept(namesVisitor);
        IASTName name = namesVisitor.getNames().get(0);
        // EScoped1
        assertTrue(name.resolveBinding() instanceof ICPPEnumeration);
    }
}
