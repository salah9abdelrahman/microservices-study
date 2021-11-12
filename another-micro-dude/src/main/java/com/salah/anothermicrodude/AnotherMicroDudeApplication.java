package com.salah.anothermicrodude;

import com.example.common.UserContextInterceptor;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@SpringBootApplication
@EnableFeignClients
@EnableEncryptableProperties
public class AnotherMicroDudeApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnotherMicroDudeApplication.class, args);
    }

    @SuppressWarnings("unchecked")

    @LoadBalanced
    @Bean
    public RestTemplate getRestTemplate() {
        RestTemplate template = new RestTemplate();
        List interceptors = template.getInterceptors();
        interceptors.add(new UserContextInterceptor());
        template.setInterceptors(interceptors);
        return template;
    }

}
