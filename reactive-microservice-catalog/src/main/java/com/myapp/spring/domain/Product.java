package com.myapp.spring.domain;

import java.util.Set;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("ecomproducts")
public record Product(
		
		@PrimaryKey ProductKey key,
		String description,
		Set<String> images) {
	public static Product build(String id,String name,Double price,String description,Set<String> images) {
		return new Product(new ProductKey(id,name,price), description, images);
	}

}
