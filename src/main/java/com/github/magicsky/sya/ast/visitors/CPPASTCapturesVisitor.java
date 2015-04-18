package com.github.magicsky.sya.ast.visitors;

import com.google.common.collect.Lists;
import lombok.Getter;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPASTCapture;

import java.util.List;

/**
 * @author 
 */
public class CPPASTCapturesVisitor extends BaseASTVisitor {

    @Getter
    private List<ICPPASTCapture> captures = Lists.newArrayList();

    public CPPASTCapturesVisitor() {
        super();
    }

    public int visit(ICPPASTCapture capture) {
        captures.add(capture);
		return PROCESS_CONTINUE;
	}
}
