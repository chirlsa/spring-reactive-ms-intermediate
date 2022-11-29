package com.myapp.spring.api;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.spring.domain.Order;
import com.myapp.spring.service.OrderService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
	
	
	private final OrderService service;

	public OrderController(OrderService service) {
		this.service = service;
	}
	
	
	@GetMapping
	public Flux<Order> getAllOrders(){
		return service.getAllOrders();
	}
	
	
	@PostMapping
	public Mono<Order> placeAnOrder(@RequestBody @Valid OrderRequest request){
		return service.submitOrder(request.productId(), request.productName(), request.quantity());
	}
	
	

}
