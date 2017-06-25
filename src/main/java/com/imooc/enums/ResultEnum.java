package com.imooc.enums;

/**
 * Created by hongcj on 2017/6/25.
 */
public enum ResultEnum {
    UNKNOW_ERROR(-1,"系统错误"),
    SUCCESS(0,"成功"),
    PRIVATE_SCHOOL(100,"你可能还在上小学吧"),
    MIDDLE_SCHOOL(101,"你可能在上中学吧"),
    ;
    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
