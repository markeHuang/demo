package com.marke.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * SpringIOC容器工具类 .<br>
 *
 * @author andy.sher
 * @date 2018/7/11 9:58
 */
@Component("springContextUtil")
public final class SpringContextUtils implements ApplicationContextAware {

    private SpringContextUtils() {
    }

    /**
     * Spring上下文对象
     */
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtils.applicationContext = applicationContext;
    }

    /**
     * 获取applicationContext
     *
     * @param
     * @return org.springframework.context.ApplicationContext
     * @author jiangming.huang
     * @date 2018/9/27 0027 下午 4:39
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 按类型获取托管对象
     *
     * @param clazz
     * @return T
     * @author jiangming.huang
     * @date 2018/9/27 0027 下午 4:39
     */
    public static <T> T getBean(Class<T> clazz) {
        return SpringContextUtils.applicationContext.getBean(clazz);
    }

    /**
     * 按bean的注册名获取托管对象
     *
     * @param beanName
     * @return java.lang.Object
     * @author jiangming.huang
     * @date 2018/9/27 0027 下午 4:39
     */
    public static Object getBean(String beanName) {
        return SpringContextUtils.applicationContext.getBean(beanName);
    }

    /**
     * 按bean的注册名和类型获取托管对象
     *
     * @param beanName
     * @param clazz
     * @return T
     * @author jiangming.huang
     * @date 2018/9/27 0027 下午 4:39
     */
    public static <T> T getBean(String beanName, Class<T> clazz) {
        return SpringContextUtils.applicationContext.getBean(beanName, clazz);
    }

    /**
     * 按类型获取Bean
     *
     * @param clazz
     * @return java.util.Map<java.lang.String,T>
     * @author jiangming.huang
     * @date 2018/9/27 0027 下午 4:39
     */
    public static <T> Map<String, T> getBeansOfType(Class<T> clazz) {
        return SpringContextUtils.applicationContext.getBeansOfType(clazz);
    }

}
