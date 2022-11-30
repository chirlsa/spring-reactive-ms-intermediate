package com.myapp.spring.repository;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;

import com.myapp.spring.domain.Product;
import com.myapp.spring.domain.ProductKey;

import reactor.core.publisher.Mono;

public interface ProductRepository extends ReactiveCassandraRepository<Product, ProductKey> {
	
	@Query("select * from reactive.ecomproducts where product_id=?0 and product_name=?1")
	Mono<Product> findByIdAndName(String id,String name);

}
