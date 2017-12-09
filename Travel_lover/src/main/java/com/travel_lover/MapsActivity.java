package com.travel_lover;

import java.util.List;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.google.android.gms.maps.MapActivity;
import com.google.android.gms.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;





public class MapsActivity extends MapActivity {  
    
    private MapController mapController;  
    private MapView mapView;  
    private MyOverLay myOverLay; 

	
       
    @SuppressWarnings("deprecation")
	@Override  
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_maps);  
         
        LocationManager locationManager=(LocationManager) getSystemService(Context.LOCATION_SERVICE);  
        mapView=(MapView) this.findViewById(R.id.mapViewId);  
        //设置交通模式  
        mapView.setTraffic(true);  
        //设置卫星模式  
        mapView.setSatellite(false);  
        //设置街景模式  
        mapView.setStreetView(false);  
        //设置缩放控制  
        mapView.setBuiltInZoomControls(true);  
        mapView.setClickable(true);  
        mapView.setEnabled(true);  
        //得到MapController实例   
        mapController=mapView.getController();  
        mapController.setZoom(15);  
          
        myOverLay=new MyOverLay();  
        List<Overlay> overLays=mapView.getOverlays();  
        overLays.add(myOverLay); 
        
          
        Criteria criteria=new Criteria();  
        criteria.setAccuracy(Criteria.ACCURACY_FINE);  
        criteria.setAltitudeRequired(false);  
        criteria.setBearingRequired(false);  
        criteria.setCostAllowed(false);  
        criteria.setPowerRequirement(Criteria.POWER_LOW);  
        //取得效果最好的Criteria  
        String provider=locationManager.getBestProvider(criteria, true);  
        //得到Location  
        Location location=locationManager.getLastKnownLocation(provider);  
        updateWithLocation(location);  
        //注册一个周期性的更新，3秒一次  
        locationManager.requestLocationUpdates(provider, 3000, 500, locationListener);  
          
    }  
    @Override  
    public boolean onCreateOptionsMenu(Menu menu) {  
        // TODO Auto-generated method stub  
    	//menu.add(0,Menu.FIRST,0,"查找城市").setIcon(R.drawable.sousuo);
        //menu.add(0,Menu.FIRST+1,1,"城市列表").setIcon(R.drawable.xuanzechengshi);
        menu.add(0,Menu.FIRST,0,"地图模式").setIcon(R.drawable.ditumoshi);      
        menu.add(0,Menu.FIRST+1,1,"返回").setIcon(R.drawable.tuichuditu);
          
        return super.onCreateOptionsMenu(menu);  
    }  
	@Override  
    public boolean onOptionsItemSelected(MenuItem item) {  
        // TODO Auto-generated method stub  
         super.onOptionsItemSelected(item);  
         switch (item.getItemId()) {  
        /*case 1://查找
            break;  
        case 2://城市列表
            break;  */
        case 1://地图模式
        	selectViewMode();
        	break;
        case 2:  
        	finish();
            break;  
        }  
        return true;  
    }  
    private void updateWithLocation(Location location){  
        if(location!=null){  
            //为绘制类设置坐标  
            myOverLay.setLocation(location);  
            GeoPoint geoPoint=new GeoPoint((int)(location.getLatitude()*1E6), (int)(location.getLongitude()*1E6));  
            //定位到指定的坐标  
            mapController.animateTo(geoPoint);  
            mapController.setZoom(15); 
        }
    }  
	private final LocationListener locationListener=new LocationListener() {  
          
        public void onStatusChanged(String provider, int status, Bundle extras) {  
            // TODO Auto-generated method stub  
              
        }  
          
        public void onProviderEnabled(String provider) {  
            // TODO Auto-generated method stub  
              
        }  
          
        public void onProviderDisabled(String provider) {  
            // TODO Auto-generated method stub   
        	Toast.makeText(MapsActivity.this, "请打开GPS服务", Toast.LENGTH_LONG).show();
              
        }  
        //当坐标改变时出发此函数  
        public void onLocationChanged(Location location) {  
            // TODO Auto-generated method stub  
            updateWithLocation(location);  
        }  
    };  
    class MyOverLay extends Overlay{  
          
        private Location location;  
        public void setLocation(Location location){  
            this.location=location;  
        }  
        
          
        
        @Override  
        public boolean draw(Canvas canvas, MapView mapView, boolean shadow,  
                long when) { 
            // TODO Auto-generated method stub  
            super.draw(canvas, mapView, shadow);  
            Paint paint=new Paint();  
            Point myScreen=new Point();
            if(location!=null){
            //将经纬度换成实际屏幕的坐标。  
            GeoPoint geoPoint=new GeoPoint((int)(location.getLatitude()*1E6), (int)(location.getLongitude()*1E6));  
            mapView.getProjection().toPixels(geoPoint, myScreen);  
            paint.setStrokeWidth(1);  
            paint.setARGB(255, 255, 0, 0);  
            paint.setStyle(Paint.Style.STROKE);  
            Bitmap bmp=BitmapFactory.decodeResource(getResources(), R.drawable.location);  
            //把这张图片画到相应的位置。  
            canvas.drawBitmap(bmp, myScreen.x, myScreen.y,paint);  
            canvas.drawText("我的位置", myScreen.x, myScreen.y, paint);  
            return true;  
            }
            else{
            	Toast.makeText(MapsActivity.this, "正在进行定位，请稍后", Toast.LENGTH_LONG).show();
            	return true;
            }
              
        }  
    }  
    @Override  
    protected boolean isRouteDisplayed() {  
        // TODO Auto-generated method stub  
        return false;  
    }  
    public boolean onKeyDown(int keyCode, KeyEvent event) {  
        // TODO Auto-generated method stub  
  
        if (keyCode == KeyEvent.KEYCODE_BACK) {  
            MapsActivity.this.finish();  
            android.os.Process  
                    .killProcess(android.os.Process  
                            .myPid());  
              android.os.Process.killProcess(android.os.Process.myTid());  
              android.os.Process.killProcess(android.os.Process.myUid());  
                                }                            
        return super.onKeyDown(keyCode, event);  
    }  
    //选择地图模式
    public void selectViewMode()
    {
	    android.content.DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which)
			{
				switch ( which )
				{
		        case 0://交通模式  
		            mapView.setTraffic(true);  
		            mapView.setSatellite(false);  
		            mapView.setStreetView(false);  
		            break;  
		        case 1://卫星模式  
		            mapView.setSatellite(true);  
		            mapView.setStreetView(false);  
		            mapView.setTraffic(false);  
		            break;  
		        case 2://街景模式  
		            mapView.setStreetView(true);  
		            mapView.setTraffic(false);  
		            mapView.setSatellite(false);  
		            break;  
		        default:  
		            mapView.setTraffic(true);  
		            mapView.setSatellite(false);  
		            mapView.setStreetView(false);  
		            break;  				
				}
		        
			}
	    };
	    
	    String[] menu={"交通流量","卫星地图","街景模式"};	
	    new AlertDialog.Builder(MapsActivity.this)
        .setTitle("请选择地图模式")
        .setItems(menu, listener)
        .setIcon(R.drawable.xuanze)
        .show();
    }
}
