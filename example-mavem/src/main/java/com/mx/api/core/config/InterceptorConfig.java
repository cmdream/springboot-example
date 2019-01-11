package com.mx.api.core.config;

import com.mx.api.core.interceptor.TokenInterceptor;
import com.mx.api.core.interceptor.VueInterceptor;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * new VueInterceptor()实例化自定义拦截器对象，没有把拦截器对象交给spring容器，因此不能用注解@Value的方式读取properties文件
 * 通过@Bean的方式，实例化自定义拦截器，通过有参构造方法对属性赋值
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {

    /**
     * 对拦截器定义一个bean
     */
    @Bean
    public TokenInterceptor tokenInterceptor() {
        return new TokenInterceptor();
    }
    /**
     * 对拦截器进行注册，添加拦截器时，直接使用这个bean
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new VueInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(tokenInterceptor()).addPathPatterns("/**");

    }

}
