package com.myapp.spring.domain;

import java.time.Instant;
import java.util.Random;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("ecomorders")
public record Order(
		
		@PrimaryKey
		Long id,
		String productId,
		String productName,
		Double price,
		Integer quantity,
		@CreatedDate
		Instant createdDate,
		@LastModifiedDate
		Instant lastModifiedDate
		
		
		) {
	public static Order of(String productId,String productName,Double productPrice,Integer quantity) {
		return new Order(Math.abs(new Random().nextLong()),productId,productName,productPrice,quantity,null,null);
	}

}
