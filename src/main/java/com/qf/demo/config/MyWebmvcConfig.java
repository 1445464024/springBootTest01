package com.qf.demo.config;

import com.qf.demo.interceptor.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author YinZhi
 */
@Configuration
public class MyWebmvcConfig implements WebMvcConfigurer {

    @Autowired
    private MyInterceptor interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //添加拦截器配置
        registry.addInterceptor(interceptor).addPathPatterns("/**");
    }
}
