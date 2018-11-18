package com.marke.constant;

/**
 * 超时时间常量类
 *
 * @author marke.huang
 * @date 2018/9/27 0027 下午 3:52
 */
public final class TimeoutConstants {
    private TimeoutConstants() {

    }

    /**
     * 邮箱验证码超时时间
     */
    public static final Integer EMAIL_CODE = 300;

    /**
     * Token超时时间
     *
     * @author marke.huang
     * @date 2018/11/17 22:18
     */
    public static final Long TOKEN_TIMEOUT = 86400000L;

}
