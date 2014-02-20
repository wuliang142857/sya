package com.github.magicsky.sya.examples.declspecifier;

import com.github.magicsky.sya.checkers.BaseTest;
import org.eclipse.cdt.core.dom.ast.IASTSimpleDeclaration;
import org.eclipse.cdt.core.dom.ast.IASTStandardFunctionDeclarator;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;
import org.eclipse.cdt.core.dom.ast.c.ICASTTypedefNameSpecifier;

/**
 * @author garcia.wul@alibaba-inc.com
 */
public class ICASTTypedefNameSpecifierExample extends BaseTest {

    // #ifdef __STDC__
    //  #define __P(x) x
    // #else
    //  define __P(x) ()
    // #endif
    // struct A_struct {
    //  int a;
    //  long *c;
    // };
    // typedef struct A_struct A;
    // static void f __P((A *));
    // static void f(x)
    //  A *x; {
    //  x->a = 0;
    // x->c[1]=x->c[2];
    // }
    public void testExample() {
        IASTTranslationUnit translationUnit = parseC(getCommentAbove());
        IASTSimpleDeclaration simpleDeclaration = (IASTSimpleDeclaration) translationUnit.getDeclarations()[2];
        IASTStandardFunctionDeclarator functionDeclarator = (IASTStandardFunctionDeclarator) simpleDeclaration.getDeclarators()[0];
        // __P((A *))
        assertTrue(functionDeclarator.getParameters()[0].getDeclSpecifier() instanceof ICASTTypedefNameSpecifier);
    }
}
