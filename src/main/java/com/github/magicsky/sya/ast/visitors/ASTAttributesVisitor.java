package com.github.magicsky.sya.ast.visitors;

import com.google.common.collect.Lists;
import lombok.Getter;
import org.eclipse.cdt.core.dom.ast.IASTAttribute;

import java.util.List;

/**
 * @author garcia.wul@alibaba-inc.com
 */
public class ASTAttributesVisitor extends BaseASTVisitor {

    @Getter
    private List<IASTAttribute> attributes = Lists.newArrayList();

    public ASTAttributesVisitor() {
        super();
    }

    public int visit(IASTAttribute attribute) {
        attributes.add(attribute);
		return PROCESS_CONTINUE;
	}
}
