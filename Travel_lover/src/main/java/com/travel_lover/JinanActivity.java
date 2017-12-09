package com.travel_lover;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context; 
import android.content.Intent;
import android.view.View; 
import android.view.ViewGroup; 
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter; 
import android.widget.Gallery; 
import android.widget.ImageView; 
 
     public class JinanActivity extends Activity {  
            @Override 
            public void onCreate(Bundle savedInstanceState) { 
                   super.onCreate(savedInstanceState); 
     
                   setContentView(R.layout.activity_jinan);
                   Gallery g =(Gallery) findViewById(R.id.myGallery1);
                   g.setAdapter(new ImageAdapter(this)); 
                   
                   g.setOnItemClickListener(new OnItemClickListener(){
                	   public void onItemClick(AdapterView<?> parent,View v,int position,long id)
                	   {
                		   Intent intent = new Intent(JinanActivity.this,btqActivity.class);
               			   startActivity(intent);
                	   }
                   });
             } 

        	
            public class ImageAdapter extends BaseAdapter {  
                   private Context myContext; 
                   private int[] myImageIds = { R.drawable.baotuquan, R.drawable.baimaiquan, 
                                 R.drawable.daminghu, R.drawable.furongjie, R.drawable.hongyegu, 
                                 R.drawable.jiurushan,R.drawable.lingyansi, R.drawable.paomaling, 
                                 R.drawable.qianfoshan, R.drawable.quanchengguangchang, 
                                 R.drawable.shuilianxia, R.drawable.wufengshan,R.drawable.wulongtan,
                                 R.drawable.zhenzhuquan}; 
  
                   public ImageAdapter(Context c) { 
                       this.myContext = c; 
                   } 
 
                    /* 返回所有已定义的图片总数量 */ 
                   public int getCount() { 
                       return this.myImageIds.length; 
                   } 
 
                   /* 利用getItem方法，取得目前容器中图像的数组ID */ 
                   public Object getItem(int position) { 
                       return position; 
                   } 
 
                   public long getItemId(int position) { 
                       return position; 
                   } 
 
                   /* 取得目前欲显示的图像View，传入数组ID值使之读取与成像 */ 
                   public View getView(int position, View convertView, ViewGroup parent) { 
                       /* 创建一个ImageView对象 */ 
                       ImageView i = new ImageView(this.myContext); 
                       i.setImageResource(this.myImageIds[position]); 
                       i.setScaleType(ImageView.ScaleType.FIT_XY); 
 
                       /* 设置这个ImageView对象的宽高，单位为dip */ 
                       i.setLayoutParams(new Gallery.LayoutParams(480, 740)); 
                       return i; 
                   }   
 
                   /* 依据距离中央的位移量 利用getScale返回views的大小(0.0f to 1.0f) */ 
                   public float getScale(boolean focused, int offset) { 
                       return Math.max(0, 1.0f / (float) Math.pow(2, Math.abs(offset))); 
                   } 
         } 
}
