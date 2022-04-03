package com.salah.anothermicrodude;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.http.HttpHeaders;

public class ContentTypeInterceptor implements RequestInterceptor {
    RequestInterceptor requestInterceptor;

    public ContentTypeInterceptor(RequestInterceptor requestInterceptor) {
        this.requestInterceptor = requestInterceptor;
    }

    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestInterceptor.apply(requestTemplate);
        requestTemplate.header(HttpHeaders.CONTENT_TYPE, "Bla");
    }
}
