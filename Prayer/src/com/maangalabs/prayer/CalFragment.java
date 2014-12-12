package com.maangalabs.prayer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Scroller;
import android.widget.TextView;
import android.widget.Toast;

 public class CalFragment extends View implements View.OnTouchListener {
    
    //public CalFragment(){}
    int height,width;
    int yar[],xar[];
    String dar[];
    int maxcount=250;
    float radius;
    public static int scx=0;
  //  private class DrawView extends View {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
       
        Paint paint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        Paint paint7 = new Paint(Paint.ANTI_ALIAS_FLAG);
        Paint paint8 = new Paint(Paint.ANTI_ALIAS_FLAG);
        Paint paint9 = new Paint(Paint.ANTI_ALIAS_FLAG);
        Paint paint10 = new Paint(Paint.ANTI_ALIAS_FLAG);
        Paint paint11= new Paint(Paint.ANTI_ALIAS_FLAG);
        Paint paint12 = new Paint(Paint.ANTI_ALIAS_FLAG);
        Paint paint5 = new Paint(Paint.ANTI_ALIAS_FLAG);
        Paint paint3 = new Paint();
        
      //  public DrawView(Context context) {
        public CalFragment(Context context) {
            super(context);
            yar=new int[250];
            xar=new int[250];
            dar=new String[250];
            paint.setStyle(Paint.Style.STROKE); 
            paint.setColor(Color.WHITE);
            paint.setStrokeWidth(8);
            paint1.setStyle(Paint.Style.STROKE); 
            paint1.setColor(Color.YELLOW);
            paint1.setStrokeWidth(8);
            paint7.setStyle(Paint.Style.FILL); 
            paint7.setColor(Color.RED);
            paint7.setARGB(255, 255, 0, 0);
            paint8.setStyle(Paint.Style.FILL); 
            paint8.setColor(Color.parseColor("#FFFF00"));
            paint9.setStyle(Paint.Style.FILL); 
            paint9.setColor(Color.parseColor("#3333CC"));
            paint10.setStyle(Paint.Style.FILL); 
            paint10.setColor(Color.parseColor("#99FF66"));
            paint11.setStyle(Paint.Style.FILL); 
            paint11.setColor(Color.parseColor("#999966"));
            paint12.setStyle(Paint.Style.FILL); 
            paint12.setColor(Color.parseColor("#FF9900"));
           // paint2.setStrokeWidth(8);
           // paint8.setARGB(255, 255, 0, 0);
            paint5.setStyle(Paint.Style.FILL); 
            paint5.setColor(Color.BLUE);
           // paint2.setStrokeWidth(8);
            paint5.setARGB(255, 0, 255, 0);
            
            
            WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            Display display = wm.getDefaultDisplay();
            
            
            
            //Point size = new Point();
          //  display.getSize(size);
            
            height = display.getHeight();
            //width=size.y;
            radius=display.getWidth()/5;
            if(radius>100)
            	radius=100;
            paint3.setColor(Color.BLACK);
            paint3.setTextSize(22f);
            paint3.setAntiAlias(true);
            paint3.setTextAlign(Paint.Align.CENTER);
            

        }
        public CalFragment(Context context, AttributeSet attrs) {
            super(context, attrs);
            paint.setColor(Color.WHITE);
           
        }
        public CalFragment(Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);
            paint.setColor(Color.BLACK);
        }

        @Override
        protected void onDraw(Canvas canvas) {
        	super.onDraw(canvas);
        	String dateStr = "18/08/2014"; 
        	Date date = new Date();
        	
        	String sd1="December 25";
        	SimpleDateFormat curFormater = new SimpleDateFormat("dd/MM/yyyy"); 
        	Date dateObj;
			try {
				dateObj = curFormater.parse(dateStr);
				
				SimpleDateFormat postFormater = new SimpleDateFormat("MMMM dd"); 
				String cdate=postFormater.format(date); 
				 
				
				Calendar c = Calendar.getInstance();
	        	 for(int i=0;i<maxcount;i++)
	                 
	        	{
	        		 String newDateStr = postFormater.format(dateObj); 
	        		 if(newDateStr.equals(sd1))
	 				{
	 					i--;
	 					c.add(Calendar.DATE, 1);
	 					String output = curFormater.format(c.getTime());
		            	 dateObj=curFormater.parse(output);
	 				}
	        		 else
	        		 {
	        		
	        		 
	        		 c.setTime(dateObj);
	        		 
	        		 
	        		 Rect bounds = new Rect();
		            	paint3.getTextBounds(newDateStr, 0, newDateStr.length(), bounds);
		            	
		            	 c.add(Calendar.DATE, 1);
		            	 String output = curFormater.format(c.getTime());
		            	 dateObj=curFormater.parse(output);
	        		if(i!=0)
	        		{
	            	if(i%2==0)
	            canvas.drawLine(canvas.getWidth()/2, 400*i+radius,canvas.getWidth()/2 , 400*(i+1), paint);
	            	else
	            		 canvas.drawLine(canvas.getWidth()/2, 400*i+radius,canvas.getWidth()/2 , 400*(i+1), paint1);
	        		}
	            	if(newDateStr.equals(cdate))
	            	{
	            		canvas.drawCircle(canvas.getWidth()/2, 400*(i+1), radius, paint5);
	            		scx=400*(i+1)-height/2;
	            	}
	            	else
	            	{
	            		if(AllVar.ccord1[i].equals("North"))
	            	canvas.drawCircle(canvas.getWidth()/2, 400*(i+1), radius, paint7);
	            		else if(AllVar.ccord1[i].equals("South"))
	    	            	canvas.drawCircle(canvas.getWidth()/2, 400*(i+1), radius, paint8);
	            		else if(AllVar.ccord1[i].equals("Central"))
	    	            	canvas.drawCircle(canvas.getWidth()/2, 400*(i+1), radius, paint9);
	            		else if(AllVar.ccord1[i].equals("North Central"))
	    	            	canvas.drawCircle(canvas.getWidth()/2, 400*(i+1), radius, paint10);
	            		else if(AllVar.ccord1[i].equals("Eastern"))
	    	            	canvas.drawCircle(canvas.getWidth()/2, 400*(i+1), radius, paint11);
	            		else if(AllVar.ccord1[i].equals("South Central"))
	    	            	canvas.drawCircle(canvas.getWidth()/2, 400*(i+1), radius, paint12);
	            		else 
	            			canvas.drawCircle(canvas.getWidth()/2, 400*(i+1), radius, paint8);
	            	
	            		
	            	}
	            	 canvas.drawText(newDateStr, canvas.getWidth()/2, 400*(i+1), paint3);
	            	 yar[i]=400*(i+1);
	            	 xar[i]=canvas.getWidth()/2;
	            	 dar[i]=newDateStr;
	        		 }
	            }
	           
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
        	 
            
           
           
           
        }

        @Override 
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);

            int parentWidth = MeasureSpec.getSize(widthMeasureSpec);
            int parentHeight = 100500;
            this.setMeasuredDimension(parentWidth, parentHeight);
        }
        private boolean inCircle(float x, float y, float circleCenterX, float circleCenterY, float circleRadius) {
            double dx = Math.pow(x - circleCenterX, 2);
            double dy = Math.pow(y - circleCenterY, 2);

            if ((dx + dy) < Math.pow(circleRadius, 2)) {
                return true;
            } else {
                return false;
            }
        }
		@Override
		public boolean onTouch(View arg0, MotionEvent event) {
			// TODO Auto-generated method stub
			
			switch(event.getAction()){
		    case MotionEvent.ACTION_DOWN: {
		    	for(int i=0;i<maxcount;i++)
		    	{
		    		
		        if  (inCircle(event.getX(), event.getY(), xar[i], yar[i], radius))
		        {
		        	
		            
		             Dialog dialog = new Dialog(this.getContext());
	                // Include dialog.xml file
	                dialog.setContentView(R.layout.dialog);
	                // Set dialog title
	              dialog.setTitle("Prayer Up");
	                
	                Typeface font = Typeface.createFromAsset(this.getContext().getAssets(), "Limelight.otf");
	                // set values for custom dialog components - text, image and button
	                TextView text = (TextView) dialog.findViewById(R.id.collegename);
	                text.setText(AllVar.cname[i]);
	                text.setPadding(20, 0, 0,0);
	                text.setTypeface(font);
	                TextView text1 = (TextView) dialog.findViewById(R.id.collegesub);
	                text1.setText("SubRegion: "+AllVar.ccord1[i]);
	                text1.setTypeface(font);
	                text1.setPadding(10, 0, 0,0);
	                TextView text2 = (TextView) dialog.findViewById(R.id.collegdate);
	                text2.setText(AllVar.cdate[i]);
	                text2.setPadding(10, 0, 0,0);
	                text2.setTypeface(font);
	                dialog.setCancelable(true);
	               
	 
	                dialog.show();
	                 
	              
		            
		            
		            
		            break;
		        }
		    	}
		        return true;
		    }

		}
		return false;
		}
    }   
  /*  @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    	 View rootView = inflater.inflate(R.layout.fragment_cal, container, false);
    	
    	
    	return new DrawView(this.getActivity());
       
          
        
    }*/
//}