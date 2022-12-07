package com.jaysunxl.scaffold.constant;

import com.jaysunxl.scaffold.service.IResult;

/**
 * @author JaySunXl
 * @date 2022-10-19
 */
public enum ResultEnum implements IResult {
    SUCCESS(200, "接口调用成功"),
    VALIDATE_FAILED(201, "参数校验失败"),
    COMMON_FAILED(202, "接口调用失败"),
    FORBIDDEN(203, "没有权限访问资源");

    private Integer code;
    private String message;;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return null;
    }

    @Override
    public String getMessage() {
        return null;
    }
}
