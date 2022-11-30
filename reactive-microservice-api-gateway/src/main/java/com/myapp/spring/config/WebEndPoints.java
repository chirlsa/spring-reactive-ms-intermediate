package com.myapp.spring.config;

import java.security.Principal;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.client.web.server.ServerOAuth2AuthorizedClientRepository;
import org.springframework.security.oauth2.client.web.server.WebSessionServerOAuth2AuthorizedClientRepository;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@Configuration
@EnableWebFluxSecurity
public class WebEndPoints {
	
	@Bean
	public RouterFunction<ServerResponse> routerFunction(){
		return RouterFunctions.route().GET("/catalog-fallback",request ->
		ServerResponse.ok().body(Mono.just(""),String.class))
		.POST("/catalog-fallback",request ->
		ServerResponse.status(HttpStatus.SERVICE_UNAVAILABLE).build())
		
		.build();		
	}
	
	@Bean
	ServerOAuth2AuthorizedClientRepository authorizedClientRepository() {
		return new WebSessionServerOAuth2AuthorizedClientRepository();
	}
	
	@Bean
	public KeyResolver keyResolver() {
		return exchange ->exchange.getPrincipal()
				.map(Principal::getName)
				.defaultIfEmpty("anonymous");
	}
	
	@Bean
	SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
		
		return http.authorizeExchange(exchange -> exchange.anyExchange().authenticated())
				.oauth2Login(Customizer.withDefaults()).build();
		
	}

}

// Client Side rate Limiters

// Server Side rate limiters


