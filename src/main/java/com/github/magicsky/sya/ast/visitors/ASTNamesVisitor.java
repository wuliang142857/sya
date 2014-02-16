package com.github.magicsky.sya.ast.visitors;

import com.google.common.collect.Lists;
import lombok.Getter;
import org.eclipse.cdt.core.dom.ast.IASTName;

import java.util.List;

/**
 * @author garcia.wul@alibaba-inc.com
 */
public class ASTNamesVisitor extends BaseASTVisitor {

    @Getter
    private List<IASTName> names = Lists.newArrayList();

    public ASTNamesVisitor() {
        super();
    }

    public int visit(IASTName name) {
        names.add(name);
        return PROCESS_CONTINUE;
    }
}