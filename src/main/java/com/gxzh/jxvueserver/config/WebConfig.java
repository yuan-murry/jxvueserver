package com.gxzh.jxvueserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private TokenInterceptor tokenInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenInterceptor).addPathPatterns("/api/**");
    }
}

//
//@Configuration
//public class WebConfig implements WebMvcConfigurer {
//
//    @Autowired
//    private TokenFilter tokenFilter;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(tokenInterceptor).addPathPatterns("/api/**");
//    }
//
//    @Override
//    public void addFilters(FilterRegistrationBean<Filter> registrationBean) {
//        registrationBean.setFilter(tokenFilter);
//        registrationBean.addUrlPatterns("/api/*");
//    }
//}