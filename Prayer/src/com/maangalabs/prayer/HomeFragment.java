package com.maangalabs.prayer;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
 
@SuppressLint("NewApi") public class HomeFragment extends Fragment {
   
    public HomeFragment(){}
     TextView ct,cn,cc,ct1;
     int maxcount=9;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
  
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "prfont.ttf");
        TextView txt = (TextView)  rootView.findViewById(R.id.textView2);
         ct=(TextView)rootView.findViewById(R.id.ctitle);
         ct1=(TextView)rootView.findViewById(R.id.textView3);
         cn=(TextView)rootView.findViewById(R.id.cnames);
         cc=(TextView)rootView.findViewById(R.id.ccords);
        txt.setTypeface(font);
        ct1.setTypeface(font);
        ct.setTypeface(font);
        cn.setTypeface(font);
        cc.setTypeface(font);
        modify();
        return rootView;
    }
    public void modify()
    {
    	Date date = new Date();
    	SimpleDateFormat postFormater = new SimpleDateFormat("MMMM dd, yyyy"); 
		String cudate=postFormater.format(date); 
    	
    	for(int i=0;i<maxcount;i++)
    	{
    		
    		if(AllVar.cdate[i].equals(cudate))
    		{
    			
    			ct.setText(AllVar.cname[i]);
    			cn.setText("especially "+AllVar.cname[i]+",");
    			cc.setText("\nCollege Coordinator:\n"+AllVar.ccord[i]);
    		}
    	}
    }
}
