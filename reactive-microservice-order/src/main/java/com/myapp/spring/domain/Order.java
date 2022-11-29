package com.myapp.spring.domain;

import java.time.Instant;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import com.datastax.oss.driver.api.core.uuid.Uuids;

@Table("ecomorders")
public record Order(
		
		@PrimaryKey
		UUID id,
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
		return new Order(Uuids.timeBased(),productId,productName,productPrice,quantity,null,null);
	}

}
