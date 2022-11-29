package com.myapp.spring.repository;

import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;

import com.myapp.spring.domain.Order;

public interface OrderRepository extends ReactiveCassandraRepository<Order, Long> {
	

}
