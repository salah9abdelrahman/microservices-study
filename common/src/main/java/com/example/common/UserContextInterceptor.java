package com.example.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class UserContextInterceptor implements ClientHttpRequestInterceptor {

    //Invokes intercept() before the actual HTTP service call occurs by the RestTemplate
    @Override
    public ClientHttpResponse intercept(
            HttpRequest request, byte[] body,
            ClientHttpRequestExecution execution) throws IOException {
        HttpHeaders headers = request.getHeaders();
        headers.add(UserContext.CORRELATION_ID,
                UserContextHolder.getContext()
//    Takes the HTTP request header  that’s being prepared for the outgoing service call and adds
//        the correlation ID stored in theUserContext
                        .getCorrelationId());
        headers.add(UserContext.AUTH_TOKEN,
                UserContextHolder.getContext().
                        getAuthToken());
        return execution.execute(request, body);
    }
}

