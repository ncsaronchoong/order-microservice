package com.shopit.ordermicroservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopit.ordermicroservice.entity.Order;
import com.shopit.ordermicroservice.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	private OrderService orderService;

	public OrderController(OrderService orderService) {
		super();
		this.orderService = orderService;
	}
	
	@PostMapping
	public ResponseEntity<Order> createOrder(@RequestBody Order order){
		return new ResponseEntity<Order>(orderService.saveOrder(order), HttpStatus.CREATED); 
	}
	
	@GetMapping ("/all")
	public List<Order> getAllOrders(){
		return orderService.getAllOrder();
	}
	
	@GetMapping ("/get/{id}")
	public ResponseEntity<Order> getOrderById(@PathVariable (value = "id") int orderId){
		return new ResponseEntity<Order>(orderService.getOrderByID(orderId), HttpStatus.OK);
	}
	
	@PutMapping ("/set/{id}")
	// convert json to java object
	public ResponseEntity<Order> updateOrder(@PathVariable (value = "id") int orderId, @RequestBody Order order){
		return new ResponseEntity<Order>(orderService.updateOrder(order, orderId), HttpStatus.OK);
	}
	
	@DeleteMapping ("/delete/{id}")
	// convert json to java object
	public ResponseEntity<String> deleteOrder(@PathVariable (value = "id") int orderId){
		
		orderService.deleteOrderById(orderId);
		return new ResponseEntity<String>("Order Deleted", HttpStatus.OK);
	}
	
	
	
	
	
}
