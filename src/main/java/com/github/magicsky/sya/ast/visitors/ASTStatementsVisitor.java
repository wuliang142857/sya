package com.github.magicsky.sya.ast.visitors;

import com.google.common.collect.Lists;
import lombok.Getter;
import org.eclipse.cdt.core.dom.ast.IASTStatement;

import java.util.List;

/**
 * 语句的访问者
 * @author 
 */
public class ASTStatementsVisitor extends BaseASTVisitor {

    @Getter
    private List<IASTStatement> statements = Lists.newArrayList();

    public ASTStatementsVisitor() {
        super();
    }

    public int visit(IASTStatement statement) {
        statements.add(statement);
        return PROCESS_CONTINUE;
    }

}
