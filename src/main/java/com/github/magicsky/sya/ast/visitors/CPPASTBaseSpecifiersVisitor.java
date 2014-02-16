package com.github.magicsky.sya.ast.visitors;

import com.google.common.collect.Lists;
import lombok.Getter;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPASTCompositeTypeSpecifier;

import java.util.List;

/**
 * @author garcia.wul@alibaba-inc.com
 */
public class CPPASTBaseSpecifiersVisitor extends BaseASTVisitor {

    @Getter
    private List<ICPPASTCompositeTypeSpecifier.ICPPASTBaseSpecifier> baseSpecifiers = Lists.newArrayList();

    public CPPASTBaseSpecifiersVisitor() {
        super();
    }

    public int visit(ICPPASTCompositeTypeSpecifier.ICPPASTBaseSpecifier baseSpecifier) {
        baseSpecifiers.add(baseSpecifier);
		return PROCESS_CONTINUE;
	}
}
