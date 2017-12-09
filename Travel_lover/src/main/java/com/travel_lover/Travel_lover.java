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
      
    private Handler handler; //��ΪҪ��д���췽�������Բ����������ڲ���  
      
    @Override  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState); 
        
        this.setTitle("����");
        // ���õ�¼�ޱ�����  
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
                    //��ʱ�Ĳ���  
                    Thread.sleep(4000);  
                    //handler��Ҫ�����첽��Ϣ�Ĵ���,ʹ��sendMessage()�󣬷����������أ�Message������Ϣ���У�  
                    //�ȴ�Message����Ϣ���У���handlerMessage(Message msg)֪ͨUI�߳����߳��Ѿ����𣬲�ʹ�÷��ص�msg��  
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
  
        //�������Ϣ������ȡ��Ϣ��UI�߳�  
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