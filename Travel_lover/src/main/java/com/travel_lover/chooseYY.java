package com.travel_lover;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;

public class chooseYY extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_choose_yy);
        Button button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(new yyListener());
    }

    
    class yyListener implements OnClickListener{

		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(chooseYY.this, MainActivity.class);
			chooseYY.this.startActivity(intent);
			finish();
		}
    	
    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {  
        // TODO Auto-generated method stub  
  
        if (keyCode == KeyEvent.KEYCODE_BACK) {  
            AlertDialog.Builder builder = new AlertDialog.Builder(this);  
            builder.setMessage("你确定退出吗？")  
                    .setCancelable(false)  
                    .setPositiveButton("确定",  
                            new DialogInterface.OnClickListener() {  
                                public void onClick(DialogInterface dialog,  
                                        int id) {  
                                    chooseYY.this.finish();  
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