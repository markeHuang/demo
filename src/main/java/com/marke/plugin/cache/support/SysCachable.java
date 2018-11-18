package com.marke.plugin.cache.support;

import java.util.Collection;

/**
 * 可缓存的接口 .<br>
 *
 * @author andy.sher
 * @date 2018/10/22 9:20
 */
public interface SysCachable {

    /**
     * 获取缓存名称 .
     *
     * @param
     * @return java.util.Collection<java.lang.String> 缓存名称集合
     * @author andy.sher
     * @date 2018/10/22 9:21
     */
    Collection<String> getCacheNames();

}
