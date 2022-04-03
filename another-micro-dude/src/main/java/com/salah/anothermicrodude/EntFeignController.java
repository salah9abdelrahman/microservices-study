package com.salah.anothermicrodude;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping("/service1")
public class EntFeignController {
    private final EntFeignClient client;

    public EntFeignController(EntFeignClient client) {
        this.client = client;
    }

    @GetMapping("/feign-bla")
    public Ent bla() {
        return client.bla();
    }

    @GetMapping("/18f")
    public String helloWorld() {
        return client.helloWorld();
    }

}
