package com.yws.plane.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authorityInterceptor())
                .addPathPatterns("/*")
                .excludePathPatterns("/admin/index");
    }

    @Bean
    public AuthorityInterceptor authorityInterceptor() {
        return new AuthorityInterceptor();
    }
}