package com.fidecoin.gatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}
    // @Bean
	RouteLocator staticRoutes(RouteLocatorBuilder builder) {
			return builder.routes()
	//				.route(r -> r.path("/customers/**").uri("http://localhost:8081/").id("r1"))
	//				.route(r -> r.path("/products/**").uri("http://localhost:8082/").id("r2"))

					.route(r -> r.path("/customers/**").uri("lb://CUSTOMER-SERVICE").id("r1"))
					.route(r -> r.path("/home/**").uri("lb://CUSTOMER-SERVICE").id("r3"))
					.route(r -> r.path("/products/**").uri("lb://INVENTORY-SERVICE").id("r2"))
					.build();
	}
	@Bean
	DiscoveryClientRouteDefinitionLocator dynamiqueRoutes(ReactiveDiscoveryClient rdc, DiscoveryLocatorProperties dlp) {
		return  new DiscoveryClientRouteDefinitionLocator(rdc, dlp);
	}

}
