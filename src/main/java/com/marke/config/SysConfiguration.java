package com.marke.config;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.marke.constant.CacheConstants;
import com.marke.constant.SysConfigConstants;
import com.marke.entity.model.FipaSysM;
import com.marke.plugin.cache.TimeoutMapCache;
import com.marke.service.fipa.FipaSysMService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

/**
 * 系统配置
 *
 * @author marke.huang
 * @date 2018/9/27 0027 下午 3:23
 */
@Slf4j
@Service
@DependsOn(value = {"springContextUtil"})
public final class SysConfiguration {

    /**
     * 刷新缓存时间1天
     */
    private static final long EXPIRE_TIME = 1440 * 60 * 1000;

    @Resource(type = TimeoutMapCache.class)
    private TimeoutMapCache timeoutMapCache;

    @Resource(type = FipaSysMService.class)
    private FipaSysMService fipaSysMService;

    /**
     * 初始化配置信息
     *
     * @param
     * @return void
     * @author marke.huang
     * @date 2018/9/27 0027 下午 3:44
     */
    private synchronized void init() {
        // 初始化运行环境配置
        List<FipaSysM> fipaSysMVoList = fipaSysMService.listSystemConfig();
        if (CollectionUtils.isNotEmpty(fipaSysMVoList)) {
            for (FipaSysM fipaSysM : fipaSysMVoList) {
                timeoutMapCache.set((CacheConstants.Config.CACHE_KEY_PREFIX + fipaSysM.getParamName()), fipaSysM.getParamValue(), EXPIRE_TIME);
            }
        }

        log.info(String.format("初始化系统配置信息。[%s]", timeoutMapCache.getCacheNames()));
    }

    /**
     * 缓存值
     *
     * @param key
     * @return java.lang.String
     * @author marke.huang
     * @date 2018/9/27 0027 下午 3:44
     */
    private String get(String key) {
        Object object = timeoutMapCache.get(CacheConstants.Config.CACHE_KEY_PREFIX + key);

        if (null == object) {
            // 初始化配置信息
            init();
            // 重新配置信息
            object = timeoutMapCache.get(CacheConstants.Config.CACHE_KEY_PREFIX + key);
        }

        return object.toString();
    }

    /**
     * 刷新缓存
     *
     * @param
     * @return void
     * @author marke.huang
     * @date 2018/9/27 0027 下午 3:44
     */
    @PostConstruct
    public void refresh() {
        // 初始化配置
        init();
    }

    /**
     * 是否接入了微信公众号
     */
    public String getPWxJoin() {
        return get(SysConfigConstants.P_WX_JOIN);
    }

    /**
     * 是否启用微信公众号
     */
    public String getPWxOpen() {
        return get(SysConfigConstants.P_WX_OPEN);
    }

    /**
     * 开发者配置令牌(Token)
     */
    public String getPWxToken() {
        return get(SysConfigConstants.P_WX_TOKEN);
    }

    /**
     * 开发者ID(AppID)
     */
    public String getPWxAppId() {
        return get(SysConfigConstants.P_WX_APP_ID);
    }

    /**
     * 开发者密码(AppSecret)
     */
    public String getPWxAppSecret() {
        return get(SysConfigConstants.P_WX_APP_SECRET);
    }
}
