package com.github.magicsky.sya.ast.visitors;

import com.google.common.collect.Lists;
import lombok.Getter;
import org.eclipse.cdt.core.dom.ast.IASTPointerOperator;

import java.util.List;

/**
 * @author garcia.wul@alibaba-inc.com
 */
public class ASTPointerOperatorsVisitor extends BaseASTVisitor {

    @Getter
    private List<IASTPointerOperator> pointerOperators = Lists.newArrayList();

    public ASTPointerOperatorsVisitor() {
        super();
    }

    public int visit(IASTPointerOperator ptrOperator) {
        pointerOperators.add(ptrOperator);
		return PROCESS_CONTINUE;
	}
}
