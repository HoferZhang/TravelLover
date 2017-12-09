package com.travel_lover;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Window;
import android.view.WindowManager;

public class Travel_lover extends Activity {  
    
    protected static final String TAG = "WelcomeAct";  
      
    private Handler handler; //因为要重写构造方法，所以不能用匿名内部类  
      
    @Override  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState); 
        
        this.setTitle("伴旅");
        // 设置登录无标题栏  
        requestWindowFeature(Window.FEATURE_NO_TITLE); 
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,  
        WindowManager.LayoutParams.FLAG_FULLSCREEN); 
        setContentView(R.layout.activity_logo);  
  
        HandlerThread myThread = new HandlerThread("myHandlerThread");  
        myThread.start();  
        handler = new myHandler(myThread.getLooper());  
        handler.post(new Runnable() {  
            public void run() {  
                try {  
                    //耗时的操作  
                    Thread.sleep(4000);  
                    //handler主要用于异步消息的处理,使用sendMessage()后，方法立即返回，Message放入消息队列，  
                    //等待Message出消息队列，由handlerMessage(Message msg)通知UI线程子线程已经挂起，并使用返回的msg。  
                    handler.sendMessage(handler.obtainMessage());  
                } catch (InterruptedException e) {  
                    e.printStackTrace();  
                }  
            }  
        });  
    }  
      
    class myHandler extends Handler{  
          
        public myHandler(Looper looper) {  
            super(looper);  
        }  
  
        //负责从消息队列中取消息给UI线程  
        @SuppressLint("HandlerLeak")
		@Override  
        public void handleMessage(Message msg) {  
            super.handleMessage(msg);  
            Intent intent = new Intent(Travel_lover.this, chooseYY.class);  
            startActivity(intent);  
            finish();
        }  
    }  
}  