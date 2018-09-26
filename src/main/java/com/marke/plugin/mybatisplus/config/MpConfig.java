package com.marke.plugin.mybatisplus.config;

import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * MybatisPlus配置
 *
 * @author marke.huang
 * @date 2018/9/26 0026 下午 5:14
 */
@Configuration
public class MpConfig {

    /***
     * plus 的性能优化
     * @return
     */
    @Bean
    @Profile({"dev"})
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        /* <!-- SQL 执行性能分析，开发环境使用，线上不推荐。 maxTime 指的是 sql 最大执行时长 --> */
        performanceInterceptor.setMaxTime(5000);
        /* <!--SQL是否格式化 默认false--> */
        performanceInterceptor.setFormat(true);
        return performanceInterceptor;
    }

}
