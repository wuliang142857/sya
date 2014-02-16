package com.github.magicsky.sya.ast.visitors;

import com.google.common.collect.Lists;
import lombok.Getter;
import org.eclipse.cdt.core.dom.ast.c.ICASTDesignator;

import java.util.List;

/**
 * @author garcia.wul@alibaba-inc.com
 */
public class CASTDesignatorsVisitor extends BaseASTVisitor {

    @Getter
    private List<ICASTDesignator> designators = Lists.newArrayList();

    public CASTDesignatorsVisitor() {
        super();
    }

    public int visit(ICASTDesignator designator) {
        designators.add(designator);
		return PROCESS_CONTINUE;
	}
}
