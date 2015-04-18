package com.github.magicsky.sya.ast.visitors;

import org.eclipse.cdt.core.dom.ast.ASTVisitor;

/**
 * @author 
 */
public class BaseASTVisitor extends ASTVisitor {

    public BaseASTVisitor() {
        super.shouldVisitNames = true;
        super.shouldVisitDeclarations = true;
        super.shouldVisitInitializers = true;
        super.shouldVisitParameterDeclarations = true;
        super.shouldVisitDeclarators = true;
        super.shouldVisitDeclSpecifiers = true;
        super.shouldVisitArrayModifiers = true;
        super.shouldVisitPointerOperators = true;
        super.shouldVisitAttributes = true;
        super.shouldVisitTokens = true;
        super.shouldVisitExpressions = true;
        super.shouldVisitStatements = true;
        super.shouldVisitTypeIds = true;
        super.shouldVisitEnumerators = true;
        super.shouldVisitTranslationUnit = true;
        super.shouldVisitProblems = true;
        super.shouldVisitDesignators = true;
        super.shouldVisitBaseSpecifiers = true;
        super.shouldVisitNamespaces = true;
        super.shouldVisitTemplateParameters = true;
        super.shouldVisitCaptures = true;
        super.includeInactiveNodes = true;
        super.shouldVisitAmbiguousNodes = true;
        super.shouldVisitImplicitNames = true;
        super.shouldVisitImplicitNameAlternates = true;
    }

}
