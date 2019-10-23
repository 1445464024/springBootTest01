package com.qf.demo.config;

import com.qf.demo.filter.MyFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author YinZhi
 */
@Configuration
public class WebConfig {

    @Autowired
    private MyFilter myFilter;

    @Bean
    public FilterRegistrationBean initFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(myFilter);
        filterRegistrationBean.setName("myFilter");
        filterRegistrationBean.addUrlPatterns("/*");

        return filterRegistrationBean;
    }
}
