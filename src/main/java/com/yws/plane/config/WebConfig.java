package com.yws.plane.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author AlmostLover
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authorityInterceptor())
                .addPathPatterns("/*")
                .excludePathPatterns("/admin/index")
                .excludePathPatterns("/")
                .excludePathPatterns("/china_plane")
                .excludePathPatterns("/abroad_plane")
                .excludePathPatterns("/search");
    }

    @Bean
    public AuthorityInterceptor authorityInterceptor() {
        return new AuthorityInterceptor();
    }
}