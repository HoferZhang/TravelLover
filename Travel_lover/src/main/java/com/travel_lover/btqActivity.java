package com.travel_lover;


import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.nhnst.popcorn.layers.CCScene;
import com.nhnst.popcorn.nodes.CCDirector;
import com.nhnst.popcorn.opengl.CCGLSurfaceView;
import com.nhnst.popcorn.opengl.CCTexture2D;

public class btqActivity extends Activity {
	private CCGLSurfaceView mGLSurfaceView;
	LinearLayout layout;
	int i = 0;
	public double x1;
	public double y1;
	MapLayer mapLayer;

	public enum MODE {
		NONE, DRAG, ZOOM, BIGGER, SMALLER
	}

	;

	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.KEYCODE_BACK) {


		}

		return false;
//		return super.onKeyUp(keyCode, event);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		// set the window status, no tile, full screen and don't sleep
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,
				WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

		super.onCreate(savedInstanceState);
		LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
			// TODO: Consider calling
			//    Activity#requestPermissions
			// here to request the missing permissions, and then overriding
			//   public void onRequestPermissionsResult(int requestCode, String[] permissions,
			//                                          int[] grantResults)
			// to handle the case where the user grants the permission. See the documentation
			// for Activity#requestPermissions for more details.
			return;
		}
		if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
			// TODO: Consider calling
			//    Activity#requestPermissions
			// here to request the missing permissions, and then overriding
			//   public void onRequestPermissionsResult(int requestCode, String[] permissions,
			//                                          int[] grantResults)
			// to handle the case where the user grants the permission. See the documentation
			// for Activity#requestPermissions for more details.
			return;
		}
		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, new TestLocationListener());
	}
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		
        mGLSurfaceView = new CCGLSurfaceView(this);
        
        setContentView(R.layout.view);
        //�󶨶�Ӧ��Layout�е�layout1����ͼ
        layout = (LinearLayout)this.findViewById(R.id.layout1);
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams( 
        		LinearLayout.LayoutParams.WRAP_CONTENT, 
        		LinearLayout.LayoutParams.WRAP_CONTENT 
        		);         
     
        layout.addView(mGLSurfaceView, p);
        // attach the OpenGL view to a window
        CCDirector.sharedDirector().attachInView(mGLSurfaceView);

		// Sets Portrait mode
        CCDirector.sharedDirector().setDeviceOrientation(CCDirector.kCCDeviceOrientationPortrait);
		CCTexture2D.setDefaultAlphaPixelFormat(Bitmap.Config.ARGB_8888);
//		CCDirector.sharedDirector().setScreenSize(this.getWindowManager().getDefaultDisplay().getWidth(), this.getWindowManager().getDefaultDisplay().getHeight());
		Log.d("DEBUG","width = "+this.getWindowManager().getDefaultDisplay().getWidth());
		//������ʾ��ͼ�����С��layout1�Ĵ�С��layout1�ĳ������ͼ���峤�������ͬ���ɡ�������你
	
		Integer directW=480;
		Integer directH=800;
		CCDirector.sharedDirector().setScreenSize(directW, directH);

        // show FPS
        // set false to disable FPS display, but don't delete fps_images.png!!
        // CCDirector.sharedDirector().setDisplayFPS(true);

        // frames per second
        CCDirector.sharedDirector().setAnimationInterval(1.0f / 60);

        CCScene scene = CCScene.node();
        layout = (LinearLayout)this.findViewById(R.id.layout1);
//        TemplateLayer layer = new TemplateLayer(layout.getWidth(),layout.getHeight());
        //���ò��С����CCDirector��С��ͬ���ɡ�
        mapLayer = new MapLayer(directW,directH,"test.png");
         /*!!!!!!!!!!!!!!!!!*/     
        //TODO:���þ�γ�ȱ���
        mapLayer.setRate(-0.00000249804, 0.0000039382);
        //TODO:���òο����λ��
        mapLayer.setReferencePoint(36.668273, 117.022848, 635, 582);
        scene.addChild(mapLayer);
        // Make the Scene active
        CCDirector.sharedDirector().runWithScene(scene);
	}

    public class TestLocationListener implements LocationListener{

		public void onLocationChanged(Location location) {
			// TODO Auto-generated method stub
			  x1 = (float) location.getLatitude();//����
			  y1 = (float) location.getLongitude();//γ��
			  mapLayer.setCurrentPosition(x1,y1);
		}

		public void onProviderDisabled(String arg0) {
			// TODO Auto-generated method stub
			
		}

		public void onProviderEnabled(Location location) {
			// TODO Auto-generated method stub

			
		}

		public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
			// TODO Auto-generated method stub
			
		}

		public void onProviderEnabled(String arg0) {
			// TODO Auto-generated method stub
			DisplayToast("������GPS�豸");
		}
    }
	public void DisplayToast(String str){
		Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
	}
	
	   public boolean onKeyDown(int keyCode, KeyEvent event) {  
	        // TODO Auto-generated method stub  
	  
	        if (keyCode == KeyEvent.KEYCODE_BACK) {  
	            btqActivity.this.finish();  
	            android.os.Process  
	                    .killProcess(android.os.Process  
	                            .myPid());  
	              android.os.Process.killProcess(android.os.Process.myTid());  
	              android.os.Process.killProcess(android.os.Process.myUid());  
	                                }                            
	        return super.onKeyDown(keyCode, event);  
	    }  
}
