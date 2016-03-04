package com.example.ordermyfood1;

public class Food {
	
	private String Food_title;
	private String Food_desc;
	private int Food_price;
	private int Icon_id;
	private int qnty;
	
	public Food(String food_title, String food_desc, int food_price, int icon_id) {
		super();
		Food_title = food_title;
		Food_desc = food_desc;
		Food_price = food_price;
		Icon_id = icon_id;
	}
	
	
	
	
	public Food(String food_title, int food_price, int qnty) {
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
	public String getFood_desc() {
		return Food_desc;
	}
	public void setFood_desc(String food_desc) {
		Food_desc = food_desc;
	}
	public int getFood_price() {
		return Food_price;
	}
	
	public void setFood_price(int food_price) {
		Food_price = food_price;
	}
	public int getIcon_id() {
		return Icon_id;
	}
	public void setIcon_id(int icon_id) {
		Icon_id = icon_id;
	}
	

}
