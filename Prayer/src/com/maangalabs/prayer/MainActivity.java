package com.maangalabs.prayer;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v4.app.ActionBarDrawerToggle;
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
 
@SuppressLint("NewApi") public class MainActivity extends Activity {
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    int maxcount=220;
    int fl;
   int backp=0;
    
    private CharSequence mDrawerTitle;
 
    // used to store app title
    private CharSequence mTitle;
 
    // slide menu items
    private String[] navMenuTitles;
    private TypedArray navMenuIcons;
 
    private ArrayList<NavDrawerItem> navDrawerItems;
    private NavDrawerListAdapter adapter;
 
    @SuppressLint("NewApi") @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       fl=0;
        mTitle = mDrawerTitle = getTitle();
 
        // load slide menu items
        navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items);
 
        // nav drawer icons from resources
        navMenuIcons = getResources()
                .obtainTypedArray(R.array.nav_drawer_icons);
 
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.list_slidermenu);
 
        navDrawerItems = new ArrayList<NavDrawerItem>();
 
        // adding nav drawer items to array
        // Home
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[0], navMenuIcons.getResourceId(0, -1)));
        // Find People
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[1], navMenuIcons.getResourceId(1, -1)));
        // Photos
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[2], navMenuIcons.getResourceId(2, -1)));
        // Communities, Will add a counter here
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[3], navMenuIcons.getResourceId(3, -1), true, "22"));
        // Pages
       
        // Recycle the typed array
        navMenuIcons.recycle();
 
        mDrawerList.setOnItemClickListener(new SlideMenuClickListener());
 
        // setting the nav drawer list adapter
        adapter = new NavDrawerListAdapter(getApplicationContext(),
                navDrawerItems);
        mDrawerList.setAdapter(adapter);
 
        // enabling action bar app icon and behaving it as toggle button
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
 
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.drawable.ic_drawer, //nav menu toggle icon
                R.string.app_name, // nav drawer open - description for accessibility
                R.string.app_name // nav drawer close - description for accessibility
        ) {
            public void onDrawerClosed(View view) {
                getActionBar().setTitle(mTitle);
                // calling onPrepareOptionsMenu() to show action bar icons
                invalidateOptionsMenu();
            }
 
            public void onDrawerOpened(View drawerView) {
                getActionBar().setTitle(mDrawerTitle);
                // calling onPrepareOptionsMenu() to hide action bar icons
                invalidateOptionsMenu();
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);
 
        if (savedInstanceState == null) {
            // on first time display view for first nav item
            displayView(0);
        }
    }
 
    /**
     * Slide menu item click listener
     * */
    private class SlideMenuClickListener implements
            ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                long id) {
            // display view for selected nav drawer item
            displayView(position);
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
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle action bar actions click
        switch (item.getItemId()) {
        case R.id.action_settings:
            return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }
 
    /***
     * Called when invalidateOptionsMenu() is triggered
     */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // if nav drawer is opened, hide the action items
        boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
        menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }
 
    /**
     * Diplaying fragment view for selected nav drawer list item
     * */
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
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.frame_container, fragment).commit();
 
            // update selected item and title, then close the drawer
            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            setTitle(navMenuTitles[position]);
            mDrawerLayout.closeDrawer(mDrawerList);
        } 
        else if(f!=null)
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
        	
        	
        	getActionBar().hide();
          //   setTitle(navMenuTitles[position]);
             mDrawerLayout.closeDrawer(mDrawerList);
        	
        }
        else {
            // error in creating fragment
            Log.e("MainActivity", "Error in creating fragment");
        }
    }
 
   
    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getActionBar().setTitle(mTitle);
    }
 
    /**
     * When using the ActionBarDrawerToggle, you must call it during
     * onPostCreate() and onConfigurationChanged()...
     */
 
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }
 
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        mDrawerToggle.onConfigurationChanged(newConfig);
    }
    public void onBackPressed()
    {
    	if(fl==1)
    	{
    		getActionBar().show();
    		//
    		setContentView(R.layout.activity_main);
    		
    	            fl=0;
    	            
    	            mTitle = mDrawerTitle = getTitle();
    	            
    	            // load slide menu items
    	            navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items);
    	     
    	            // nav drawer icons from resources
    	            navMenuIcons = getResources()
    	                    .obtainTypedArray(R.array.nav_drawer_icons);
    	     
    	            mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
    	            mDrawerList = (ListView) findViewById(R.id.list_slidermenu);
    	     
    	            navDrawerItems = new ArrayList<NavDrawerItem>();
    	     
    	            // adding nav drawer items to array
    	            // Home
    	            navDrawerItems.add(new NavDrawerItem(navMenuTitles[0], navMenuIcons.getResourceId(0, -1)));
    	            // Find People
    	            navDrawerItems.add(new NavDrawerItem(navMenuTitles[1], navMenuIcons.getResourceId(1, -1)));
    	            // Photos
    	            navDrawerItems.add(new NavDrawerItem(navMenuTitles[2], navMenuIcons.getResourceId(2, -1)));
    	            // Communities, Will add a counter here
    	            navDrawerItems.add(new NavDrawerItem(navMenuTitles[3], navMenuIcons.getResourceId(3, -1), true, "22"));
    	            // Pages
    	           
    	            // Recycle the typed array
    	            navMenuIcons.recycle();
    	     
    	            mDrawerList.setOnItemClickListener(new SlideMenuClickListener());
    	     
    	            // setting the nav drawer list adapter
    	            adapter = new NavDrawerListAdapter(getApplicationContext(),
    	                    navDrawerItems);
    	            mDrawerList.setAdapter(adapter);
    	     
    	            // enabling action bar app icon and behaving it as toggle button
    	            getActionBar().setDisplayHomeAsUpEnabled(true);
    	            getActionBar().setHomeButtonEnabled(true);
    	     
    	            mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
    	                    R.drawable.ic_drawer, //nav menu toggle icon
    	                    R.string.app_name, // nav drawer open - description for accessibility
    	                    R.string.app_name // nav drawer close - description for accessibility
    	            ) {
    	                public void onDrawerClosed(View view) {
    	                    getActionBar().setTitle(mTitle);
    	                    // calling onPrepareOptionsMenu() to show action bar icons
    	                    invalidateOptionsMenu();
    	                }
    	     
    	                public void onDrawerOpened(View drawerView) {
    	                    getActionBar().setTitle(mDrawerTitle);
    	                    // calling onPrepareOptionsMenu() to hide action bar icons
    	                    invalidateOptionsMenu();
    	                }
    	            };
    	            mDrawerLayout.setDrawerListener(mDrawerToggle);
    	     
    	           
    	            
    	            
    	            
    	            
    	            
    	            Fragment fragment = new HomeFragment();
    	    		 if (fragment != null) {
    	    	            FragmentManager fragmentManager = getFragmentManager();
    	    	            fragmentManager.beginTransaction()
    	    	                    .replace(R.id.frame_container, fragment).commit();
    	    	 
    	    	            // update selected item and title, then close the drawer
    	    	            mDrawerList.setItemChecked(0, true);
    	    	            mDrawerList.setSelection(0);
    	    	            setTitle(navMenuTitles[0]);
    	    	            mDrawerLayout.closeDrawer(mDrawerList);
    	    	              
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