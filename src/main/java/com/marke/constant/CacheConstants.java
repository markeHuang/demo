package com.marke.constant;

/**
 * 缓存常量类
 *
 * @author marke.huang
 * @date 2018/9/27 0027 下午 3:45
 */
public final class CacheConstants {

    private CacheConstants() {
    }

    /**
     * 系统配置缓存常量
     *
     * @author marke.huang
     * @date 2018/9/27 0027 下午 3:45
     */
    public final class Config {

        /**
         * 系统缓存前缀
         */
        public static final String CACHE_KEY_PREFIX = "CONFIG_CACHE_";

    }

    /**
     * 安控缓存常量
     *
     * @author marke.huang
     * @date 2018/9/27 0027 下午 3:45
     */
    public final class Authz {

        /**
         * 用户登录凭证缓存键
         */
        public static final String CACHE_KEY_PREFIX = "AUTHZ_CACHE_";

    }

}
