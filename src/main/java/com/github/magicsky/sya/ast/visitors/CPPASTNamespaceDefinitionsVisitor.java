package com.github.magicsky.sya.ast.visitors;

import com.google.common.collect.Lists;
import lombok.Getter;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPASTNamespaceDefinition;

import java.util.List;

/**
 * @author garcia.wul@alibaba-inc.com
 */
public class CPPASTNamespaceDefinitionsVisitor extends BaseASTVisitor {

    @Getter
    private List<ICPPASTNamespaceDefinition> namespaceDefinitions = Lists.newArrayList();

    public CPPASTNamespaceDefinitionsVisitor() {
        super();
    }

    public int visit(ICPPASTNamespaceDefinition namespaceDefinition) {
        namespaceDefinitions.add(namespaceDefinition);
		return PROCESS_CONTINUE;
	}
 }
