package com.example.ordermyfood1;

import java.util.ArrayList;

public class finalOrder {

	
	private ArrayList<Order> items;
	private Address address;
	public finalOrder(ArrayList<Order> items, Address address,
			String deliverydate, String ordereddate, String deliveryTime,
			String orderTime) {
		super();
		this.items = items;
		this.address = address;
		Deliverydate = deliverydate;
		Ordereddate = ordereddate;
		DeliveryTime = deliveryTime;
		OrderTime = orderTime;
	}
	public ArrayList<Order> getItems() {
		return items;
	}
	public void setItems(ArrayList<Order> items) {
		this.items = items;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getDeliverydate() {
		return Deliverydate;
	}
	public void setDeliverydate(String deliverydate) {
		Deliverydate = deliverydate;
	}
	public String getOrdereddate() {
		return Ordereddate;
	}
	public void setOrdereddate(String ordereddate) {
		Ordereddate = ordereddate;
	}
	public String getDeliveryTime() {
		return DeliveryTime;
	}
	public void setDeliveryTime(String deliveryTime) {
		DeliveryTime = deliveryTime;
	}
	public String getOrderTime() {
		return OrderTime;
	}
	public void setOrderTime(String orderTime) {
		OrderTime = orderTime;
	}
	private String Deliverydate;
	private String Ordereddate;
	private String DeliveryTime;
	private String OrderTime;

	
	
	
	
	
	
	
	
}