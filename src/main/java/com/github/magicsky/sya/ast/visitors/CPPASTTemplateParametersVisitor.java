package com.github.magicsky.sya.ast.visitors;

import com.google.common.collect.Lists;
import lombok.Getter;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPASTTemplateParameter;

import java.util.List;

/**
 * @author garcia.wul@alibaba-inc.com
 */
public class CPPASTTemplateParametersVisitor extends BaseASTVisitor {

    @Getter
    private List<ICPPASTTemplateParameter> templateParameters = Lists.newArrayList();

    public CPPASTTemplateParametersVisitor() {
        super();
    }

    public int visit(ICPPASTTemplateParameter templateParameter) {
        templateParameters.add(templateParameter);
		return PROCESS_CONTINUE;
	}
}
