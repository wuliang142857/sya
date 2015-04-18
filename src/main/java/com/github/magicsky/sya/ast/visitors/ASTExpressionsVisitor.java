package com.github.magicsky.sya.ast.visitors;

import com.google.common.collect.Lists;
import lombok.Getter;
import org.eclipse.cdt.core.dom.ast.IASTExpression;

import java.util.List;

/**
 * @author 
 */
public class ASTExpressionsVisitor extends BaseASTVisitor {

    @Getter
    private List<IASTExpression> expressions = Lists.newArrayList();

    public ASTExpressionsVisitor() {
        super();
    }

    public int visit(IASTExpression expression) {
        expressions.add(expression);
		return PROCESS_CONTINUE;
	}
}
