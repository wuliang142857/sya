package com.github.magicsky.sya.cmd;

import com.github.magicsky.sya.ast.ASTDeclarationsVisitor;
import com.github.magicsky.sya.ast.ASTTranslationUnitCore;
import org.apache.commons.io.FileUtils;
import org.eclipse.cdt.core.dom.ast.IASTDeclaration;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;
import org.eclipse.cdt.core.parser.ParserLanguage;

import java.io.File;
import java.io.IOException;

/**
 * @author garcia.wul@alibaba-inc.com
 */
public class DoCheck {

    public static void main(String[] args) throws IOException {
        String sourceFile = "/Users/wul/Downloads/cppcheck-1.63/cli/main.cpp";
        String code = FileUtils.readFileToString(new File(sourceFile));

        ASTTranslationUnitCore astTranslationUnitCore = new ASTTranslationUnitCore();
        IASTTranslationUnit astTranslationUnit = astTranslationUnitCore.parse(
            code.toCharArray(), ParserLanguage.CPP, true,  true, false
        );
        ASTDeclarationsVisitor astDeclarationsVisitor = new ASTDeclarationsVisitor();
        astTranslationUnit.accept(astDeclarationsVisitor);
        for (IASTDeclaration declaration: astDeclarationsVisitor.getDeclarations()) {
            System.out.println(declaration.getRawSignature());
        }
    }
}
