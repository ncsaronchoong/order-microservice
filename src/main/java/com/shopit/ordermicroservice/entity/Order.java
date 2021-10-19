package com.shopit.ordermicroservice.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "orders")
public class Order {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    @Column(name = "order_id")
	private int orderId;
	
	@Column(name = "customer_id")
	private int customerId;
	
	@Column(name = "shipp_id")
	private int shippId;
	
	@Column(name = "order_number")
	private int orderNumber;
	
	@Column(name = "order_date")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date orderDate;
	
	@Column(name = "order_shipped_date")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date orderShippedDate;
	
	@Column(name = "tracking_id")
	private int trackingId;
	
	
	public Order(){
		
	}

	public Order(int orderId, int customerId, int shippId, int orderNumber, Date orderDate, Date orderShippedDate,
			int trackingId) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.shippId = shippId;
		this.orderNumber = orderNumber;
		this.orderDate = orderDate;
		this.orderShippedDate = orderShippedDate;
		this.trackingId = trackingId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getShippId() {
		return shippId;
	}
	public void setShippId(int shippId) {
		this.shippId = shippId;
	}
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Date getOrderShippedDate() {
		return orderShippedDate;
	}
	public void setOrderShippedDate(Date orderShippedDate) {
		this.orderShippedDate = orderShippedDate;
	}
	public int getTrackingId() {
		return trackingId;
	}
	public void setTrackingId(int trackingId) {
		this.trackingId = trackingId;
	}
	
	

}
