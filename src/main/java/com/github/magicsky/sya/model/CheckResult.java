package com.github.magicsky.sya.model;

import com.github.magicsky.sya.enumerators.CheckType;
import lombok.Data;

/**
 * @author garcia.wul@alibaba-inc.com
 */
@Data
public class CheckResult {
    private CheckType type;
    private int startingLineNumber;
    private int endingLineNumber;
    private String fileName;

    public CheckResult(CheckType type, String fileName, int startingLineNumber, int endingLineNumber) {
        setType(type);
        setFileName(fileName);
        setStartingLineNumber(startingLineNumber);
        setEndingLineNumber(endingLineNumber);
    }
}
