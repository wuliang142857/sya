package com.github.magicsky.sya.ast.visitors;

import com.google.common.collect.Lists;
import lombok.Getter;
import org.eclipse.cdt.core.dom.ast.IASTInitializer;

import java.util.List;

/**
 * @author 
 */
public class ASTInitializersVisitor extends BaseASTVisitor {

    @Getter
    private List<IASTInitializer> initializers = Lists.newArrayList();

    public ASTInitializersVisitor() {
        super();
    }

    public int visit(IASTInitializer initializer) {
        initializers.add(initializer);
		return PROCESS_CONTINUE;
	}

}
