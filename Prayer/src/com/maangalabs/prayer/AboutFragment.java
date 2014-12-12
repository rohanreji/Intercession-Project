package com.maangalabs.prayer;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

 public class AboutFragment extends android.support.v4.app.Fragment {
	   
    public AboutFragment(){}
     TextView ct,cn,cc,ct1;
     int maxcount=220;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
  
        View rootView = inflater.inflate(R.layout.fragment_about, container, false);
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "prfont.ttf");
        TextView txt = (TextView)  rootView.findViewById(R.id.textView1);
         ct=(TextView)rootView.findViewById(R.id.textView2);
       
       txt.setTypeface(font);
        ct.setTypeface(font);
       
        return rootView;
    }
   
}