package com.maangalabs.prayer;

import java.util.Calendar;








import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

@SuppressLint("NewApi") public class SettingsFragment extends Fragment {
	//  public static TimePicker ti;
    public SettingsFragment(){}
     TextView ct,cn,cc,ct1;
     CheckBox ch;
     int maxcount=220;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_settings, container, false);
        ch=(CheckBox)rootView.findViewById(R.id.checkBox1);
       if(isMyServiceRunning(MyService.class))
       {
    	   ch.setChecked(true);
       }
       else
       {
    	   ch.setChecked(false);
       }
         MyService.ty  = (TimePicker) rootView.findViewById(R.id.timePicker1);
        final Calendar c = Calendar.getInstance();
      int hour = c.get(Calendar.HOUR_OF_DAY);
             int minute = c.get(Calendar.MINUTE);
             SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
   		int   hours = preferences.getInt("hour",0);
   		int mins= preferences.getInt("min",0);
   		if(hours!=0)
           MyService.ty.setCurrentHour(hours);
   		else
   		 MyService.ty.setCurrentHour(hour);
   		if(mins!=0)
          MyService.ty.setCurrentMinute(mins);
   		else
   		 MyService.ty.setCurrentMinute(minute);
           
            

          MyService.ty.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {

              public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
            	  AllVar.hou=MyService.ty.getCurrentHour();
      			AllVar.min=MyService.ty.getCurrentMinute();
      			SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
      			 SharedPreferences.Editor editor = preferences.edit();
      			 editor.putInt("hour",MyService.ty.getCurrentHour());
      			 editor.putInt("min",MyService.ty.getCurrentMinute());
      			 editor.commit();
              }
          });
          
          
 ch.setOnClickListener(new OnClickListener() {
	 
	  @Override
	  public void onClick(View v) {
               //is chkIos checked?
		if (((CheckBox) v).isChecked()) {
			Toast.makeText(getActivity(), "enabled", Toast.LENGTH_SHORT).show();
			Intent i= new Intent(getActivity(), MyService.class);
			i.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);	
			// potentially add data to the intent
			i.putExtra("KEY1", "Value to be used by the service");
			getActivity().startService(i);
			AllVar.hou=MyService.ty.getCurrentHour();
			AllVar.min=MyService.ty.getCurrentMinute();
			SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
			 SharedPreferences.Editor editor = preferences.edit();
			 editor.putInt("hour",MyService.ty.getCurrentHour());
			 editor.putInt("min",MyService.ty.getCurrentMinute());
			 editor.commit();
			
		}
		else
		{
			getActivity().stopService(new Intent(getActivity(), MyService.class));
		}

	  }
	});
 
        return rootView;
    }
    private boolean isMyServiceRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) getActivity().getSystemService(Context.ACTIVITY_SERVICE);
        for (RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }
}