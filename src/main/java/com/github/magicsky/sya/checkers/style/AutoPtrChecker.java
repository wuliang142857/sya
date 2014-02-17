package com.github.magicsky.sya.checkers.style;

import com.github.magicsky.sya.ast.visitors.ASTStatementsVisitor;
import com.github.magicsky.sya.checkers.BaseChecker;
import com.github.magicsky.sya.enumerators.ErrorItem;
import com.github.magicsky.sya.enumerators.ErrorType;
import com.github.magicsky.sya.model.CheckResult;
import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import com.google.common.collect.Lists;
import org.apache.log4j.Logger;
import org.eclipse.cdt.core.dom.ast.IASTDeclarationStatement;
import org.eclipse.cdt.core.dom.ast.IASTSimpleDeclaration;
import org.eclipse.cdt.core.dom.ast.IASTStatement;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;

import java.io.StringReader;
import java.util.List;

/**
 * @author garcia.wul@alibaba-inc.com
 */
public class AutoPtrChecker extends BaseChecker {

    MustacheFactory mustacheFactory = new DefaultMustacheFactory();
    private Mustache errorMessage = mustacheFactory.compile(
        new StringReader(
        "{{{checkResult.errorItem.desc}}} in {{{checkResult.fileName}}}, line: {{{checkResult.startingLineNumber}}}"
        ), "AutoPtr"
    );


    @Override
    public List<CheckResult> check(Object obj) {
        List<CheckResult> checkResults = Lists.newArrayList();

        IASTTranslationUnit translationUnit = (IASTTranslationUnit) obj;

        ASTStatementsVisitor statementsVisitor = new ASTStatementsVisitor();
        translationUnit.accept(statementsVisitor);

        for (IASTStatement statement: statementsVisitor.getStatements()) {
            if (!(statement instanceof IASTDeclarationStatement))
                continue;

            IASTDeclarationStatement declarationStatement = (IASTDeclarationStatement) statement;
            if (declarationStatement.getDeclaration() == null || !(declarationStatement.getDeclaration() instanceof IASTSimpleDeclaration))
                continue;

            IASTSimpleDeclaration declaration = (IASTSimpleDeclaration) declarationStatement.getDeclaration();
            // 2014-02-16 garcia.wul 如果用户自己定义了auto_ptr函数，则目前无法识别
            if (declaration.getDeclSpecifier().toString().contains("auto_ptr") ||
                declaration.getDeclSpecifier().toString().contains("std::auto_ptr")) {
                CheckResult checkResult = new CheckResult(
                    ErrorItem.AUTO_PTR,
                    ErrorType.STYLE,
                    translationUnit.getFilePath(),
                    declaration.getFileLocation().getStartingLineNumber(),
                    declaration.getFileLocation().getEndingLineNumber()
                );
                checkResults.add(checkResult);
                logger.error(compileErrorMessage(errorMessage, checkResult));
            }
        }
        return checkResults;
    }
}
