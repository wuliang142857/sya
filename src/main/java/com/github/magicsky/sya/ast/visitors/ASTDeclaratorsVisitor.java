package com.github.magicsky.sya.ast.visitors;

import com.google.common.collect.Lists;
import lombok.Getter;
import org.eclipse.cdt.core.dom.ast.IASTDeclarator;

import java.util.List;

/**
 * @author garcia.wul@alibaba-inc.com
 */
public class ASTDeclaratorsVisitor extends BaseASTVisitor {

    @Getter
    private List<IASTDeclarator> declarators = Lists.newArrayList();

    public ASTDeclaratorsVisitor() {
        super();
    }

    public int visit(IASTDeclarator declarator) {
        declarators.add(declarator);
		return PROCESS_CONTINUE;
	}
}
