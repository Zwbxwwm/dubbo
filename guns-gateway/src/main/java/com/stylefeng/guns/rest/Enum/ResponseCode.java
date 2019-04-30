package com.stylefeng.guns.rest.Enum;

public enum ResponseCode {
    SUCCESS(0,"请求成功！"),
    ERROR(1,"请求失败！"),
    SYS_ERROR(999,"系统出现异常，请联系管理员")
    ;

    ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    private int code;

    private String msg;
}
