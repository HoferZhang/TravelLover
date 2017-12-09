package com.travel_lover;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends Activity {
    WebView mywebview;

    @SuppressLint("SetJavaScriptEnabled")
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        this.setTitle("团购信息..");
        requestWindowFeature(Window.FEATURE_PROGRESS);
        setContentView(R.layout.activity_web);
        mywebview=(WebView)findViewById(R.id.webView1);
        mywebview.getSettings().setJavaScriptEnabled(true);
        
        mywebview.setWebChromeClient(new WebChromeClient() {  
            public void onProgressChanged(WebView view, int progress) {   
                WebActivity.this.setProgress(progress * 100);  
            }  
          }); 
        
        mywebview.loadUrl("http://tuan.baidu.com/");
        
        mywebview.setWebViewClient(new WebViewClient(){  
            public boolean shouldOverrideUrlLoading(WebView view, String url) {  
                view.loadUrl(url);  
                return true;  
            }  
        });

    }
    public boolean onKeyDown(int keyCode,KeyEvent event){
    	if ((keyCode == KeyEvent.KEYCODE_BACK) && mywebview.canGoBack()){
    		mywebview.goBack();
    		return true;
    	}
    	if (keyCode == KeyEvent.KEYCODE_BACK) {  
            AlertDialog.Builder builder = new AlertDialog.Builder(this);  
            builder.setMessage("离开团购信息？")  
                    .setCancelable(false)  
                    .setPositiveButton("确定",  
                            new DialogInterface.OnClickListener() {  
                                public void onClick(DialogInterface dialog,  
                                        int id) {  
                                    WebActivity.this.finish();  
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

  
    	return false;
    }
    @Override  
    protected void onPause() {  
        // TODO Auto-generated method stub  
        super.onPause();  
    }  
    @Override  
    protected void onRestart() {  
        // TODO Auto-generated method stub  
        super.onRestart();  
        java.lang.System.out.println("onRestart");  
    }  
    @Override  
    protected void onResume() {  
        // TODO Auto-generated method stub  
        super.onResume();  
        java.lang.System.out.println("onResume");  
    }  
    @Override  
    protected void onStart() {  
        // TODO Auto-generated method stub  
        super.onStart();  
        java.lang.System.out.println("onStart");  
    }  
    @Override  
    protected void onStop() {  
        // TODO Auto-generated method stub  
        java.lang.System.out.println("onStop");  
        super.onStop();  
    }  


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_web, menu);
        return true;
    }
    }

    


