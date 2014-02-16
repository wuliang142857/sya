package com.github.magicsky.sya.ast.visitors;

import com.google.common.collect.Lists;
import lombok.Getter;
import org.eclipse.cdt.core.dom.ast.IASTTypeId;

import java.util.List;

/**
 * @author garcia.wul@alibaba-inc.com
 */
public class ASTTypeIdsVisitor extends BaseASTVisitor {

    @Getter
    private List<IASTTypeId> typeIds = Lists.newArrayList();

    public ASTTypeIdsVisitor() {
        super();
    }

    public int visit(IASTTypeId typeId) {
        typeIds.add(typeId);
		return PROCESS_CONTINUE;
	}
}
