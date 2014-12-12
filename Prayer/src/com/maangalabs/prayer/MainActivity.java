package com.maangalabs.prayer;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
 
public class MainActivity extends android.support.v4.app.FragmentActivity {
   
    int maxcount=250;
    int fl;
   int backp=0;
    
   
  static FragmentManager fragmentManager;
  static LinearLayout l;
    public void ev1(View v)
    {
    	startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/jymest")));
    }
    
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        l=(LinearLayout)findViewById(R.id.llw);
       fl=0;
       Fragment fragment = null;
       fragment = new HomeFragment();
    
       if (fragment != null) {
    	   FragmentManager fragmentManager = getSupportFragmentManager();
    	   
           fragmentManager.beginTransaction()
                   .replace(R.id.frame_container, fragment).commit();

           // update selected item and title, then close the drawer
        
      //     mDrawerLayout.closeDrawer(mDrawerList);
             
} 
    
    }
       
 
 
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
 
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // toggle nav drawer on selecting action bar app icon/title
      
        // Handle action bar actions click
        switch (item.getItemId()) {
        case R.id.action_cart:
        	CustomDialogClass cdd=new CustomDialogClass(MainActivity.this);
        	cdd.show();
        	
        default:
            return super.onOptionsItemSelected(item);
        }
    }
 
      private void displayView(int position) {
        // update the main content by replacing fragments
        Fragment fragment = null;
        CalFragment f=null;
        switch (position) {
        case 0:
           fragment = new HomeFragment();
          
            break;
        case 1:
        	fragment =null;
        	f = new CalFragment(MainActivity.this);
        	
            break;
        case 2:
       //     fragment = new PhotosFragment();
        	  fragment = new SettingsFragment();
            break;
        case 3:
       //     fragment = new CommunityFragment();
        	  fragment = new AboutFragment();
            break;
       
 
        default:
            break;
        }
 
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.frame_container, fragment).commit();
 
            // update selected item and title, then close the drawer
          
        //    mDrawerLayout.closeDrawer(mDrawerList);
        } 
        else  if(f!=null)
        {
        	//setContentView(R.layout.newidea);
        	//LinearLayout LL = (LinearLayout)findViewById(R.id.ll1);
        	//View V=(View)findViewById(R.id.calFragment1);
        	final ScrollView scrollView = new ScrollView(this);
        	
        	scrollView.setBackgroundColor(Color.BLACK);
        f.setFocusable(true);
      f.setOnTouchListener(f);
        	scrollView.addView(f);
        	//scrollView.smoothScrollTo(4000, 30);
        	setContentView(scrollView);
        	scrollView.post(new Runnable() { 
                public void run() { 
                     scrollView.smoothScrollTo(0, CalFragment.scx);
                } 
        });
        	fl=1;
        	
        	
     
        	
        }
        else {
            // error in creating fragment
            Log.e("MainActivity", "Error in creating fragment");
        }
    }
 
   
   
 
   
    public void onBackPressed()
    {
    	if(fl==1)
    	{
    		
    	            
    	            Fragment fragment = new HomeFragment();
    	    		 if (fragment != null) {
    	    	            FragmentManager fragmentManager = getSupportFragmentManager();
    	    	            fragmentManager.beginTransaction()
    	    	                    .replace(R.id.frame_container, fragment).commit();
    	    	 
    	    	            // update selected item and title, then close the drawer
    	    	         
    	    	       //     mDrawerLayout.closeDrawer(mDrawerList);
    	    	              
    	        } 
    	
    		    		 
    		}
    	else
    	{
    		if(backp==1)
    		finish();
    		else
    		{
    			Toast.makeText(getApplicationContext(), "press again to exit",Toast.LENGTH_SHORT).show();
    			backp=1;
    		}	
    	}
    	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  
}