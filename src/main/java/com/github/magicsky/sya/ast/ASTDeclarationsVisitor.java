package com.github.magicsky.sya.ast;

import com.google.common.collect.Lists;
import lombok.Getter;
import org.eclipse.cdt.core.dom.ast.ASTVisitor;
import org.eclipse.cdt.core.dom.ast.IASTDeclaration;

import java.util.List;

/**
 * @author garcia.wul@alibaba-inc.com
 */
public class ASTDeclarationsVisitor extends ASTVisitor {

    @Getter
    private List<IASTDeclaration> declarations = Lists.newArrayList();

    public ASTDeclarationsVisitor() {
        super.shouldVisitAmbiguousNodes = true;
        super.shouldVisitArrayModifiers = true;
        super.shouldVisitBaseSpecifiers = true;
        super.shouldVisitDeclarations = true;
        super.shouldVisitDeclarators = true;
        super.shouldVisitDeclSpecifiers = true;
        super.shouldVisitDesignators = true;
        super.shouldVisitEnumerators = true;
        super.shouldVisitExpressions = true;
        super.shouldVisitImplicitNameAlternates = true;
        super.shouldVisitImplicitNames = true;
        super.shouldVisitInitializers = true;
        super.shouldVisitNames = true;
        super.shouldVisitNamespaces = true;
        super.shouldVisitParameterDeclarations = true;
        super.shouldVisitPointerOperators = true;
        super.shouldVisitProblems = true;
        super.shouldVisitStatements = true;
        super.shouldVisitTemplateParameters = true;
        super.shouldVisitTranslationUnit = true;
        super.shouldVisitTypeIds = true;
    }

    public int visit(IASTDeclaration declaration) {
        declarations.add(declaration);
        return PROCESS_CONTINUE;
    }

}
