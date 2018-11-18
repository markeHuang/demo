package com.marke.api.enums;

/**
 * 响应代码
 *
 * @author marke.huang
 * @date 2018/11/18 19:43
 */
public enum RespCodeEnum {

    /**
     * 请求成功
     */
    SUCCESS(1, "请求成功！"),

    /**
     * 请求失败
     */
    FAILD(0, "请求失败！"),

    /**
     * 请求中含有非法参数
     */
    ILLEGAL_PARAMETER(2, "请求中含有非法参数"),

    /**
     * 授权失败
     */
    UNAUTHORIZED(401, "授权失败"),

    /**
     * TOKEN过期
     */
    TOKEN_EXPIRED(402, "Token已过期"),

    /**
     * TOKEN无效
     */
    TOKEN_INVALID(403, "Token无效");

    RespCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private int code;

    private String msg;

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
