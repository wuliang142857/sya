package com.github.magicsky.sya.checkers.risk;

import com.github.magicsky.sya.ast.visitors.ASTExpressionsVisitor;
import com.github.magicsky.sya.checkers.BaseChecker;
import com.github.magicsky.sya.enumerators.ErrorItem;
import com.github.magicsky.sya.enumerators.ErrorType;
import com.github.magicsky.sya.model.CheckResult;
import com.github.magicsky.sya.model.ConfigProperty;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.eclipse.cdt.core.dom.ast.IASTExpression;
import org.eclipse.cdt.core.dom.ast.IASTFunctionCallExpression;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author garcia.wul@alibaba-inc.com
 */
public class BufferOverflowFunctionChecker extends BaseChecker {

    private String errorMessage = "{{{functionName}}} is buffer overflow function, in {{{checkResult.fileName}}}, line: {{{checkResult.startingLineNumber}}}";

    private Set<String> overflowFunctions = Sets.newHashSet(
        // 这些是针对Linux下的
        "strcpy",
        "strcat",
        "sprintf",
        "vsprintf",
        "gets",
        "realpath",
        "getopt",
        "getpass",
        "streadd",
        "strecpy",
        "strtrns",
        "wcscat",
        // 这些起始是针对Windows
        "lstrcat",
        "StrCatBuff",
        "_tcscat",
        "_ftcscat",
        "strncat",
        "StrNCat",
        "strcpy",
        "wcscpy",
        "lstrcpy",
        "_tcscpy",
        "_ftcscpy",
        "Strncpy",
        "gets",
        "_getws",
        "_getts",
        "sprintf",
        "swprintf",
        "wsprintf",
        "wnsprintf",
        "_stprintf",
        "_snprintf",
        "_snwprintf",
        "_sntprintf",
        "vsprintf",
        "vswprintf",
        "wvsprintf",
        "wvnsprintf",
        "_vstprintf",
        "_vsnprintf",
        "_vsnwprintf",
        "_vsntprintf",
        "Strlen"
    );

    public BufferOverflowFunctionChecker(ConfigProperty configProperty) {
        super(configProperty);
    }

    @Override
    public List<CheckResult> check(Object obj) {
        List<CheckResult> checkResults = Lists.newArrayList();

        IASTTranslationUnit translationUnit = (IASTTranslationUnit) obj;
        ASTExpressionsVisitor expressionsVisitor = new ASTExpressionsVisitor();
        translationUnit.accept(expressionsVisitor);

        for (IASTExpression expression: expressionsVisitor.getExpressions()) {
            if (!(expression instanceof IASTFunctionCallExpression))
                continue;
            IASTFunctionCallExpression callExpression = (IASTFunctionCallExpression) expression;
            if (callExpression.getFunctionNameExpression() == null)
                continue;
            if (!overflowFunctions.contains(callExpression.getFunctionNameExpression().toString()))
                continue;
            CheckResult checkResult = new CheckResult(
                ErrorItem.BUFFER_OVERFLOW_FUNCTION,
                ErrorType.RISK,
                translationUnit.getFilePath(),
                expression.getFileLocation().getStartingLineNumber(),
                expression.getFileLocation().getEndingLineNumber()
            );
            checkResults.add(checkResult);

            // log
            Map<String, Object> scopes = Maps.newHashMap();
            scopes.put("checkResult", checkResult);
            scopes.put("functionName", callExpression.getFunctionNameExpression().toString());
            String comments = compileErrorMessage(errorMessage, scopes);
            logger.error(comments);

            checkResult.setComments(comments);
        }

        return checkResults;
    }
}
