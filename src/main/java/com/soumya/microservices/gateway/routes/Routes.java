package com.soumya.microservices.gateway.routes;

import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.cloud.gateway.server.mvc.filter.FilterFunctions.setPath;

@Configuration
public class Routes {

    @Bean
    public RouterFunction<ServerResponse> productServiceRoute(){
        return GatewayRouterFunctions.route("product-service")
                .route(RequestPredicates.path("/api/products"), HandlerFunctions.http("http://localhost:8080"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> productServiceSwaggerRoute(){
        return GatewayRouterFunctions.route("product_service_swagger")
                .route(RequestPredicates.path("/aggregator/product-service/v3/api-docs"), HandlerFunctions.http("http://localhost:8080"))
                .filter(setPath("/api-docs"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> orderServiceRoute(){
        return GatewayRouterFunctions.route("order-service")
                .route(RequestPredicates.path("/api/orders"), HandlerFunctions.http("http://localhost:8081"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> orderServiceSwaggerRoute(){
        return GatewayRouterFunctions.route("order_service_swagger")
                .route(RequestPredicates.path("/aggregator/order-service/v3/api-docs"), HandlerFunctions.http("http://localhost:8081"))
                .filter(setPath("/api-docs"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> inventoryServiceRoute(){
        return GatewayRouterFunctions.route("inventory-service")
                .route(RequestPredicates.path("/api/inventory"), HandlerFunctions.http("http://localhost:8082"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> inventoryServiceSwaggerRoute(){
        return GatewayRouterFunctions.route("inventory_service_swagger")
                .route(RequestPredicates.path("/aggregator/inventory-service/v3/api-docs"), HandlerFunctions.http("http://localhost:8082"))
                .filter(setPath("/api-docs"))
                .build();
    }
}
