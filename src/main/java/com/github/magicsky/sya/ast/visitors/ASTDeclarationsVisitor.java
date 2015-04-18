package com.github.magicsky.sya.ast.visitors;

import com.google.common.collect.Lists;
import lombok.Getter;
import org.eclipse.cdt.core.dom.ast.IASTDeclaration;

import java.util.List;

/**
 * 所有声明的访问者
 * @author 
 */
public class ASTDeclarationsVisitor extends BaseASTVisitor {

    @Getter
    private List<IASTDeclaration> declarations = Lists.newArrayList();

    public ASTDeclarationsVisitor() {
        super();
    }

    public int visit(IASTDeclaration declaration) {
        declarations.add(declaration);
        return PROCESS_CONTINUE;
    }

}
