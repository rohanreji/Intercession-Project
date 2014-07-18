package com.maangalabs.prayer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;








import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.widget.TimePicker;

import com.maangalabs.prayer.*;
public class MyService extends Service  {
int maxcount=9;
int hours;
int mins;
public static TimePicker ty;
int h,m;
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	public void onCreate() {
		
		
    	
			
		
		
	//h=SettingsFragment.timePicker.getCurrentHour();
	//m=SettingsFragment.timePicker.getCurrentMinute();
		CountDownTimer t = new CountDownTimer( Long.MAX_VALUE , 40000 ) {

    // This is called every interval. (Every 10 seconds in this example)
    public void onTick(long millisUntilFinished) {
    	Calendar c = Calendar.getInstance(); 
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int min=c.get(Calendar.MINUTE);
		int am=c.get(Calendar.AM_PM);
		Date date = new Date();
    	SimpleDateFormat postFormater = new SimpleDateFormat("MMMM dd, yyyy"); 
		String cudate=postFormater.format(date); 
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(MyService.this);
		  hours = preferences.getInt("hour",0);
		 mins= preferences.getInt("min",0);
		if((hours==hour)&&(mins==min))
		{
			for(int i=0;i<maxcount;i++)
			{
				if(AllVar.cdate[i].equals(cudate))
			{
					String ns = Context.NOTIFICATION_SERVICE;
					NotificationManager mNotificationManager = (NotificationManager) getSystemService(ns);

					int icon = R.drawable.ic_launcher;        
					CharSequence tickerText = "JY Prayer"; // ticker-text
					long when = System.currentTimeMillis();         
					Context context = getApplicationContext();     
					CharSequence contentTitle = "JY Prayer";  
					CharSequence contentText = "Pray For "+AllVar.cname[i];      
					Intent notificationIntent = new Intent(MyService.this, MainActivity.class);
					PendingIntent contentIntent = PendingIntent.getService(MyService.this, 0, notificationIntent, 0);
					Notification notification = new Notification(icon, tickerText, when);
					notification.setLatestEventInfo(context, contentTitle, contentText, contentIntent);

					// and this
					final int HELLO_ID = 1;
					mNotificationManager.notify(HELLO_ID, notification);
}
					}
		}
    }

    public void onFinish() {
        
        start();
    }
 }.start();
		
		
		
		
	}

}
