package com.myapp.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication

@EnableEurekaClient
public class ReactiveMicroserviceCatalogApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveMicroserviceCatalogApplication.class, args);
	}
	
	// Cart findByUserId(String userId)
	
	
	// Reactive Style
	
	// Mono<Cart> findByUserId(String userId)
	
	
	// List<Product> getAllItemsInCart()
	
	 // Reactive Style
	
	// Flux<Product> getAllItemsInCart()
	

}
