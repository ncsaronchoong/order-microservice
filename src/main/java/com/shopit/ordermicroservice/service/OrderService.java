package com.shopit.ordermicroservice.service;

import java.util.List;

import com.shopit.ordermicroservice.entity.Order;

public interface OrderService {
	Order saveOrder(Order order);
	List<Order> getAllOrder();
	Order getOrderByID(int id);
	Order updateOrder(Order order, int id);
	void deleteOrderById(int id);
}
