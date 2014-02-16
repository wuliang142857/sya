package com.github.magicsky.sya.ast.visitors;

import com.google.common.collect.Lists;
import lombok.Getter;
import org.eclipse.cdt.core.dom.ast.IASTProblem;

import java.util.List;

/**
 * @author garcia.wul@alibaba-inc.com
 */
public class ASTProblemsVisitor extends BaseASTVisitor {

    @Getter
    private List<IASTProblem> problems = Lists.newArrayList();

    public ASTProblemsVisitor() {
        super();
    }

    public int visit( IASTProblem problem ){
        problems.add(problem);
		return PROCESS_CONTINUE;
	}
}
