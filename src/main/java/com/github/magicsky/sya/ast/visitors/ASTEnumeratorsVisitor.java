package com.github.magicsky.sya.ast.visitors;

import com.google.common.collect.Lists;
import lombok.Getter;
import org.eclipse.cdt.core.dom.ast.IASTEnumerationSpecifier;

import java.util.List;

/**
 * @author 
 */
public class ASTEnumeratorsVisitor extends BaseASTVisitor {
    @Getter
    private List<IASTEnumerationSpecifier.IASTEnumerator> enumerators = Lists.newArrayList();

    public ASTEnumeratorsVisitor() {
        super();
    }

    public int visit(IASTEnumerationSpecifier.IASTEnumerator enumerator) {
        enumerators.add(enumerator);
		return PROCESS_CONTINUE;
	}
}
