package com.example.ordermyfood1;

import java.io.Serializable;



@SuppressWarnings("serial")
public class Order implements Serializable {
	
	private String Food_title;
	private int Food_price;
	private int qnty;
	
	
	
	
	public Order(String food_title, int food_price, int qnty) {
		super();
		Food_title = food_title;
		Food_price = food_price;
		this.qnty = qnty;
	}

	public int getQnty() {
		return qnty;
	}

	public void setQnty(int qnty) {
		this.qnty = qnty;
	}

public String getFood_title() {
		return Food_title;
	}
	public void setFood_title(String food_title) {
		Food_title = food_title;
	}
	
	public int getFood_price() {
		return Food_price;
	}
	
	public void setFood_price(int food_price) {
		Food_price = food_price;
	}
	
	


    
}