package com.example.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/*
will intercept all incoming HTTP requests coming into the service and map the correlation ID (and a few other values)
 from the HTTP request to the User-Context class
 */

@Component
@Slf4j
public class UserContextFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse
            servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)
                servletRequest;
        //Retrieves the correlation ID from the header and sets the value in the UserContext class
        UserContextHolder.getContext()
                .setCorrelationId(
                        httpServletRequest.getHeader(UserContext.CORRELATION_ID));
        UserContextHolder.getContext().setUserId(
                httpServletRequest.getHeader(UserContext.USER_ID));
        UserContextHolder.getContext().setAuthToken(
                httpServletRequest.getHeader(UserContext.AUTH_TOKEN));
        UserContextHolder.getContext().setOrganizationId(
                httpServletRequest.getHeader(UserContext.ORGANIZATION_ID));
        log.debug("UserContextFilter Correlation id: {}",
                UserContextHolder.getContext().getCorrelationId());
        filterChain.doFilter(httpServletRequest, servletResponse);
    }
}