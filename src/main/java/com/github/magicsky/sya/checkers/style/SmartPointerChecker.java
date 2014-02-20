package com.github.magicsky.sya.checkers.style;

import com.github.magicsky.sya.ast.visitors.ASTStatementsVisitor;
import com.github.magicsky.sya.checkers.BaseChecker;
import com.github.magicsky.sya.enumerators.ErrorItem;
import com.github.magicsky.sya.enumerators.ErrorType;
import com.github.magicsky.sya.model.CheckResult;
import com.github.magicsky.sya.model.ConfigProperty;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.eclipse.cdt.core.dom.ast.*;

import java.util.List;
import java.util.Map;

/**
 * @author garcia.wul@alibaba-inc.com
 */
public class SmartPointerChecker extends BaseChecker {

    private String errorMessage =
        "{{{checkResult.errorItem.desc}}} in {{{checkResult.fileName}}}, line: {{{checkResult.startingLineNumber}}}";

    public SmartPointerChecker(ConfigProperty configProperty) {
        super(configProperty);
    }

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
            final IASTDeclSpecifier declSpeciafier = declaration.getDeclSpecifier();
            boolean hasRiskSmartPointer = Collections2.filter(
                configProperty.getRiskSmartPointers(), new Predicate<String>() {
                @Override
                    public boolean apply(String s) {
                        return declSpeciafier.toString().contains(s);
                    }
                }
            ).size() > 0;

            if (hasRiskSmartPointer) {
                CheckResult checkResult = new CheckResult(
                    ErrorItem.SMART_POINTER,
                    ErrorType.STYLE,
                    translationUnit.getFilePath(),
                    declaration.getFileLocation().getStartingLineNumber(),
                    declaration.getFileLocation().getEndingLineNumber()
                );
                checkResults.add(checkResult);

                // log结果
                Map<String, Object> scopes = Maps.newHashMap();
                scopes.put("checkResult", checkResult);
                String comments = compileErrorMessage(errorMessage, scopes);
                logger.error(comments);

                checkResult.setComments(comments);
            }
        }
        return checkResults;
    }
}
