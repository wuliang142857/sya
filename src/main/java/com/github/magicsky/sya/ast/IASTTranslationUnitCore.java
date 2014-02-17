package com.github.magicsky.sya.ast;

import org.eclipse.cdt.core.parser.ParserLanguage;

/**
 * @author garcia.wul@alibaba-inc.com
 */
public interface IASTTranslationUnitCore {

    /**
     * 解析输入文件的AST
     */
    public org.eclipse.cdt.core.dom.ast.IASTTranslationUnit parseFile(
        String file,
        ParserLanguage parserLanguage,
        boolean useGNUExtensions,
        boolean skipTrivialInitializers
    );

    /**
     * 解析输入代码的AST
     */
    public org.eclipse.cdt.core.dom.ast.IASTTranslationUnit parseCode(
        String code,
        ParserLanguage parserLanguage,
        boolean useGNUExtensions,
        boolean skipTrivialInitializers
    );
}
