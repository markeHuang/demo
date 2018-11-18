package com.marke.plugin.cache;

import com.marke.utils.BeanUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 键值对缓存
 *
 * @author marke.huang
 * @date 2018/9/27 0027 下午 3:52
 */
@Slf4j
@Service
public class TimeoutMapCache {

    /**
     * 缓存
     */
    private Map<String, Object> cache;

    /**
     * 过期时间
     */
    private Map<String, Long> tasks;

    public TimeoutMapCache() {
        cache = new ConcurrentHashMap<>();
        tasks = new ConcurrentHashMap<>();
        log.info("缓存初始化成功。");
    }

    /**
     * 获取所有缓存名称
     *
     * @param
     * @return java.util.Collection<java.lang.String>
     * @author marke.huang
     * @date 2018/9/27 0027 下午 3:52
     */
    public Collection<String> getCacheNames() {
        return cache.keySet();
    }

    /**
     * 存入缓存
     *
     * @param key 键
     * @param value 值
     * @param timeout 超时时间
     * @return void
     * @author marke.huang
     * @date 2018/9/27 0027 下午 3:53
     */
    public void set(@NotNull(message = "缓存键不能为空。") String key, Object value, long timeout) {
        this.delete(key);
        this.cache.put(key, BeanUtils.clone(value));
        if (timeout > 0L) {
            this.tasks.put(key, timeout * 1000L + System.currentTimeMillis());
        }
    }

    /**
     * 获取缓存
     *
     * @param key
     * @return java.lang.Object
     * @author marke.huang
     * @date 2018/9/27 0027 下午 3:53
     */
    public Object get(@NotNull(message = "缓存键不能为空。") String key) {
        Long timeout = this.tasks.get(key);
        if (timeout != null && timeout <= System.currentTimeMillis()) {
            this.delete(key);
        }
        return BeanUtils.clone(this.cache.get(key));
    }

    /**
     * 删除缓存
     *
     * @param key
     * @return void
     * @author marke.huang
     * @date 2018/9/27 0027 下午 3:53
     */
    public void delete(String key) {
        this.cache.remove(key);
        this.tasks.remove(key);
    }

    /**
     * 清除缓存
     *
     * @param
     * @return void
     * @author marke.huang
     * @date 2018/9/27 0027 下午 3:54
     */
    public void clear() {
        Set<Map.Entry<String, Long>> entries = tasks.entrySet();
        Iterator<Map.Entry<String, Long>> iterator = entries.iterator();
        Map.Entry<String, Long> entry = null;
        while (iterator.hasNext()) {
            entry = iterator.next();

            if (entry.getValue() != null && entry.getValue() <= System.currentTimeMillis()) {
                this.delete(entry.getKey());
            }
        }
    }

}
