package com.myapp.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
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
