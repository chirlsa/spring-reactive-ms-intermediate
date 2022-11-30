package com.myapp.spring.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.spring.ProductService;
import com.myapp.spring.domain.Product;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/products")
public class ProductAPi {
	
	private ProductService service;

	public ProductAPi(ProductService service) {
		this.service = service;
	}
	
	@GetMapping
	public Flux<Product> loadAll(){
		return service.viewProductList();
	}
	
	@PostMapping
	public Mono<Product> saveProduct(@RequestBody Product product){
		return service.addProductToCatalog(product);
		
	}
	
	@GetMapping("/{id}/{name}")
	public Mono<Product> findByIdAndName(@PathVariable("id") String id, @PathVariable("name") String productName){
		return service.viewProductDetailsByIdAndName(id, productName);
		
		
		
	}
	

}
