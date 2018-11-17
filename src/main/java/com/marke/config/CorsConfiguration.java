package com.marke.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 跨域配置
 *
 * @author marke.huang
 * @date 2018/9/27 0027 下午 3:45
 */
@Configuration
public class CorsConfiguration {

    @Bean
    public WebMvcConfigurer CorsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**")
                    .allowedOrigins("*")
                    .allowedMethods("*")
                    .allowedHeaders("*")
                    //设置是否允许跨域传cookie
                    .allowCredentials(true)
                    //设置缓存时间，减少重复响应
                    .maxAge(3600);
            }
        };
    }

}
