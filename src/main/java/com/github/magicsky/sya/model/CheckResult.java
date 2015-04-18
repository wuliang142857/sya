package com.github.magicsky.sya.model;

import com.github.magicsky.sya.enumerators.ErrorItem;
import com.github.magicsky.sya.enumerators.ErrorType;
import lombok.Data;

/**
 * @author 
 */
@Data
public class CheckResult {
    private ErrorItem errorItem;
    private ErrorType errorType;
    private int startingLineNumber;
    private int endingLineNumber;
    private String fileName;
    private String comments;

    public CheckResult(ErrorItem errorItem, ErrorType errorType, String fileName) {
        setErrorItem(errorItem);
        setErrorType(errorType);
        setFileName(fileName);
    }

    public CheckResult(ErrorItem errorItem, ErrorType errorType,
                       String fileName,
                       int startingLineNumber, int endingLineNumber) {
        setErrorItem(errorItem);
        setErrorType(errorType);
        setFileName(fileName);
        setStartingLineNumber(startingLineNumber);
        setEndingLineNumber(endingLineNumber);
    }
}
