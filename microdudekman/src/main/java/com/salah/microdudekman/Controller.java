package com.salah.microdudekman;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Locale;

@RestController
@RefreshScope
public class Controller {

    private final ValProps valProps;

    @Autowired
    private MessageSource messageSource;

    public Controller(ValProps valProps) {
        this.valProps = valProps;
    }

    @GetMapping("/consume-me")
    public Ent bla() {
        return new Ent(valProps.getVal());
    }

    @GetMapping("/18")
    public String helloWorld(
//            @RequestHeader(name = "Accept-Language", required = false) Locale locale,
//            @RequestHeader(name = "Content-Type", required = false) String cont
    ) {
        return "<h1>" + messageSource.getMessage("i18n.hello", null, LocaleContextHolder.getLocale()) + "<h1/>";
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
