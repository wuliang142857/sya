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
import org.eclipse.cdt.core.dom.ast.IASTPreprocessorIfndefStatement;
import org.eclipse.cdt.core.dom.ast.IASTPreprocessorStatement;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;

import java.util.List;
import java.util.Map;

/**
 * @author 
 */
public class DefineGuardChecker extends BaseChecker {

    private String errorMessage =
        "{{{checkResult.errorItem.desc}}} in {{{checkResult.fileName}}}";

    public DefineGuardChecker(ConfigProperty configProperty) {
        super(configProperty);
    }

    @Override
    public List<CheckResult> check(Object obj) {
        List<CheckResult> checkResults = Lists.newArrayList();

        final IASTTranslationUnit translationUnit = (IASTTranslationUnit) obj;
        boolean isHeader = Collections2.filter(configProperty.getHeaderEndsWith(), new Predicate<String>() {
            @Override
            public boolean apply(String s) {
                return translationUnit.getFilePath().endsWith(s);
            }
        }).size() > 0;

        if (!isHeader) {
            return checkResults;
        }

        ASTStatementsVisitor statementsVisitor = new ASTStatementsVisitor();
        translationUnit.accept(statementsVisitor);

        boolean hasHeaderGuard = false;
        for (IASTPreprocessorStatement preprocessorStatement: translationUnit.getAllPreprocessorStatements()) {
            if (preprocessorStatement instanceof IASTPreprocessorIfndefStatement) {
                hasHeaderGuard = true;
                break;
            }
        }

        if (!hasHeaderGuard) {
            CheckResult checkResult = new CheckResult(
                ErrorItem.DEFINE_GUARD,
                ErrorType.STYLE,
                translationUnit.getFilePath()
            );
            checkResults.add(checkResult);

            // log 结果
            Map<String, Object> scopes = Maps.newHashMap();
            scopes.put("checkResult", checkResult);
            String comments = compileErrorMessage(errorMessage, scopes);
            logger.error(comments);
            checkResult.setComments(comments);
        }

        return checkResults;
    }
}
