package com.shunqi.wallet.merchants;

import com.shunqi.wallet.merchants.security.RequestHeaderInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@SpringBootApplication
public class MerchantsApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(MerchantsApplication.class, args);
    }

    @Resource
    private RequestHeaderInterceptor authCheckInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authCheckInterceptor)
                .addPathPatterns("/merchants/**");
    }

}
