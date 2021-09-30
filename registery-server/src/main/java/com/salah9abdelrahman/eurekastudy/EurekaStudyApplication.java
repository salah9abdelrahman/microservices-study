package com.salah9abdelrahman.eurekastudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
@SpringBootApplication
@EnableEurekaServer
public class EurekaStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaStudyApplication.class, args);
    }

}
