package com.example.gatewaay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewaayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewaayApplication.class, args);
    }

    /*configurer les routes a travers java */
    //@Bean
    public RouteLocator routes(RouteLocatorBuilder builder){
         return builder.routes()
                 .route(r->r.path("/customers/**").uri("lb://customer-service"))
                 .route(r->r.path("/products/**").uri("lb://inventory-service"))
                 .build();
    }

    @Bean
    public DiscoveryClientRouteDefinitionLocator dynamicRoutes(ReactiveDiscoveryClient rdc,
                                                               DiscoveryLocatorProperties dlp) {
        return new DiscoveryClientRouteDefinitionLocator(rdc,dlp);
    }

}
