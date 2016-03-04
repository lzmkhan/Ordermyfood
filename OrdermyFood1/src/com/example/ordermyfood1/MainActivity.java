package com.example.ordermyfood1;

import java.util.Locale;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR_OVERLAY); 
        
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#908eb242")) );
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
      

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onorderclick(View v)
    {
    	Intent myIntent = new Intent(MainActivity.this, MenuScreenActivity.class);
    	//myIntent.putExtra("key", value); //Optional parameters
    	MainActivity.this.startActivity(myIntent);
    }
    
    public void onenquiryclick(View v)
    {
    	//Intent myIntent = new Intent(MainActivity.this, OrderSummaryActivity.class);
    	//myIntent.putExtra("key", value); //Optional parameters
    	//MainActivity.this.startActivity(myIntent);
    	Log.d("blach","");
    }
    

  

}
