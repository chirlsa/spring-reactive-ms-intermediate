package com.myapp.spring.service;

import org.springframework.stereotype.Service;

import com.myapp.spring.client.Product;
import com.myapp.spring.client.ProductClient;
import com.myapp.spring.domain.Order;
import com.myapp.spring.repository.OrderRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OrderService {
	
	private final ProductClient productClient;
	
	private final OrderRepository orderRepository;

	public OrderService(ProductClient productClient, OrderRepository orderRepository) {
		this.productClient = productClient;
		this.orderRepository = orderRepository;
	}
	
	public Flux<Order> getAllOrders(){
		return orderRepository.findAll();
	}
	
	public Mono<Order> submitOrder(String productId,String productName,int quantity){
		return productClient.getProductByIdAndName(productId, productName)
				
				.map(product -> buildAcceptedOrder(product, quantity))
				.switchIfEmpty(Mono.error(()-> new RuntimeException("Product Name "+productName+" Not Found")))
				.flatMap(orderRepository::save);
			
		
	}
	
	public static Order buildAcceptedOrder(Product product,int quantity) {
		return Order.of(product.key().id(), product.key().name(), product.key().price(), quantity);
	}
	
	public static Order buildRejectedOrder(String productId,String productName,int quantity) {
		return Order.of("EmptyOrder", "Empty productName", null, 0);
	}
	
	
	
	
	

}
