package com.salah.microdudekman;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {
    @GetMapping("/consume-me")
    public Ent bla() {
        return new Ent("a&A");
    }

    static class Ent {
        public Ent() {
        }

        public Ent(String aha) {
            this.hola = aha;
        }

        String hola;

        public String getHola() {
            return hola;
        }

        public void setHola(String hola) {
            this.hola = hola;
        }
    }
}
