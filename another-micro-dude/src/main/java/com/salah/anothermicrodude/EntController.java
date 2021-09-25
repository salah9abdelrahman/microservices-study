//package com.salah.anothermicrodude;
//
//import com.google.common.annotations.Beta;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.context.annotation.Bean;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//@RestController
//public class EntController {
//
//    private final RestTemplate restTemplate;
//
//    public EntController(@LoadBalanced RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }
//
//    @GetMapping("/bla")
//    public Ent bla() {
//
//        return restTemplate.getForObject("http://service-micro-dude-kman/consume-me", Ent.class);
////        return new Ent("a&A");
//
//    }
//
//}
