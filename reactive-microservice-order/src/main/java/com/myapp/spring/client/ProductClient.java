package com.myapp.spring.client;

import java.time.Duration;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

@Component
public class ProductClient {
	
	private final WebClient.Builder webClient;

	private static final String PRODUCTS_ROOT_API ="/api/v1/products";
	
	public ProductClient(WebClient.Builder webClient) {
		this.webClient = webClient;
	}
	
	public Mono<Product> getProductByIdAndName(String productId,String productName){
//		return webClient.get().uri(PRODUCTS_ROOT_API+productId+productName)
//				.retrieve().bodyToMono(Product.class)
//				.retryWhen(Retry.backoff(3, Duration.ofMillis(100)))
//				.timeout(Duration.ofSeconds(3), Mono.empty())
//				;
		
		return webClient.build().get().uri(PRODUCTS_ROOT_API+"/"+productId+"/"+productName)
				.retrieve().bodyToMono(Product.class)
				
				.timeout(Duration.ofSeconds(3), Mono.empty())
				.onErrorResume(WebClientResponseException.NotFound.class, exception -> Mono.empty())
				.retryWhen(Retry.backoff(3, Duration.ofMillis(100)))
				.onErrorResume(Exception.class, exception -> Mono.empty())
				
				
				;
				
				
	}
	
	
	

}
