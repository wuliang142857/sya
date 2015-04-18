package com.github.magicsky.sya.ast.visitors;

import com.google.common.collect.Lists;
import lombok.Getter;
import org.eclipse.cdt.core.dom.ast.IASTParameterDeclaration;

import java.util.List;

/**
 * @author 
 */
public class ASTParameterDeclarationsVisitor extends BaseASTVisitor {

    @Getter
    List<IASTParameterDeclaration> parameterDeclarations = Lists.newArrayList();

    public ASTParameterDeclarationsVisitor() {
        super();
    }

    public int visit(IASTParameterDeclaration parameterDeclaration) {
        parameterDeclarations.add(parameterDeclaration);
		return PROCESS_CONTINUE;
	}
}
