package com.github.magicsky.sya.examples.ibinding;

import com.github.magicsky.sya.ast.visitors.ASTNamesVisitor;
import com.github.magicsky.sya.checkers.BaseTest;
import org.eclipse.cdt.core.dom.ast.IASTName;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPField;

/**
 * @author garcia.wul@alibaba-inc.com
 */
public class ICPPFieldExample extends BaseTest {

    // typedef struct {
	//     int x;
	// } S;
	// void f() {
	//     S myS;
	//     myS.x = 5;
	// }
    public void testExample() {
        IASTTranslationUnit translationUnit = parseCPP(getCommentAbove());
        ASTNamesVisitor namesVisitor = new ASTNamesVisitor();
        translationUnit.accept(namesVisitor);
        IASTName name = namesVisitor.getNames().get(1);
        ICPPField field = (ICPPField) name.resolveBinding();
        assertEquals("x", field.getName());
    }
}
