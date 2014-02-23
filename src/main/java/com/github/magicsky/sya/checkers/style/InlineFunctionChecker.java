package com.github.magicsky.sya.checkers.style;

import com.github.magicsky.sya.ast.ASTTranslationUnitCore;
import com.github.magicsky.sya.ast.IASTTranslationUnitCore;
import com.github.magicsky.sya.ast.ext.ASTCompositeTypeDeclarationVisitor;
import com.github.magicsky.sya.ast.ext.ASTFunctionDefinitionVisitor;
import com.github.magicsky.sya.ast.visitors.ASTExpressionsVisitor;
import com.github.magicsky.sya.ast.visitors.ASTStatementsVisitor;
import com.github.magicsky.sya.checkers.BaseChecker;
import com.github.magicsky.sya.enumerators.ErrorItem;
import com.github.magicsky.sya.enumerators.ErrorType;
import com.github.magicsky.sya.model.CheckResult;
import com.github.magicsky.sya.model.ConfigProperty;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.eclipse.cdt.core.dom.ast.*;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPASTTryBlockStatement;
import org.eclipse.cdt.core.parser.ParserLanguage;

import java.util.List;
import java.util.Map;

/**
 * @author garcia.wul@alibaba-inc.com
 */
public class InlineFunctionChecker extends BaseChecker {

    private String errorMessage = "{{{checkResult.errorItem.desc}}} for {{{functionName}}} in {{{checkResult.fileName}}}}}}";

    public InlineFunctionChecker(ConfigProperty configProperty) {
        super(configProperty);
    }

    @Override
    public List<CheckResult> check(Object obj) {
        List<CheckResult> checkResults = Lists.newArrayList();

        IASTTranslationUnit translationUnit = (IASTTranslationUnit) obj;
        ASTFunctionDefinitionVisitor functionDefinitionVisitor = new ASTFunctionDefinitionVisitor();
        translationUnit.accept(functionDefinitionVisitor);
        ASTCompositeTypeDeclarationVisitor compositeTypeDeclarationVisitor =
            new ASTCompositeTypeDeclarationVisitor();
        translationUnit.accept(compositeTypeDeclarationVisitor);

        for (IASTFunctionDefinition functionDefinition: functionDefinitionVisitor.getFunctionDefinitions()) {
            boolean invalidInline = false;
            IASTName name = functionDefinition.getDeclarator().getName();
            if (!(name.resolveBinding() instanceof IFunction))
                continue;
            IFunction function = (IFunction) name.resolveBinding();
            if (!function.isInline())
                continue;
            // 如果是主函数
            if (isMainFunction(functionDefinition))
                invalidInline = true;
            // 如果函数行数大于10行
            if (isLineNumberGreaterThanTen(functionDefinition))
                invalidInline = true;
            // 是否是递归函数
            if (isRecursiveFunction(functionDefinition))
                invalidInline = true;
            // 是否包含循环
            if (hasLoopStatements(functionDefinition))
                invalidInline = true;
            // 是否是析构函数
            if (isDestructor(functionDefinition))
                invalidInline = true;
            if (invalidInline) {
                CheckResult checkResult = new CheckResult(
                    ErrorItem.INLINE_FUNCTION,
                    ErrorType.STYLE,
                    translationUnit.getFilePath(),
                    functionDefinition.getFileLocation().getStartingLineNumber(),
                    functionDefinition.getFileLocation().getEndingLineNumber()
                );
                checkResults.add(checkResult);

                // log
                Map<String, Object> scopes = Maps.newHashMap();
                scopes.put("checkResult", checkResult);
                scopes.put("functionName", name.resolveBinding().getName());
                String comments = compileErrorMessage(errorMessage, scopes);
                logger.error(comments);
                checkResult.setComments(comments);
            }
        }
        return checkResults;
    }

    /**
     * 是否是main函数
     */
    private boolean isMainFunction(IASTFunctionDefinition functionDefinition) {
        IASTFunctionDeclarator functionDeclarator = functionDefinition.getDeclarator();
        IASTName name = functionDeclarator.getName();
        IBinding binding = name.resolveBinding();
        return binding.getName().equals("main");
    }

    /**
     * 如果函数大于10行
     */
    private boolean isLineNumberGreaterThanTen(IASTFunctionDefinition functionDefinition) {
        IASTStatement statement = functionDefinition.getBody();
        return statement.getRawSignature().split("\n").length > 10;
    }

    /**
     * 是否是递归函数
     */
    private boolean isRecursiveFunction(
        IASTFunctionDefinition functionDefinition
    ) {
        String[] fields = functionDefinition.getDeclarator().getName().resolveBinding().getName().split(":");
        if (fields.length <= 0)
            return false;
        String functionName = fields.length == 1 ? fields[0] : fields[fields.length - 1];
        IASTTranslationUnitCore translationUnitCore = new ASTTranslationUnitCore();

        IASTTranslationUnit translationUnit = translationUnitCore.parseCode(
            functionDefinition.getRawSignature(),
            ParserLanguage.CPP, true, false
        );
        ASTExpressionsVisitor expressionsVisitor = new ASTExpressionsVisitor();
        translationUnit.accept(expressionsVisitor);
        for (IASTExpression expression: expressionsVisitor.getExpressions()) {
            if (!(expression instanceof IASTFunctionCallExpression))
                continue;
            IASTFunctionCallExpression functionCallExpression = (IASTFunctionCallExpression) expression;
            if (functionCallExpression.getFunctionNameExpression().toString().equals(functionName))
                return true;
        }
        return false;
    }

    /**
     * 是否包含循环
     */
    private boolean hasLoopStatements(IASTFunctionDefinition functionDefinition) {
        IASTTranslationUnitCore translationUnitCore = new ASTTranslationUnitCore();
        IASTTranslationUnit translationUnit = translationUnitCore.parseCode(
            functionDefinition.getRawSignature(), ParserLanguage.CPP, true, false
        );
        ASTStatementsVisitor statementsVisitor = new ASTStatementsVisitor();
        translationUnit.accept(statementsVisitor);
        for (IASTStatement statement: statementsVisitor.getStatements()) {
            if (statement instanceof IASTForStatement ||
                statement instanceof IASTDoStatement ||
                statement instanceof IASTWhileStatement ||
                statement instanceof IASTSwitchStatement ||
                statement instanceof ICPPASTTryBlockStatement ||
                statement instanceof IASTGotoStatement ||
                statement instanceof IASTLabelStatement
                )
                return true;
        }
        return false;
    }

    /**
     * 是否是析构函数
     */
    private boolean isDestructor(IASTFunctionDefinition functionDefinition) {
        return functionDefinition.getDeclarator().getName().resolveBinding().getName().contains("~");
    }
}
