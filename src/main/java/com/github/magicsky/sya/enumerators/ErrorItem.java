package com.github.magicsky.sya.enumerators;

/**
 * @author garcia.wul@alibaba-inc.com
 */
public enum ErrorItem {
    SMART_POINTER(1, "不要使用类似std::auto_ptr这些有风险分智能指针"),
    BUFFER_OVERFLOW_FUNCTION(2, "不要使用会造成缓冲区溢出(buffer overflow)的函数"),
    DEFINE_GUARD(3, "建议使用#define对头文件进行保护"),
    INCLUDES_ORDER(4, "使用标准的头文件包含顺序可增强可读性，并且避免隐性依赖")
    ;

    private int value;
    private String desc;

     ErrorItem(int value, String desc) {
        setValue(value);
        setDesc(desc);
    }

    public static ErrorItem getDescByValue(int value) {
        ErrorItem errorItem = null;
        for (ErrorItem type: ErrorItem.values()) {
            if (type.getValue() == value) {
                errorItem = type;
                break;
            }
        }
        return errorItem;
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
