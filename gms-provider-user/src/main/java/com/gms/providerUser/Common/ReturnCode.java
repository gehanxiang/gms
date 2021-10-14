package com.gms.providerUser.Common;

public enum ReturnCode {
    /**操作成功**/
    RC100(100,"操作成功"),
    /**操作失败**/
    RC999(999,"操作失败"),
    /**服务限流**/
    LIMIT_ERROR(2001,"系统繁忙,请稍后再试!"),
    /**服务异常**/
    RC500(500,"系统异常，请稍后重试");
    /**自定义状态码**/
    private final int code;
    /**自定义描述**/
    private final String message;

    ReturnCode(int code, String message){
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
