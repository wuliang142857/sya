package com.github.magicsky.sya.ast.ext;

import com.github.magicsky.sya.ast.visitors.BaseASTVisitor;
import com.google.common.collect.Lists;
import lombok.Getter;
import org.eclipse.cdt.core.dom.ast.IASTDeclaration;
import org.eclipse.cdt.core.dom.ast.IASTFunctionDefinition;

import java.util.List;

/**
 * @author garcia.wul@alibaba-inc.com
 */
public class ASTFunctionDefinitionVisitor extends BaseASTVisitor {

    @Getter
    private List<IASTFunctionDefinition> functionDefinitions = Lists.newArrayList();

    public ASTFunctionDefinitionVisitor() {
        super();
    }

    public int visit(IASTDeclaration declaration) {
        if (declaration instanceof IASTFunctionDefinition) {
            functionDefinitions.add((IASTFunctionDefinition) declaration);
        }

        return PROCESS_CONTINUE;
    }
}
