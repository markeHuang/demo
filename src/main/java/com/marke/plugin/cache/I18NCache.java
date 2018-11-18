package com.marke.plugin.cache;

import com.marke.plugin.cache.support.SysCachable;
import com.marke.utils.BeanUtils;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 国际化缓存
 *
 * @author marke.huang
 * @date 2018/11/18 19:57
 */
@Service
public class I18NCache implements SysCachable {

    /**
     * 缓存
     */
    private Map<String, String> cache;

    /**
     * 容器大小【取决于配置文件有多少数据项，注意：需要保持一致】
     */
    private int size = 274;

    public I18NCache() {
        cache = new HashMap<>(size);
    }

    /**
     * 获取多语言
     *
     * @param key
     * @return java.lang.String
     * @author marke.huang
     * @date 2018/11/18 19:57
     */
    public String getI18N(String key) {
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        return null;
    }

    /**
     * 获取所有国际化的键
     *
     * @return java.util.Collection<java.lang.String>
     * @author marke.huang
     * @date 2018/11/18 19:57
     */
    @Override
    public Collection<String> getCacheNames() {
        return cache.keySet();
    }

    /**
     * 存入缓存
     *
     * @param key
     * @param value
     * @return void
     * @author marke.huang
     * @date 2018/11/18 19:57
     */
    public void set(@NotNull(message = "缓存键不能为空。") String key, String value) {
        this.cache.put(key, BeanUtils.clone(value).toString());
    }


}
