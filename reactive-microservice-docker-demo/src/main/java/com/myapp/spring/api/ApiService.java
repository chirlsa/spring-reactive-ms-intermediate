package com.myapp.spring.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class ApiService {
	
	@GetMapping("hello")
	Mono<String> sayHello(){
		return Mono.just("Hello");
	}

}
