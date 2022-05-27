package com.example.apigateway.config;


import java.util.function.Function;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;

@Configuration
public class ApiGatewayConfiguration {


  @Bean
  public RouteLocator gatewayRouter(RouteLocatorBuilder builder){
    return builder.routes()
        .route(p -> p.path("/api/v1/**")
            .uri("lb://relevebancaire"))
        .route( p -> p.path("/api/v3/**")
            .uri("lb://activiti-workflow"))
        .route( p -> p.path("/api/v2/**")
            .uri("lb://mongodb-microservice"))
        .build();
  }

}
