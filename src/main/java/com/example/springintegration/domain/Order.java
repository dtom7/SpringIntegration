package com.example.springintegration.domain;

import java.util.ArrayList;
import java.util.List;

public class Order {
	
	private int orderID;
	
	private List<OrderItem> orderItems = new ArrayList<>();

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	

}
