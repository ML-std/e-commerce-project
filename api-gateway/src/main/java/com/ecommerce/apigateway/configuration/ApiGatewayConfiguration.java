package com.ecommerce.apigateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gateWayRouter(RouteLocatorBuilder builder){
        return builder.routes()
                .route(p -> p.path("/product-service/**").uri("lb://product-service"))
                .route(p -> p.path("/search-service/**").uri("lb://search-service"))
                .route(p -> p.path("/cart-service/**").uri("lb://cart-service"))
                .build();
    }
}
