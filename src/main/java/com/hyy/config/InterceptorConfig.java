package com.hyy.config;

import com.hyy.interceptor.JwtInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author HuangSir
 * @date 2021-11-15 19:22
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
   @Override
   public void addInterceptors(InterceptorRegistry registry) {
      registry.addInterceptor(new JwtInterceptor())
              .addPathPatterns("/**")//拦截所有的请求
              .excludePathPatterns("/user/**");//放行和用户有关的请求
   }
}
