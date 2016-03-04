package com.example.ordermyfood1;

import java.util.ArrayList;
import java.util.List;







import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MenuScreenActivity  extends MainActivity{

	private List<Food> myFood = new ArrayList<Food>();
	ArrayList<Order> order = new ArrayList<Order>();
	public CartOperation Orders = new CartOperation();
	public Food clickedFood;
    Button buttonDialog;
	@SuppressWarnings("unchecked")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu_screen);
		getSupportActionBar().show() ;
		//populate the menulist and handle its click events
		
		Intent i = this.getIntent();
		 order = (ArrayList<Order>)i.getSerializableExtra("orders");
		if(order==null)
		{}else
		{
		 Log.d("THe size of serialiabafdsd","" + order.size());
		
		populateOrderslist();
		}
		populateFoodList();
		populateListView();
		registerClickCallback();
		
		
		
		
		
	}
	
	
	void populateOrderslist()
	{
		//takes the data obtained from invoking fall and fill it on cart so cart operation can be performed on this data.
		for(int i=0;i<order.size();i++)
		{
			
			Food f = new Food(order.get(i).getFood_title(),order.get(i).getFood_price(),order.get(i).getQnty());
			Orders.addtocart(f);
		}
		
	}
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		return super.onCreateOptionsMenu(menu);
	}

	public  ArrayList<Order> populate_order()
	{
		//transfer all the items from cartoperation to Orderlist which is sent to ordersummaryactivity
		ArrayList<Order> pointsExtra = new ArrayList<Order>();
		
		for(int i=0;i<Orders.get_cart_content_transfer().size();i++)
		{
		pointsExtra.add(new Order(Orders.get_cart_content_transfer().get(i).getFood_title(),Orders.get_cart_content_transfer().get(i).getFood_price(),Orders.get_cart_content_transfer().get(i).getQnty()));
		}
		
		return pointsExtra;
	}
	
	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId())
		{
		case R.id.action_cart :
			showcartactivity();
			break;
			
		}
		
		
		
		
		return super.onOptionsItemSelected(item);
	}
	
	private void showcartactivity()
	{
		Intent myIntent = new Intent(MenuScreenActivity.this, OrderSummaryActivity.class);
		myIntent.putExtra("orders", populate_order());
    	MenuScreenActivity.this.startActivity(myIntent);
    	finish();
	}

	private void populateFoodList() {
		myFood.add(new Food("Chicken Biryani","1 plate with onion chutni",90, R.drawable.foodicon));
		myFood.add(new Food("Chicken Kadai","w/ 2 nun rottis",91 , R.drawable.foodicon));
		myFood.add(new Food("Chicken 65","w/ seasonings and onions",65 , R.drawable.foodicon));
		myFood.add(new Food("Chilli Chicken","w/ veggies",60 , R.drawable.foodicon));
		myFood.add(new Food("Chicken Fried Rice","w/ sauce",55, R.drawable.foodicon));
		myFood.add(new Food("Chicken Thikka","w/ 2 nuns",70 , R.drawable.foodicon));
		Log.d("checkpoint 1","Excuted populatefoodlist()");
	}
	
	private void populateListView() {
		ArrayAdapter<Food> adapter = new MyListAdapter();
		ListView list = (ListView) findViewById(R.id.listmenu);
		list.setAdapter(adapter);
		Log.d("Checkpoint2", "Executed populate listview()");
	}
	
	private void registerClickCallback() {
		ListView list = (ListView) findViewById(R.id.listmenu);
		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View viewClicked,
					int position, long id) {
				
				clickedFood = myFood.get(position);
			
				//String message = "You clicked position " + position
					//			+ " the food is " + clickedFood.getFood_title();
		//		Toast.makeText(MenuScreenActivity.this, message, Toast.LENGTH_LONG).show();
				//here need to set a dialog box to get the qnty of item and then update the qnty textview of listview item.
				
				//intializes dialog when a menu item is clicked.
				
		        
		            showCustomDialog(clickedFood);
		        
				}
		});
	}
	
	
	// the signature ie parameters should contain multiple params such as title, desc, price, imageicon
	protected void showCustomDialog(Food cFood) {
        // TODO Auto-generated method stub
        final Dialog dialog = new Dialog(MenuScreenActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.item_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        
        final EditText editText = (EditText)dialog.findViewById(R.id.qntytext1);
    
        //food image
        ImageView image =(ImageView)dialog.findViewById(R.id.dialogimage);
        image.setImageResource(cFood.getIcon_id());
        
        //food name
        TextView txttitle =(TextView)dialog.findViewById(R.id.dialogtitle);
        txttitle.setText(cFood.getFood_title());
    
        //food desc
        TextView txtdesc =(TextView)dialog.findViewById(R.id.dialogdesc);
        txtdesc.setText(cFood.getFood_desc());
        
        //food Price
        TextView txtprice =(TextView)dialog.findViewById(R.id.dialogprice);
        txtprice.setText("Price : INR "+ cFood.getFood_price());
      
        
        //handles add to cart button.
        Button button = (Button)dialog.findViewById(R.id.dialogbtn);    
        button.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //i need to place some code which gets the title, price, qnty and add it to some table or container
            	//so i can be later used to fill ordersummary  list and to generate order.
            	int quantity;
            	//this quantity should be sent with title, price to a container which is used in order summary
           if(editText.getText()!=null){
            	 quantity=	Integer.valueOf(editText.getText().toString());
            	if(quantity >=0){
            	//used to add to Ordersummary
             	Food sFood = new Food(clickedFood.getFood_title(),clickedFood.getFood_price(),quantity);
             	
             	 Log.d("value of quantity",""+sFood.getQnty());
             	if(Orders.chkifalrdyextsinlst(sFood)==1)//checks if the food item already exists in order list
             	{
             		int position =Orders.returnposition(sFood);//if so 
             		Log.d("Checkpoint4", "item exists in position "+ position);
             		Orders.updatecart(position, quantity);//update the quantity of the item in order list.
             		
             	}
             	else
             	{
             		Log.d("Checkpoint5", "item does not exist in order");
             	Orders.addtocart(sFood);//if not, then adds the item to the list
             	 Log.d("value of quantity",""+quantity);
             	}
            	}
           }
           
            	
            	
            	//closes dialog
                dialog.dismiss();
            }
        });
                
        dialog.show();
    }
	
	
	
	private class MyListAdapter extends ArrayAdapter<Food> {
		public MyListAdapter() {
			super(MenuScreenActivity.this, R.layout.list_row, myFood);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// Make sure we have a view to work with (may have been given null)
			View itemView = convertView;
			if (itemView == null) {
				itemView = getLayoutInflater().inflate(R.layout.list_row, parent, false);
			}
			
			// Find the food to work with.
			Food currentFood = myFood.get(position);
			
			// Fill the view
			ImageView imageView = (ImageView)itemView.findViewById(R.id.itemicon);
			imageView.setImageResource(currentFood.getIcon_id());
			
			// title
			TextView titleText = (TextView) itemView.findViewById(R.id.itemtitle);
			titleText.setText(currentFood.getFood_title());

			// description
			TextView descText = (TextView) itemView.findViewById(R.id.itemdesc);
			descText.setText("" + currentFood.getFood_desc());
			
		
			
		
			// price
			TextView priceText = (TextView) itemView.findViewById(R.id.itemprice);
			priceText.setText("INR "+ currentFood.getFood_price());
			
			


			return itemView;
		}	
	
	}

}
