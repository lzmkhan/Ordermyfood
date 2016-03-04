package com.example.ordermyfood1;

import java.util.ArrayList;
import java.util.List;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public  class customlistadapter extends BaseAdapter{
	
	
	//declare each type with an integer so that we can use this to check which type of row to inflate
	private static final int TYPE_NORMAL = 0;
	private static final int TYPE_ADDITEMICON = 1;
	private final  Context context;
public int posi;
public  Food cf;
private final OrderSummaryActivity osa1;

	private List<Food> OrderSummarylist = new ArrayList<Food>();
	
	
	public customlistadapter(Context c,OrderSummaryActivity osa, List<Food> f) {
		
		//use this constructer to get the context(ie the layout which consists of listview)  and the arraylist to populate list
	    this.OrderSummarylist=f;
	    this.context=c;
	    this.osa1 =osa;
	  }

	
	
	
	
	
	
	@Override
	public int getViewTypeCount() {
	//	notifyDataSetChanged();
	    return 2;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		//this returns the number of items in the arraylist
	
		return OrderSummarylist.size();
	
	}


	
	


	
	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		//notifyDataSetChanged();
		return position;
	}
	
	
	
	
	@Override
	public int getItemViewType(int position) {
		//this method is used to get the type of row layout need to inflate
		//in here i have used "additem" as title to identify that the needed layout is the one with additem symbol
		//if title is not additem the row layout for item is returned.
		//types are returned which will be used to check on getview method
		
		
		String s = OrderSummarylist.get(position).getFood_title();
		if(s.equals("additem")==true)
		{
			return TYPE_ADDITEMICON;
		}
		else{
			return TYPE_NORMAL;
		}
	    
	
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		posi=position;
		
	Food currentFood = OrderSummarylist.get(position);
//	cf=currentFood;
	 final ViewHolder mHolder;
	View row = convertView;
		
	 LayoutInflater inflater = (LayoutInflater) context
		        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		//here the getItemviewtype() function is used to get the type
				int type = getItemViewType(position);
				
		
		if (convertView == null) {
	      
	        mHolder = new ViewHolder();

	  	      
	       
	        if (type == TYPE_ADDITEMICON) {
	        
		    	//inflates the rowlayout of additem symbol
			    Log.d("checkpoint xsx","additemicon");
		    row=	inflater.inflate(R.layout.list_row2, parent, false);
		    //the views are populated here
		    row.setOnClickListener(new OnClickListener() {

			    @Override
			    public void onClick(View v) {
			    
			    
			    	
			    	showmenuactivity();
			    	
			    	// menuscreen activity should be shown, and the ordersummarylist should be updated.
		    		Log.d("ARCGHHHHHHHH","add item requested");	
			    }});
	  			
		   	  
		      }
		    else  if (type == TYPE_NORMAL) {
		    	
		    	//inflates the rowlayout of normal items
		    row=	inflater.inflate(R.layout.list_row1, parent, false);
		    
		    mHolder. titleText = (TextView)row.findViewById(R.id.itmcartTitle);
  			mHolder. descText = (TextView) row.findViewById(R.id.itmcartqnty);
  			mHolder. priceText = (TextView) row.findViewById(R.id.itmcartprice);
  			mHolder. costText = (TextView) row.findViewById(R.id.itemtlcost);
  			mHolder.image=(ImageButton) row.findViewById(R.id.delitmcartbtn);

		    mHolder.image.setOnClickListener(new OnClickListener() {

		    @Override
		    public void onClick(View v) {
		    	//delete row code here
		    int posit =0;
		    	for(int i=0;i<OrderSummarylist.size();i++)
		    	{
		    		if(mHolder.titleText.getText().toString() == OrderSummarylist.get(i).getFood_title())
		    			posit=i;
		    	}
		    	
		    	OrderSummarylist.remove(posit);
		    	osa1.populate_checkout(gettotal(OrderSummarylist));

		   notifyDataSetChanged();
		    Toast.makeText(context, ""+mHolder.titleText.getText().toString(), Toast.LENGTH_LONG).show();
		    
		    	
		    	Log.d("imagebutton","position to be deleted" + posi);
		    }});
	 		
  			row.setOnClickListener(new OnClickListener() {

		    @Override
		    public void onClick(View v) {
		    
		    	  int posit =0;
			    	for(int i=0;i<OrderSummarylist.size();i++)
			    	{
			    		if(mHolder.titleText.getText().toString() == OrderSummarylist.get(i).getFood_title())
			    			posit=i;
			    	}
			    	
			    	showCustomDialog(OrderSummarylist.get(posit));
		    	
		    		// change the number of quantity dialog should come here.
		    		Log.d("ARCGHHHHHHHH","change num of quant");
		    	
		    	
  					
		    }});
  			
  			
		  
	
  			
  			row.setTag(mHolder);
  	
  	        
	   
		    }  
		    
	        
	    } else
	    	mHolder = (ViewHolder) convertView.getTag();
	        Log.d("tag","");
	    
	       
	       
	        
	        
		 //the views are populated here.
		 
	    Log.d("checkpoint xsx",currentFood.getFood_title());
	    if(getItemViewType(position)==0){
	 			// title
	 			mHolder.titleText.setText("");
	 			mHolder.titleText.setText(currentFood.getFood_title());

	 			// qnty
	 			mHolder.descText.setText("");
	 			mHolder.descText.setText("Qnty :" + currentFood.getQnty());
	 			
	 			
	 			// price
	 			mHolder.priceText.setText("");
	 			mHolder.priceText.setText("Price: INR "+ currentFood.getFood_price());
	 			
	  
	 		// total cost
	 			mHolder.costText.setText("");
	 		mHolder.	costText.setText(""+ (Integer.valueOf(currentFood.getFood_price())* Integer.valueOf(currentFood.getQnty())));
	 			
	 		
	
		
	 		
		
	    }
		
		
				
		    
		return row;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		Log.d("position",""+position);
		
		return OrderSummarylist.get(position);
	}

	
	private class ViewHolder {
		private  TextView titleText;
		private	TextView descText ;
		private	TextView priceText;
		private	TextView costText ;
		private ImageButton image;
	}
	
	
	
	
	protected void showCustomDialog(Food cFood) {
        // TODO Auto-generated method stub
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.item_dialog2);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        
      final   EditText editText = (EditText)dialog.findViewById(R.id.qntytext2);
 
      
      
       Food ccFood =cFood;
        cf=ccFood;
        //set qnty
       //edit1.setText(ccFood.getQnty());
        Log.d("quantity in dialog",""+ccFood.getQnty());
        //food name
        TextView txttitle =(TextView)dialog.findViewById(R.id.dialogtitle1);
        txttitle.setText(ccFood.getFood_title());
    
        //food Price
        TextView txtprice =(TextView)dialog.findViewById(R.id.dialogprice1);
        txtprice.setText("Price : INR "+ ccFood.getFood_price());
      
        
        //handles add to cart button.
        Button button = (Button)dialog.findViewById(R.id.dialogbtn1);    
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
            		
             	Food sFood = new Food(cf.getFood_title(),cf.getFood_price(),quantity);
             	
             	int posit =0;
             	for(int i=0;i<OrderSummarylist.size();i++)
		    	{
		    		if(sFood.getFood_title() == OrderSummarylist.get(i).getFood_title())
		    			posit=i;
		    	}
             	OrderSummarylist.set(posit, sFood);
             	osa1.populate_checkout(gettotal(OrderSummarylist));

           	 notifyDataSetChanged();
             	}
           }
           	//closes dialog
                dialog.dismiss();
            }
        });
                
        dialog.show();
    }
	
	
	
	
	private void showmenuactivity()
	{
		Intent myIntent = new Intent(context, MenuScreenActivity.class);
		myIntent.putExtra("orders", populate_order());
    	context.startActivity(myIntent);
        osa1.finish();
	}
	
	public  ArrayList<Order> populate_order()
	{
		//transfer all the items from cartoperation to Orderlist which is sent to ordersummaryactivity
		ArrayList<Order> pointsExtra = new ArrayList<Order>();
		
		for(int i=0;i<OrderSummarylist.size()-1;i++)
		{
		pointsExtra.add(new Order(OrderSummarylist.get(i).getFood_title(),OrderSummarylist.get(i).getFood_price(),OrderSummarylist.get(i).getQnty()));
		}
		
		return pointsExtra;
	}
	
	
	public int gettotal(List<Food> OrderSummarylis)
	{
		int total=0;
		for(int i = 0; i< OrderSummarylis.size();i++)
		{
			total = total + (OrderSummarylis.get(i).getFood_price() * OrderSummarylis.get(i).getQnty());
		}
		
		return total;
	}

	
	
	}



