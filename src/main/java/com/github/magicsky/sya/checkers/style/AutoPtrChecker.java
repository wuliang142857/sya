package com.github.magicsky.sya.checkers.style;

import com.github.magicsky.sya.checkers.IChecker;
import org.apache.log4j.Logger;

/**
 * @author garcia.wul@alibaba-inc.com
 */
public class AutoPtrChecker implements IChecker {

    private Logger logger = Logger.getLogger(AutoPtrChecker.class);

//    private Mustache message =

    @Override
    public int check(Object obj) {
//        IASTTranslationUnit translationUnit = (IASTTranslationUnit) obj;
//
//        ASTStatementsVisitor statementsVisitor = new ASTStatementsVisitor();
//        translationUnit.accept(statementsVisitor);
//
//        for (IASTStatement statement: statementsVisitor.getStatements()) {
//            if (!(statement instanceof IASTDeclarationStatement))
//                continue;
//
//            IASTDeclarationStatement declarationStatement = (IASTDeclarationStatement) statement;
//            if (declarationStatement.getDeclaration() == null || !(declarationStatement.getDeclaration() instanceof IASTSimpleDeclaration))
//                continue;
//
//            IASTSimpleDeclaration declaration = (IASTSimpleDeclaration) declarationStatement.getDeclaration();
//            // 2014-02-16 garcia.wul 如果用户自己定义了auto_ptr函数，则目前无法识别
//            if (declaration.getDeclSpecifier().toString().contains("auto_ptr")) {
//            }
//        }
        return 0;
    }
}
