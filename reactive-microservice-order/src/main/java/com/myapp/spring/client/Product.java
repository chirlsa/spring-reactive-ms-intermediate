package com.myapp.spring.client;

import java.util.Set;


public record Product(
		
		 ProductKey key,
		String description,
		Set<String> images) {
	public static Product build(String id,String name,Double price,String description,Set<String> images) {
		return new Product(new ProductKey(id,name,price), description, images);
	}

}
