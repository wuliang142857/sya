package com.github.magicsky.sya.enumerators;

/**
 * @author garcia.wul@alibaba-inc.com
 */
public enum CheckType {
    AUTO_PTR(1, "任何情况下都不要使用auto_ptr"),
    ;

    private int value;
    private String desc;

     CheckType(int value, String desc) {
        setValue(value);
        setDesc(desc);
    }

    public static CheckType getDescByValue(int value) {
        CheckType checkType = null;
        for (CheckType type: CheckType.values()) {
            if (type.getValue() == value) {
                checkType = type;
                break;
            }
        }
        return checkType;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
