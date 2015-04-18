package com.github.magicsky.sya.cmd;

import com.github.magicsky.sya.ast.ASTTranslationUnitCore;
import com.github.magicsky.sya.ast.IASTTranslationUnitCore;
import com.github.magicsky.sya.ast.visitors.ASTDeclarationsVisitor;
import org.eclipse.cdt.core.dom.ast.IASTDeclaration;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;
import org.eclipse.cdt.core.parser.ParserLanguage;

import java.io.IOException;

/**
 * @author 
 */
public class DoCheck {

    public static void main(String[] args) throws IOException {

        String sourceFile = "/Users/wul/Downloads/cppcheck-1.63/cli/main.cpp";

        IASTTranslationUnitCore astTranslationUnitCore = new ASTTranslationUnitCore();
        IASTTranslationUnit astTranslationUnit = astTranslationUnitCore.parseFile(
            sourceFile, ParserLanguage.CPP, false, false
        );
        System.out.println(astTranslationUnit.getFilePath());
        ASTDeclarationsVisitor astDeclarationsVisitor = new ASTDeclarationsVisitor();
        astTranslationUnit.accept(astDeclarationsVisitor);
        for (IASTDeclaration declaration: astDeclarationsVisitor.getDeclarations()) {
            System.out.println(declaration.getRawSignature());
        }
    }
}
