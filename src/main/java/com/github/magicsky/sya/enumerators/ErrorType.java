package com.github.magicsky.sya.enumerators;

/**
 * @author 
 */
public enum ErrorType {
    STYLE(1, "编码分隔"),
    RISK(2, "风险")
    ;

    private int value;
    private String desc;

    ErrorType(int value, String desc) {
        setValue(value);
        setDesc(desc);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
