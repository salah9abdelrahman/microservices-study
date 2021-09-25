package com.salah.anothermicrodude;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("service-micro-dude-kman")
public interface EntFeignClient {
    @GetMapping("/consume-me")
    public Ent bla();
}
