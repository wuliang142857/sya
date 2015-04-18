package com.github.magicsky.sya.ast.visitors;

import com.google.common.collect.Lists;
import lombok.Getter;
import org.eclipse.cdt.core.dom.ast.IASTArrayModifier;

import java.util.List;

/**
 * @author 
 */
public class ASTArrayModifiersVisitor extends BaseASTVisitor {

    @Getter
    private List<IASTArrayModifier> arrayModifiers = Lists.newArrayList();

    public ASTArrayModifiersVisitor() {
        super();
    }

    public int visit(IASTArrayModifier arrayModifier) {
        arrayModifiers.add(arrayModifier);
		return PROCESS_CONTINUE;
	}
}
