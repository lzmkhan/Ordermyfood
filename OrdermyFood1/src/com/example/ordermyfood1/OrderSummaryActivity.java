package com.example.ordermyfood1;



import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;









import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

@SuppressLint("NewApi") public class OrderSummaryActivity extends MainActivity {
	customlistadapter adapter ;
	private List<Food> myFood = new ArrayList<Food>();
	CartOperation cart = new CartOperation();
	ArrayList<Order> orders = new ArrayList<Order>();
	Address address;
	String aTime;
	String aDate;
	String Start_date;
	String Start_time;
	final Context con = this;
	//***********************************************************
	//used for date picker
	private Button changeDate;
	 
    private int year;
    private int month;
    private int day;
 
    static final int DATE_PICKER_ID = 1111;
 //***********************************************************
	//used for time picker
    static final int TIME_DIALOG_ID = 2222;
    public Button btnClick;
    
    private int hour;
    private int minute;
    //********************************************************
    Calendar cal;
    
    
	@SuppressWarnings("unchecked")
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.order_summary);
	//********************************************************************************
		//gets the cart list from menuscreenactivity
		Intent i = this.getIntent();
		 orders = (ArrayList<Order>)i.getSerializableExtra("orders");
		Log.d("THe size of serialiabafdsd","" + orders.size());
		 
		populate_cartlist();
	//************************************************************************************
		populateFoodList1();
	//	Log.d("myfood position 4",myFood.get(3).getFood_title());
		populatelistview1();
		populate_checkout(gettotal(myFood));
		
		//*****************************************************************************
		//for change date button
		 changeDate = (Button) findViewById(R.id.changedatebtn);
		 
	        // Get current date by calender
	         
	        final Calendar c = Calendar.getInstance();
	        year  = c.get(Calendar.YEAR);
	        month = c.get(Calendar.MONTH);
	        day   = c.get(Calendar.DAY_OF_MONTH);
	 
	        // Show current date
	        aDate = new StringBuilder().append(day).append('/')
                    .append(month + 1).append("/").append(year).toString();
	        Start_date =aDate;
	       changeDate.setText(aDate);
	        // Button listener to show date picker dialog
	         
	        changeDate.setOnClickListener(new OnClickListener() {
	 
	            @SuppressWarnings("deprecation")
				public void onClick(View v) {
	                 
	                // On button click show datepicker dialog
	                showDialog(DATE_PICKER_ID);
	            
	 
	            }
	 
	        });
	        //**********************************************************
	        //for time change button
	      
	         
	        /********* display current time on screen Start ********/
	            
	          // final Calendar c1 = Calendar.getInstance();
	           // Current Hour
	           hour = c.get(Calendar.HOUR_OF_DAY);
	           // Current Minute
	           minute = c.get(Calendar.MINUTE);
	            
	           // set current time into output textview
	           updateTime(hour, minute);
	           Start_time =aTime;
	           btnClick = (Button) ((Activity) con).findViewById(R.id.changetimebtn);
               btnClick.setText(aTime);
            
	        /********* display current time on screen End ********/
	            
	           // Add Button Click Listener
	           addButtonClickListener();
	           //*******************************************************************************
	           //change address button listener.
	           Button changeaddress = (Button) findViewById(R.id.changeaddrbtn);
	           changeaddress.setOnClickListener(new OnClickListener() {
	        		 
		            @SuppressWarnings("deprecation")
					public void onClick(View v) {
		                 
		            	showCustomDialog1();
		            	
		            	Log.d("finished ", "executing the changeaddressedittext");
		           
		 
		            }});
	           
	           //************************************************************************************
	           //checkout button
	           Button checkout = (Button) findViewById(R.id.checkoutbtn);
	           checkout.setOnClickListener(new OnClickListener() {
	        		 
		            @SuppressWarnings("deprecation")
					public void onClick(View v) {
		                 
		           senddatatocheckout();
		            	
		            	//Log.d("finished ", "executing the changeaddressedittext");
		           
		 
		            }});
	}
	
	
	
	
	
	
	
	
	
	
	
	private void populate_cartlist()
	{
		
		
		//takes the data obtained from invoking fall and fill it on cart so cart operation can be performed on this data.
		for(int i=0;i<orders.size();i++)
		{
			
			Food f = new Food(orders.get(i).getFood_title(),orders.get(i).getFood_price(),orders.get(i).getQnty());
			cart.addtocart(f);
		}
	}
	
	
public void changeaddress(View v)
{
	showCustomDialog1();
	
	Log.d("finished ", "executing the changeaddressedittext");
	TextView text1 = (TextView) findViewById(R.id.addresstext);
	text1.setText(address.getName()+"\n"+address.getPhone()+"\n"+address.getStreetaddress()+"\n"+address.getArea()+"\n"+address.getCity()+"\n"+address.getPincode());
}
	
	

