package com.github.magicsky.sya.ast.visitors;

import com.google.common.collect.Lists;
import lombok.Getter;
import org.eclipse.cdt.core.dom.ast.IASTDeclSpecifier;

import java.util.List;

/**
 * @author garcia.wul@alibaba-inc.com
 */
public class ASTDeclSpecifiersVisitor extends BaseASTVisitor {

    @Getter
    private List<IASTDeclSpecifier> declSpecifiers = Lists.newArrayList();

    public ASTDeclSpecifiersVisitor() {
        super();
    }

    public int visit(IASTDeclSpecifier declSpec) {
        declSpecifiers.add(declSpec);
		return PROCESS_CONTINUE;
	}
}
