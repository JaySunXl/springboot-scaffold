package com.jaysunxl.scaffold.constant;

/**
 * @author JaySunXl
 * @create 2022-09-25
 * @description
 */
public enum OperationType {
    UNKNOWN("unknown"),
    DELETE("delete"),
    SELECT("select"),
    UPDATE("update"),
    INSERT("insert");

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    OperationType(String s) {
        this.value = s;
    }
}