protected void showCustomDialog1() {
    // TODO Auto-generated method stub
    final Dialog dialog = new Dialog(OrderSummaryActivity.this);
    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
    dialog.setContentView(R.layout.address_dialog);
    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
    
  if(address!=null)
  {

  	EditText edit_1 = (EditText)dialog.findViewById(R.id.addressname);
  edit_1.setText(address.getName());
  	
  EditText edit_2 = (EditText) dialog.findViewById(R.id.addressphone);
 edit_2.setText(address.getPhone());
  
  EditText edit_3 = (EditText) dialog.findViewById(R.id.addressstreet);
  edit_3.setText(address.getStreetaddress());
  
  EditText edit_4 = (EditText) dialog.findViewById(R.id.addressarea);
  edit_4.setText(address.getArea());
  
  EditText edit_5 = (EditText) dialog.findViewById(R.id.addresscity);
  edit_5.setText(address.getCity());
  
  EditText edit_6 = (EditText) dialog.findViewById(R.id.addresspin);
 edit_6.setText(address.getPincode());
  	
  }

  
  Log.d("","inside showdialog");
  
 
    
    //handles add to cart button.
    Button button = (Button)dialog.findViewById(R.id.addrsbtn1);    
    button.setOnClickListener(new View.OnClickListener() {
        
        @Override
        public void onClick(View v) {
          
        	EditText edit_1 = (EditText)dialog.findViewById(R.id.addressname);
        String name=	edit_1.getText().toString();
        	
        EditText edit_2 = (EditText) dialog.findViewById(R.id.addressphone);
        String phone=	edit_2.getText().toString();
        
        EditText edit_3 = (EditText) dialog.findViewById(R.id.addressstreet);
        String street=	edit_3.getText().toString();
        
        EditText edit_4 = (EditText) dialog.findViewById(R.id.addressarea);
        String area=	edit_4.getText().toString();
        
        EditText edit_5 = (EditText) dialog.findViewById(R.id.addresscity);
        String city=	edit_5.getText().toString();
        
        EditText edit_6 = (EditText) dialog.findViewById(R.id.addresspin);
        String pin=	edit_6.getText().toString();
        	
        	
        	address= new Address(name, phone,street,area,city,pin);
        	
         	TextView text1 = (TextView) findViewById(R.id.addresstext);
        	text1.setText(address.getName()+",\nPh:"+address.getPhone()+"\n"+address.getStreetaddress()+", "+address.getArea()+",\n"+address.getCity()+",\n"+address.getPincode());
//
        	
       	//closes dialog
            dialog.dismiss();
        }
    });
            
    dialog.show();
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

	
	
	private void populateFoodList1()
	{//this is final list to shown on listview
		myFood = cart.get_food_for_cart();
	}
	
	public void populatelistview1()
	{
		 adapter = new customlistadapter(OrderSummaryActivity.this,OrderSummaryActivity.this, myFood);
		adapter.notifyDataSetChanged();
		ListView list = (ListView) findViewById(R.id.ordersumlist);
		list.setAdapter(adapter);
	
		
	}
	
	public void populate_checkout(  int total1)
	{
		int  Service_tax =90;
		int Delivery_charge =55;
		int total;
		
		total = total1+ Service_tax+ Delivery_charge;
		
		TextView text1 = (TextView) findViewById(R.id.servicetext) ;
		text1.setText("Service Tax: INR "+ Service_tax);
		
		TextView text2 =(TextView) findViewById(R.id.deliverytext);
		text2.setText("Delivery Charge: INR "+ Delivery_charge);
		
		TextView text3 =(TextView) findViewById(R.id.totaltext);
		text3.setText("Total: INR " + total);
		
	}
	
	//**************************************************************************************
	//for date change button
	
	  @SuppressLint("NewApi") @Override
	    protected Dialog onCreateDialog(int id) {
	        switch (id) {
	        case DATE_PICKER_ID:
	             
	            // open datepicker dialog.
	            // set date picker for current date
	            // add pickerListener listner to date picker
	        	
	        	DatePickerDialog dpd = new DatePickerDialog(this, pickerListener, year, month,day);
	        	if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
	        	    // (picker is a DatePicker)
	        		cal = Calendar.getInstance();
	        	    dpd.getDatePicker().setMinDate(cal.getTimeInMillis()-1000);
	        	} else {
	        	    Log.w("TAG", "API Level < 11 so not restricting date range...");
	        	}
	        	return dpd;
	        	
	       //     return new DatePickerDialog(this, pickerListener, year, month,day);
	        
	        case TIME_DIALOG_ID:
	             
	            // set time picker as current time
	            return new TimePickerDialog(this, timePickerListener, hour, minute,
	                    false);
	          
	        }
	        return null;
	    }
	 
	    private DatePickerDialog.OnDateSetListener pickerListener = new DatePickerDialog.OnDateSetListener() {
	 
	        // when dialog box is closed, below method will be called.
	        @Override
	        public void onDateSet(DatePicker view, int selectedYear,
	                int selectedMonth, int selectedDay) {
	             
	            year  = selectedYear;
	            month = selectedMonth;
	            day   = selectedDay;
	 
	            
	            
	            aDate = new StringBuilder().append(day).append('/')
	                    .append(month+1).append("/").append(year).toString();
	     
	            changeDate = (Button) findViewById(R.id.changedatebtn);
	            changeDate.setText(aDate);
	            
	            // Show selected date
	           Log.d("selected date",year+"/"+month+"/"+day);
	     
	           }
	        };
	
	//**************************************************************************
	        //for time change button
	        public void addButtonClickListener() {
	        	 
	            btnClick = (Button) findViewById(R.id.changetimebtn);
	     
	            btnClick.setOnClickListener(new OnClickListener() {
	     
	                @SuppressWarnings("deprecation")
					@Override
	                public void onClick(View v) {
	     
	                    showDialog(TIME_DIALOG_ID);
	                  
	                    
	                    
	                 
		        
	    
	                }
	     
	            });
	     
	        }
	        
	        
	        private TimePickerDialog.OnTimeSetListener timePickerListener = new TimePickerDialog.OnTimeSetListener() {
	            
	        	 
	            @Override
	            public void onTimeSet(TimePicker view, int hourOfDay, int minutes) {
	                // TODO Auto-generated method stub
	                hour   = hourOfDay;
	                minute = minutes;
	     
	              
	                int i= checktimeifpast(hour, minute);
	              //  updateTime(hour,minute);
	                Log.d("checktimeifpast",""+i);
	           if(i == 1)
	           {
	        	   updateTime(hour,minute);
	             	               
	           }
	           
	           
	           
	                btnClick = (Button) findViewById(R.id.changetimebtn);
	                btnClick.setText(aTime);
	             }
	     
	        };
	     
	        private static String utilTime(int value) {
	             
	            if (value < 10)
	                return "0" + String.valueOf(value);
	            else
	                return String.valueOf(value);
	        }
	         
	        // Used to convert 24hr format to 12hr format with AM/PM values
	        private void updateTime(int hours, int mins) {
	             
	            String timeSet = "";
	            if (hours > 12) {
	                hours -= 12;
	                timeSet = "PM";
	            } else if (hours == 0) {
	                hours += 12;
	                timeSet = "AM";
	            } else if (hours == 12)
	                timeSet = "PM";
	            else
	                timeSet = "AM";
	     
	             
	            String minutes = "";
	            if (mins < 10)
	                minutes = "0" + mins;
	            else
	                minutes = String.valueOf(mins);
	     
	            // Append in a StringBuilder
	           aTime = new StringBuilder().append(hours).append(':')
	                    .append(minutes).append(" ").append(timeSet).toString();
	     
	            Log.d("time picked is",aTime);
	        }
	        
	        
	        public int checktimeifpast(int hour2, int minute2)
	        {
	        	//1 if the delivery date is in the future
	        	//0 if the delivery date is in the past
	        	Calendar c1 = Calendar.getInstance();
	 
	 	     int hour1 = c1.get(Calendar.HOUR_OF_DAY);
	           // Current Minute
	        int   minute1 = c1.get(Calendar.MINUTE);

        	
	        			if(hour2<hour1)
	        			{
	        				Toast.makeText(OrderSummaryActivity.this, "You can't really set delivery time at past!", Toast.LENGTH_LONG).show();
		        		       return 0;
	        			}
	        			else if(hour2==hour1)
	        			{
	        				if(minute2<minute1)
	        				{
	        					Toast.makeText(OrderSummaryActivity.this, "You can't really set delivery time at past!", Toast.LENGTH_LONG).show();
		 	        		       return 0;
	        					
	        				}
	        				else 
	        				{
	        					return 1;
	        				}
	        			}
	        			else
	        			{
	        				return 1;
	        			}
	        		
	        	
	        }
			
	        
	        
	        void senddatatocheckout()
	        {

	        	
	        		Intent myIntent = new Intent(OrderSummaryActivity.this, checkoutActivity.class);
	        		myIntent.putExtra("orders", adapter.populate_order());
	        		myIntent.putExtra("start_date", Start_date );
	        		myIntent.putExtra("start_time", Start_time );
	        		myIntent.putExtra("delivery_date", aDate );
	        		myIntent.putExtra("delivery_time", aTime );
	        		myIntent.putExtra("Address", address );
	            	this.startActivity(myIntent);
	                this.finish();
	        	}
	        
	        
	        
}
