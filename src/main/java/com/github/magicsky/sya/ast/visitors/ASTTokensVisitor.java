package com.github.magicsky.sya.ast.visitors;

import com.google.common.collect.Lists;
import lombok.Getter;
import org.eclipse.cdt.core.dom.ast.IASTToken;

import java.util.List;

/**
 * @author 
 */
public class ASTTokensVisitor extends BaseASTVisitor {

    @Getter
    private List<IASTToken> tokens = Lists.newArrayList();

    public ASTTokensVisitor() {
        super();
    }

    public int visit(IASTToken token) {
        tokens.add(token);
		return PROCESS_CONTINUE;
	}
}
