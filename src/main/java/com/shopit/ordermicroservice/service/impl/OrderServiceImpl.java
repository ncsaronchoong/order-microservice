package com.shopit.ordermicroservice.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shopit.ordermicroservice.entity.Order;
import com.shopit.ordermicroservice.exception.ResourceNotFoundException;
import com.shopit.ordermicroservice.repository.OrderRepository;
import com.shopit.ordermicroservice.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	
	private OrderRepository orderRepository;
	
	public OrderServiceImpl(OrderRepository orderRepository) {
		super();
		this.orderRepository = orderRepository;
	}

	@Override
	public Order saveOrder(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public List<Order> getAllOrder() {
		return orderRepository.findAll(); 
	}

	@Override
	public Order getOrderByID(int id) {
		Order order = orderRepository.findByOrderId(id);
		if (order != null) {
			return order;
		} else {
			throw new ResourceNotFoundException("Order Not Found");
		}

	}

	@Override
	public Order updateOrder(Order order, int id) {

		Order existingOrder = orderRepository.findByOrderId(id);
		if (existingOrder != null) {
			existingOrder.setOrderId(order.getOrderId());
			existingOrder.setCustomerId(order.getCustomerId());
			existingOrder.setShippId(order.getShippId());
			existingOrder.setOrderNumber(order.getOrderNumber());
			existingOrder.setOrderDate(order.getOrderDate());
			existingOrder.setOrderShippedDate(order.getOrderShippedDate());
			existingOrder.setTrackingId(order.getTrackingId());
			orderRepository.save(existingOrder);
			return existingOrder;
		} else {
			throw new ResourceNotFoundException("Order Not Found");
		}
	}

	@Override
	public void deleteOrderById(int id) {
		
		Order existingOrder = orderRepository.findByOrderId(id);
		if (existingOrder != null) {
			orderRepository.deleteById(id);
		} else {
			throw new ResourceNotFoundException("Order Not Found");
		}
		
	}
	
	
	

	
}
