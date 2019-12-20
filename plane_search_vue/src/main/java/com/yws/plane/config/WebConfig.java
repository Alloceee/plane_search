package com.yws.plane.config;

import com.yws.plane.interceptor.AuthorityInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author AlmostLover
 */
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authorityInterceptor())
                .addPathPatterns("/*")
                .excludePathPatterns("/admin/index")
                .excludePathPatterns("/")
                .excludePathPatterns("/china_plane")
                .excludePathPatterns("/abroad_plane")
                .excludePathPatterns("/search")
                .excludePathPatterns("*.js")
                .excludePathPatterns("*.css");
    }

    @Bean
    public AuthorityInterceptor authorityInterceptor() {
        return new AuthorityInterceptor();
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }
}