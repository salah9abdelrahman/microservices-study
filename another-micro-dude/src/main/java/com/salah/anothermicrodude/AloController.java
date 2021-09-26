package com.salah.anothermicrodude;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/alo")
@Slf4j
public class AloController {
//    @Retry(name = "alo", fallbackMethod = "defaultValue")
//    @CircuitBreaker(name = "default", fallbackMethod = "defaultValue")
    @RateLimiter(name = "default")
    @GetMapping
    public Ent alo() {
        log.info("aloooo");
//        ResponseEntity<Ent> entity = new RestTemplate().getForEntity("http:localhost:3000", Ent.class);
//        return entity.getBody();
        return new Ent("test");
    }

    public Ent defaultValue(Exception ex) {
        return new Ent("alooo");
    }
}
