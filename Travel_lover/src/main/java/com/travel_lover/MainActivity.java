package com.travel_lover;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends Activity {
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.activity_main);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,R.layout.title);
        
        Button button1 = (Button)findViewById(R.id.button1);
        button1.getBackground().setAlpha(100);
        Button button2 = (Button)findViewById(R.id.button2);
        button2.getBackground().setAlpha(100);
        Button button3 = (Button)findViewById(R.id.button3);
        button3.getBackground().setAlpha(100);
        Button button4 = (Button)findViewById(R.id.button4);
        button4.getBackground().setAlpha(100);
        Button button5 = (Button)findViewById(R.id.button5);
        button5.getBackground().setAlpha(100);
        Button button6 = (Button)findViewById(R.id.button6);
        button6.getBackground().setAlpha(100);
        
        button1.setOnClickListener(new TuanListener());
        button2.setOnClickListener(new MoreListener());
        button3.setOnClickListener(new HotelListener());
        //button4.setOnClickListener(new MapsListener());
        button5.setOnClickListener(new JingListener());
        button6.setOnClickListener(new FoodListener());
    }
    
	class TuanListener implements OnClickListener{

		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(MainActivity.this, WebActivity.class);
			MainActivity.this.startActivity(intent);
		}
    	
    }
	
    class MoreListener implements OnClickListener{

		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(MainActivity.this, MoreActivity.class);
			MainActivity.this.startActivity(intent);
		}
    	
    }
    
    class HotelListener implements OnClickListener{

		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(MainActivity.this, WebHotel.class);
			MainActivity.this.startActivity(intent);
		}
    	
    }
    
    
//    class MapsListener implements OnClickListener{
//
//		public void onClick(View v) {
//			// TODO Auto-generated method stub
//			Intent intent = new Intent();
//			intent.setClass(MainActivity.this, MapsActivity.class);
//			MainActivity.this.startActivity(intent);
//		}
//
//    }
    
    class JingListener implements OnClickListener{

		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(MainActivity.this, lisvtiew.class);
			MainActivity.this.startActivity(intent);
		}
    	
    }
    
    
    class FoodListener implements OnClickListener{

		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(MainActivity.this, WebFood.class);
			MainActivity.this.startActivity(intent);
		}
    	
    }
 

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    public boolean onKeyDown(int keyCode, KeyEvent event) {  
        // TODO Auto-generated method stub  
  
        if (keyCode == KeyEvent.KEYCODE_BACK) {  
            AlertDialog.Builder builder = new AlertDialog.Builder(this);  
            builder.setMessage("确定退出？")  
                    .setCancelable(false)  
                    .setPositiveButton("确定",  
                            new DialogInterface.OnClickListener() {  
                                public void onClick(DialogInterface dialog,  
                                        int id) {  
                                    MainActivity.this.finish();  
                                    android.os.Process  
                                            .killProcess(android.os.Process  
                                                    .myPid());  
                                      android.os.Process.killProcess(android.os.Process.myTid());  
                                      android.os.Process.killProcess(android.os.Process.myUid());  
                                }  
                            })  
                    .setNegativeButton("返回",  
                            new DialogInterface.OnClickListener() {  
                                public void onClick(DialogInterface dialog,  
                                        int id) {  
                                    dialog.cancel();  
                                }  
                            });  
            AlertDialog alert = builder.create();  
            alert.show();  
            return true;  
        }  
  
        return super.onKeyDown(keyCode, event);  
    }  

    
}
