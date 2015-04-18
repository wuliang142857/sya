package com.github.magicsky.sya.ast.ext;

import com.github.magicsky.sya.ast.visitors.BaseASTVisitor;
import com.google.common.collect.Lists;
import lombok.Getter;
import org.eclipse.cdt.core.dom.ast.*;

import java.util.List;

/**
 * @author 
 */
public class ASTCompositeTypeDeclarationVisitor extends BaseASTVisitor {

    @Getter
    private List<IASTSimpleDeclaration> declarations = Lists.newArrayList();

    public int visit(IASTDeclaration declaration) {
        if (!(declaration instanceof IASTSimpleDeclaration))
            return PROCESS_CONTINUE;
        IASTSimpleDeclaration simpleDeclaration = (IASTSimpleDeclaration) declaration;

        IASTDeclSpecifier declSpecifier = ((IASTSimpleDeclaration) declaration).getDeclSpecifier();
        if (!(declSpecifier instanceof IASTCompositeTypeSpecifier))
            return PROCESS_CONTINUE;

        declarations.add(simpleDeclaration);

        return PROCESS_CONTINUE;
    }

}
