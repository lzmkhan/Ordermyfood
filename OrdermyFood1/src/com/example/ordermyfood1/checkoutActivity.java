package com.example.ordermyfood1;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class checkoutActivity extends MainActivity {
	ArrayList<Order> order = new ArrayList<Order>();
	finalOrder fo;
	Address address;
	String del_date;
	String del_time;
	String ord_date;
	String ord_time;
	@SuppressWarnings("unchecked")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		  setContentView(R.layout.checkout_screen);
		  getSupportActionBar().hide() ;
		  
		  Intent i = this.getIntent();
			 order = (ArrayList<Order>)i.getSerializableExtra("orders");
			if(order==null)
			{}else
			{
			 Log.d("THe size of serialiabafdsd in checkout activity is","" + order.size());
			}
			
			ord_date =(String)i.getSerializableExtra("start_date");
			ord_time =(String)i.getSerializableExtra("start_time");
			del_date =(String)i.getSerializableExtra("delivery_date");
			del_time =(String)i.getSerializableExtra("delivery_time");
			
			address =(Address)i.getSerializableExtra("Address");
			
			 Log.d("orddate","" + ord_date);
			 Log.d("ordtimee","" + ord_time);
			 Log.d("deldate","" + del_date);
			 Log.d("deltime","" + del_time);
			 Log.d("address","" + address.getArea()+address.getName());
			
			
		
	}

	
	
	
	
	
	
	
	
	

}
