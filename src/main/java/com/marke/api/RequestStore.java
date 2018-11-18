package com.marke.api;

import com.alibaba.fastjson.JSONObject;
import com.marke.api.entity.ReqEntity;
import com.marke.utils.JwtUtils;
import com.marke.utils.StringUtils;

/**
 * 请求参数仓库
 *
 * @author marke.huang
 * @date 2018/11/18 20:39
 */
public class RequestStore {

    /**
     * 分页下标
     */
    private static ThreadLocal<Integer> pageNum = new ThreadLocal<>();

    /**
     * 分页大小
     */
    private static ThreadLocal<Integer> pageSize = new ThreadLocal<>();

    /**
     * 分页字段和方式
     */
    private static ThreadLocal<JSONObject> sort = new ThreadLocal<>();

    /**
     * 令牌
     */
    private static ThreadLocal<String> token = new ThreadLocal<>();

    /**
     * IP地址
     */
    private static ThreadLocal<String> ipAddress = new ThreadLocal<>();

    /**
     * 位置
     */
    private static ThreadLocal<String> location = new ThreadLocal<>();

    /**
     * 用户ID
     */
    private static ThreadLocal<String> userid = new ThreadLocal<>();

    public static int getPageNum() {
        return RequestStore.pageNum.get();
    }

    public static void setPageNum(int pageNum) {
        RequestStore.pageNum.set(pageNum);
    }

    public static int getPageSize() {
        return RequestStore.pageSize.get();
    }

    public static void setPageSize(int pageSize) {
        RequestStore.pageSize.set(pageSize);
    }

    public static JSONObject getSort() {
        return RequestStore.sort.get();
    }

    public static void setSort(JSONObject sort) {
        RequestStore.sort.set(sort);
    }

    /**
     * 获取令牌
     *
     * @return java.lang.String
     * @author marke.huang
     * @date 2018/11/18 20:40
     */
    public static String getToken() {
        return RequestStore.token.get();
    }

    public static void setToken(String token) {
        if (StringUtils.isNotBlank(token)) {
            RequestStore.token.set(token);
            RequestStore.userid.set(JwtUtils.getUserid(token));
        }
    }


    /**
     * 获取IP地址
     *
     * @return java.lang.String
     * @author marke.huang
     * @date 2018/11/18 20:41
     */
    public static String getIpAddress() {
        return RequestStore.ipAddress.get();
    }

    public static void setIpAddress(String ipAddress) {
        RequestStore.ipAddress.set(ipAddress);
    }

    /**
     * 获取位置
     *
     * @return java.lang.String
     * @author marke.huang
     * @date 2018/11/18 20:42
     */
    public static String getLocation() {
        return location.get();
    }

    public static void setLocation(String location) {
        RequestStore.location.set(location);
    }

    /**
     * 获取用户代号
     *
     * @return java.lang.String
     * @author marke.huang
     * @date 2018/11/18 20:42
     */
    public static String getUserid() {
        return userid.get();
    }

    /**
     * 初始化请求分页参数 .<br>
     *
     * @param reqEntity 请求对象
     * @return void
     * @author andy.sher
     * @date 2018/7/25 13:20
     */
    public static void initPageParam(ReqEntity reqEntity) {
        if (null != reqEntity.getPageNum()) {
            setPageNum(reqEntity.getPageNum());
        }
        if (null != reqEntity.getPageSize()) {
            setPageSize(reqEntity.getPageSize());
        }
    }

    /**
     * 销毁参数仓库 .<br>
     *
     * @param
     * @return void
     * @author andy.sher
     * @date 2018/7/25 16:23
     */
    public static void destroy() {
        pageNum.remove();
        pageSize.remove();
        sort.remove();
        token.remove();
        ipAddress.remove();
        location.remove();
        userid.remove();
    }

}
