//package com.example.apigateway;
//
//import org.springframework.cloud.gateway.route.Route;
//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.cloud.gateway.route.builder.Buildable;
//import org.springframework.cloud.gateway.route.builder.PredicateSpec;
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.function.Function;
//
//@Configuration
//public class ApiGatewayConfig {
//    // to customize routes
//    @Bean
//    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route(r -> r.path("/get")
//                        .filters(f -> f.addRequestHeader("MyHeader", "header value")
//                        )
//                        .uri("http://httpbin.org:80")
//                )
//                .route(r -> r.path("/service1/**")
//                        .uri("lb://service-another-micro-dude"))
//                .build();
//
//    }
//}
