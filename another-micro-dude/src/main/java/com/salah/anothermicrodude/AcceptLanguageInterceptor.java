package com.salah.anothermicrodude;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;

public class AcceptLanguageInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header(HttpHeaders.ACCEPT_LANGUAGE, LocaleContextHolder.getLocale().getLanguage());
    }
}
