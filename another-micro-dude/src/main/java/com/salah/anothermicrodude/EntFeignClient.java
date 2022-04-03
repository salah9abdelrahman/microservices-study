package com.salah.anothermicrodude;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Locale;

@FeignClient(value = "service-micro-dude-kman", configuration = {FeignConfig.class})
public interface EntFeignClient {
    @GetMapping("/consume-me")
    public Ent bla();

    @GetMapping("/18")
    public String helloWorld();
//    public String helloWorld( @RequestHeader(name = "Accept-Language", required = false) final Locale locale);
}
