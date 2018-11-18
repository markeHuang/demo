package com.marke.utils;

import com.marke.plugin.cache.TimeoutMapCache;
import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 对象操作类
 *
 * @author marke.huang
 * @date 2018/11/18 19:54
 */
@Slf4j
public class BeanUtils extends org.springframework.beans.BeanUtils {

    /**
     * 深度克隆
     *
     * @param obj
     * @return java.lang.Object
     * @author marke.huang
     * @date 2018/11/18 19:55
     */
    public static Object clone(Object obj) {
        if (obj == null) {
            return null;
        }
        ByteArrayOutputStream bo;
        ObjectOutputStream oo = null;
        ByteArrayInputStream bi;
        ObjectInputStream oi = null;
        Object value = null;
        try {
            bo = new ByteArrayOutputStream();
            oo = new ObjectOutputStream(bo);
            oo.writeObject(obj);
            bi = new ByteArrayInputStream(bo.toByteArray());
            oi = new ObjectInputStream(bi);
            value = oi.readObject();
        } catch (Exception e) {
            log.error(TimeoutMapCache.class.getName(), e);
        } finally {
            if (oo != null) {
                try {
                    oo.close();
                } catch (Exception e) {
                    log.error(TimeoutMapCache.class.getName(), e);
                }
            }

            if (oi != null) {
                try {
                    oi.close();
                } catch (Exception e) {
                    log.error(TimeoutMapCache.class.getName(), e);
                }
            }

        }
        return value;
    }
}
