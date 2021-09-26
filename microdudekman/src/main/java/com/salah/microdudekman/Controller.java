package com.salah.microdudekman;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RefreshScope
public class Controller {

    private final ValProps valProps;

    public Controller(ValProps valProps) {
        this.valProps = valProps;
    }

    @GetMapping("/consume-me")
    public Ent bla() {
        return new Ent(valProps.getVal());
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
