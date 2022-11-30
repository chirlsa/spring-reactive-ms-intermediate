package com.myapp.spring.domain;

import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

@PrimaryKeyClass
public record ProductKey(
	@PrimaryKeyColumn(name="product_id",type = PrimaryKeyType.PARTITIONED) String id,
	@PrimaryKeyColumn(name="product_name",type = PrimaryKeyType.PARTITIONED) String name,
	@PrimaryKeyColumn(name="product_price",ordering = Ordering.DESCENDING) Double  price) {
	
	

}
