package com.salah.anothermicrodude;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;

public class FeignConfig {

    @Bean
    public RequestInterceptor requestInterceptor() {
       return new AcceptLanguageInterceptor();
    }
}
