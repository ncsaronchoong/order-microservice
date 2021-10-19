package com.shopit.ordermicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopit.ordermicroservice.entity.Order;

public interface OrderRepository extends JpaRepository <Order, Integer>{ 
	
	Order findByOrderId(Integer order_id);
	
}
