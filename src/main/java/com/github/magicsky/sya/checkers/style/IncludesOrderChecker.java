package com.github.magicsky.sya.checkers.style;

import com.github.magicsky.sya.checkers.BaseChecker;
import com.github.magicsky.sya.enumerators.ErrorItem;
import com.github.magicsky.sya.enumerators.ErrorType;
import com.github.magicsky.sya.model.CheckResult;
import com.github.magicsky.sya.model.ConfigProperty;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.eclipse.cdt.core.dom.ast.IASTPreprocessorIncludeStatement;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;

import java.util.List;
import java.util.Map;

/**
 * @author 
 */
public class IncludesOrderChecker extends BaseChecker {

    private String errorMessage = "Unreasonable order of includes in {{fileName}}";

    public IncludesOrderChecker(ConfigProperty configProperty) {
        super(configProperty);
    }

    @Override
    public List<CheckResult> check(Object obj) {
        List<CheckResult> checkResults = Lists.newArrayList();

        IASTTranslationUnit translationUnit = (IASTTranslationUnit) obj;
        IASTPreprocessorIncludeStatement[] includeStatements = translationUnit.getIncludeDirectives();
        int lastSystemInclude = -1;
        int firstUserInclude = 0;
        int index = 0;
        for (IASTPreprocessorIncludeStatement includeStatement: includeStatements) {
            if (includeStatement.isSystemInclude()) {
                lastSystemInclude = index;
            }
            else {
                firstUserInclude = index;
            }
            ++ index;
        }
        if (lastSystemInclude > firstUserInclude) {
            CheckResult checkResult = new CheckResult(
                ErrorItem.INCLUDES_ORDER,
                ErrorType.STYLE,
                translationUnit.getFilePath()
            );
            checkResults.add(checkResult);

            // log 结果
            Map<String, Object> scopes = Maps.newHashMap();
            scopes.put("fileName", translationUnit.getFilePath());
            String comments = compileErrorMessage(errorMessage, scopes);
            logger.error(comments);
            checkResult.setComments(comments);
        }

        return checkResults;
    }
}
