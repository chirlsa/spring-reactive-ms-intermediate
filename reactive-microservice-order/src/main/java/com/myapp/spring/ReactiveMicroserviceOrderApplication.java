package com.myapp.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableEurekaClient
public class ReactiveMicroserviceOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveMicroserviceOrderApplication.class, args);
	}
	
	
	
	
	@Bean
	@LoadBalanced
	WebClient.Builder loadBalancedWebClientBuilder(){
		
		return WebClient.builder().baseUrl("lb://CATALOG-SERVICE");
		
	}
	

}
