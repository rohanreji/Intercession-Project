package com.maangalabs.prayer;

import android.app.Activity;
import android.app.Dialog;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Toast;

public class CustomDialogClass extends Dialog implements
android.view.View.OnClickListener {

public Activity c;
public Dialog d;
public Button yes, no,cal,ab;
final ScrollView scrollView = new ScrollView(this.getContext());

public CustomDialogClass(Activity a) {
super(a);
// TODO Auto-generated constructor stub
this.c = a;
}

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
requestWindowFeature(Window.FEATURE_NO_TITLE);
setContentView(R.layout.custom_dialog);
yes = (Button) findViewById(R.id.btn_home);
no = (Button) findViewById(R.id.btn_notifier);
cal = (Button) findViewById(R.id.btn_cal);
ab= (Button) findViewById(R.id.btn_ab);
yes.setOnClickListener(this);
no.setOnClickListener(this);
cal.setOnClickListener(this);
ab.setOnClickListener(this);
}

@Override
public void onClick(View v) {
	  Fragment fragment = null;
      CalFragment f=null;
      
switch (v.getId()) {
case R.id.btn_home:
	
	
	System.out.print("gkhijopj;oghfhfjhgfhjjjfhghfghvjbj");
	MainActivity.l.removeView(scrollView);
	MainActivity.l.setVisibility(View.INVISIBLE);
	 fragment = new HomeFragment();
	 dismiss();
  
  break;
  
	
	
case R.id.btn_cal:
	

	fragment =null;
	f = new CalFragment(c);
	dismiss();
break;
case R.id.btn_ab: 
	
	
	System.out.print("aboutvkjgkhlhjlbjlk;lk;lk;lk;;;,;,;,;,';,;lm;llnkfuhfu");
	MainActivity.l.removeView(scrollView);

	MainActivity.l.setVisibility(View.INVISIBLE);
	  fragment = new AboutFragment();
	  dismiss();
	  break;
	
	


case R.id.btn_notifier:
	MainActivity.l.removeView(scrollView);

	MainActivity.l.setVisibility(View.INVISIBLE);
  fragment = new SettingsFragment();
  dismiss();
  break;

default:
	MainActivity.l.removeView(scrollView);

	MainActivity.l.setVisibility(View.INVISIBLE);
	dismiss();
  break;
}
dismiss();
if (fragment != null) {
    FragmentManager fragmentManager = MainActivity.fragmentManager;
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
	scrollView.setBackgroundColor(Color.BLACK);
f.setFocusable(true);
f.setOnTouchListener(f);
	scrollView.addView(f);
	MainActivity.l.addView(scrollView);

	MainActivity.l.setVisibility(View.VISIBLE);
	//scrollView.smoothScrollTo(4000, 30);
	//setContentView(scrollView);
	scrollView.post(new Runnable() { 
        public void run() { 
             scrollView.smoothScrollTo(0, CalFragment.scx);
        } 
});
	
	
	

	
}
else {
    // error in creating fragment
    Log.e("MainActivity", "Error in creating fragment");
}

}
}