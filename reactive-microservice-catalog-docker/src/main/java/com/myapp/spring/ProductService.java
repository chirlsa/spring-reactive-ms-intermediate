package com.myapp.spring;

import org.springframework.stereotype.Service;

import com.myapp.spring.domain.Product;
import com.myapp.spring.domain.ProductKey;
import com.myapp.spring.repository.ProductRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {
	
	private ProductRepository repository;

	public ProductService(ProductRepository repository) {
		this.repository = repository;
	}
	
	public Flux<Product> viewProductList(){
		return repository.findAll();
	}
	
	public Mono<Product> viewProductDetails(String id,String name, Double price) {
		return repository.findById(new ProductKey(id,name,price));
		
	}
	
	public Mono<Product> viewProductDetailsByIdAndName(String id,String name) {
		return repository.findByIdAndName(id, name);
		
	}
	
	public Mono<Product> addProductToCatalog(Product product){
		return repository.save(product);
	}
	
	
	

}
