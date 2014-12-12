package com.maangalabs.prayer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
public class HomeFragment extends  android.support.v4.app.Fragment {
   
    public HomeFragment(){}
     TextView ct,cn,cc,ct1,ct2,ndays,ncount,ce,ct11,ct12,ct13,ct14,ct15,ct16,ct17,ct18;
     int maxcount=250;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
  
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "prfont.ttf");
        Typeface fontn = Typeface.createFromAsset(getActivity().getAssets(), "Limelight.otf");
        TextView txt = (TextView)  rootView.findViewById(R.id.textView2);
        ndays = (TextView)  rootView.findViewById(R.id.textView12);
         ncount = (TextView)  rootView.findViewById(R.id.textView22);
         ce=(TextView)rootView.findViewById(R.id.ctitle2);
         ct=(TextView)rootView.findViewById(R.id.ctitle);
         ct1=(TextView)rootView.findViewById(R.id.textView3);
         ct11=(TextView)rootView.findViewById(R.id.textView44);
         ct12=(TextView)rootView.findViewById(R.id.textView45);
         ct13=(TextView)rootView.findViewById(R.id.textView46);
         ct14=(TextView)rootView.findViewById(R.id.textView47);
         ct15=(TextView)rootView.findViewById(R.id.textView48);
         ct16=(TextView)rootView.findViewById(R.id.textView49);
         ct17=(TextView)rootView.findViewById(R.id.textView50);
         ct18=(TextView)rootView.findViewById(R.id.textView51);
        
         ct2=(TextView)rootView.findViewById(R.id.textView2);
         cn=(TextView)rootView.findViewById(R.id.cnames);
         cc=(TextView)rootView.findViewById(R.id.ccords);
        txt.setTypeface(font);
        ce.setTypeface(font);
        ndays.setTypeface(fontn);
        ncount.setTypeface(fontn);
        ct1.setTypeface(font);
        ct11.setTypeface(font);
        ct12.setTypeface(font);
        ct13.setTypeface(font);
        ct14.setTypeface(font);
        ct15.setTypeface(font);
        ct16.setTypeface(font);
        ct17.setTypeface(font);
        ct18.setTypeface(font);

        ct.setTypeface(font);
        cn.setTypeface(font);
        cc.setTypeface(font);
        modify();
        return rootView;
    }
    public void modify()
    {
    	Date date = new Date();
    	SimpleDateFormat postFormater = new SimpleDateFormat("dd/MM/yyyy"); 
		String cudate=postFormater.format(date); 
    	int flag=1;
    	for(int i=0;i<maxcount;i++)
    	{
    		
    		if(AllVar.cdate[i].equals(cudate))
    		{
    			ce.setVisibility(View.VISIBLE);
    			ct2.setVisibility(View.VISIBLE);
				ct1.setVisibility(View.VISIBLE);
				ct11.setVisibility(View.VISIBLE);
				ct12.setVisibility(View.VISIBLE);
				ct13.setVisibility(View.VISIBLE);
				ct14.setVisibility(View.VISIBLE);
				
				ct15.setVisibility(View.VISIBLE);
				
				ct16.setVisibility(View.VISIBLE);
				ct17.setVisibility(View.VISIBLE);
				ct18.setVisibility(View.VISIBLE);
				cc.setVisibility(View.VISIBLE);
    			ct.setText(AllVar.cname[i]);
    			ndays.setVisibility(View.INVISIBLE);
    			ncount.setVisibility(View.INVISIBLE);
    			String snew=AllVar.scname[i];
    			StringBuilder sb=new StringBuilder(snew);
    			int ui=0;
    			while((ui=sb.indexOf(" ",ui+25))!=-1){
    				sb.replace(ui,ui+1, "\n");
    			}
    			
    			cn.setText("We submit\n"+sb+" ");
    			ce.setText("DAY\n"+(i+1));
    			cc.setText("\nCollege SubRegion: "+AllVar.ccord1[i]);
    			flag=0;
    			
    		}
    		
    	
    	}
    	
    	
    	
    	
    	
    	if(flag==1)
		{
			
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date dcudate,dfidate;
			 
			try {
		 
				 dcudate = formatter.parse(cudate);
				
				 dfidate = formatter.parse(AllVar.cdate[0]);
			
			if(dcudate.before(dfidate))
			{
				
			
					
					ct2.setVisibility(View.INVISIBLE);
					ct1.setVisibility(View.INVISIBLE);
					ct11.setVisibility(View.INVISIBLE);
					ct12.setVisibility(View.INVISIBLE);
					ct13.setVisibility(View.INVISIBLE);
					ct14.setVisibility(View.INVISIBLE);
					ct15.setVisibility(View.INVISIBLE);
					ct16.setVisibility(View.INVISIBLE);
					ct17.setVisibility(View.INVISIBLE);
					ct18.setVisibility(View.INVISIBLE);
					cn.setVisibility(View.INVISIBLE);
					cc.setVisibility(View.INVISIBLE);
					 long diff = dfidate.getTime() - dcudate.getTime();
					 long days=((((((diff/1000)%60)/60)%60)/60)%24)/24;
						//	 TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
					 
    				ct.setText("Prayer Up");
    				ce.setVisibility(View.INVISIBLE);
        			ndays.setVisibility(View.VISIBLE);
        			ncount.setVisibility(View.VISIBLE);
        			ndays.setText(Long.toString(days));
        			ncount.setText("MORE DAYS");
			 
				
				
				
				
				
				
			
			}
			else
			{
				ct2.setVisibility(View.INVISIBLE);
				ct1.setVisibility(View.INVISIBLE);
				ct11.setVisibility(View.INVISIBLE);
				ct12.setVisibility(View.INVISIBLE);
				ct13.setVisibility(View.INVISIBLE);
				ct14.setVisibility(View.INVISIBLE);
				ct15.setVisibility(View.INVISIBLE);
				ct16.setVisibility(View.INVISIBLE);
				ct17.setVisibility(View.INVISIBLE);
				ct18.setVisibility(View.INVISIBLE);
				cc.setVisibility(View.INVISIBLE);
				cn.setVisibility(View.INVISIBLE);
				ct.setText("Prayer Up");
				
    			ndays.setVisibility(View.VISIBLE);
    			ncount.setVisibility(View.VISIBLE);
    			ndays.setText("A Jesus Youth MEST Initiative.");
    			ce.setVisibility(View.INVISIBLE);
    			ncount.setText("");
			}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    }
}
