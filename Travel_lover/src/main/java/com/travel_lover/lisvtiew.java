package com.travel_lover;

import java.util.ArrayList;  
import java.util.HashMap;    
import android.app.Activity;  
import android.content.Intent;
import android.os.Bundle;  
import android.view.ContextMenu;  
import android.view.MenuItem;  
import android.view.View;  
import android.view.ContextMenu.ContextMenuInfo;  
import android.view.View.OnCreateContextMenuListener;  
import android.widget.AdapterView;  
import android.widget.ListView;  
import android.widget.SimpleAdapter;  
import android.widget.AdapterView.OnItemClickListener;  
  
public class lisvtiew extends Activity {  
    @Override  
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);
        this.setTitle("请选择城市..");
        setContentView(R.layout.main_lisvtiew);  
          
        ListView list = (ListView) findViewById(R.id.ListView01);  
          
        //生成动态数组，加入数据  
        ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();  
       
            HashMap<String, Object> map = new HashMap<String, Object>();  
            map.put("ItemImage", R.drawable.jinan);  
            map.put("ItemTitle", "           济南");  
            map.put("ItemText", "泉城，四面荷花三面柳 ，一城山色半城湖 ");  
            listItem.add(map);
            
            map = new HashMap<String, Object>();
            map.put("ItemImage", R.drawable.hangzhou);
            map.put("ItemTitle", "           杭州"); 
            map.put("ItemText", "历史著名七大古都之一，有“人间天堂”之誉");  
            listItem.add(map);
            
            map = new HashMap<String, Object>();
            map.put("ItemImage", R.drawable.chengdu);
            map.put("ItemTitle", "           成都"); 
            map.put("ItemText", "天府之国，锦绣之邦，又称芙蓉城");  
            listItem.add(map);
            
            map = new HashMap<String, Object>();
            map.put("ItemImage", R.drawable.guangzhou);
            map.put("ItemTitle", "           广州"); 
            map.put("ItemText", "食在广州。山明水秀，风光旖旎");  
            listItem.add(map);
            
            map = new HashMap<String, Object>();
            map.put("ItemImage", R.drawable.zhuhai);
            map.put("ItemTitle", "           珠海"); 
            map.put("ItemText", "百岛之市，被联合国评为中国最适合人类居住的地方");  
            listItem.add(map);
            
            map = new HashMap<String, Object>();
            map.put("ItemImage", R.drawable.lijiang);
            map.put("ItemTitle", "           丽江"); 
            map.put("ItemText", "“家家临溪，户户垂柳”，被誉为“东方威尼斯”、“高原姑苏”");  
            listItem.add(map);
            
            map = new HashMap<String, Object>();
            map.put("ItemImage", R.drawable.nanjing);
            map.put("ItemTitle", "           南京"); 
            map.put("ItemText", "六朝金粉地，金陵帝王州。十朝都会所在地，中国四大古都之一");  
            listItem.add(map);
            
            map = new HashMap<String, Object>();
            map.put("ItemImage", R.drawable.qingdao);
            map.put("ItemTitle", "           青岛"); 
            map.put("ItemText", "红瓦绿树，海天山城。国家历史文化名城，中国优秀旅游城市");  
            listItem.add(map);
            
            map = new HashMap<String, Object>();
            map.put("ItemImage", R.drawable.sanya);
            map.put("ItemTitle", "           三亚"); 
            map.put("ItemText", "美丽三亚、浪漫天涯。三亚是个被大自然宠坏了的地方。");  
            listItem.add(map);
            
            map = new HashMap<String, Object>();
            map.put("ItemImage", R.drawable.shanghai);
            map.put("ItemTitle", "           上海"); 
            map.put("ItemText", "又称“上海滩”。中国第一大城市，四大直辖市之一。");  
            listItem.add(map);
            
            map = new HashMap<String, Object>();
            map.put("ItemImage", R.drawable.xian);
            map.put("ItemTitle", "           西安"); 
            map.put("ItemText", "世界著名古都，丝绸之路起点，秦陵兵马俑所在地");  
            listItem.add(map);
            
            map = new HashMap<String, Object>();
            map.put("ItemImage", R.drawable.guilin);
            map.put("ItemTitle", "           桂林"); 
            map.put("ItemText", "水绕青山山绕水、山浮绿水水浮山");  
            listItem.add(map);
            
            map = new HashMap<String, Object>();
            map.put("ItemImage", R.drawable.dalian);
            map.put("ItemTitle", "           大连"); 
            map.put("ItemText", "东北亚商贸、金融、资讯、旅游的中心，素有“北方香港”的美誉。");  
            listItem.add(map);
            
            map = new HashMap<String, Object>();
            map.put("ItemImage", R.drawable.shenyang);
            map.put("ItemTitle", "           沈阳"); 
            map.put("ItemText", "古称盛京，国家环保模范城市、国家园林绿化城市、中国历史文化名城");  
            listItem.add(map);
            
            map = new HashMap<String, Object>();
            map.put("ItemImage", R.drawable.haerbin);
            map.put("ItemTitle", "           哈尔滨"); 
            map.put("ItemText", "素有“东方小巴黎”、“东方莫斯科”的美名，历史一座从来没有城墙的城市");  
            listItem.add(map);
            
            
            
            
            
            
         
        //生成适配器的Item和动态数组对应的元素  
        SimpleAdapter listItemAdapter = new SimpleAdapter(this,listItem,//数据源   
            R.layout.visit,//ListItem的XML实现  
            //动态数组与ImageItem对应的子项          
            new String[] {"ItemImage","ItemTitle", "ItemText"},   
            //ImageItem的XML文件里面的一个ImageView,两个TextView ID  
            new int[] {R.id.ItemImage,R.id.ItemTitle,R.id.ItemText}  
        );  
         
        //添加并且显示  
        list.setAdapter(listItemAdapter);  
          
        //添加点击  
        list.setOnItemClickListener(new OnItemClickListener() {  
  
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,  
                    long arg3) {  
            	
            	switch (arg2){
            	
            	case 0:
            		Intent intent = new Intent();
        			intent.setClass(lisvtiew.this, JinanActivity.class);
        			lisvtiew.this.startActivity(intent); 
            	
            	}
            	
            }  
        });  
          
      //添加长按点击  
        list.setOnCreateContextMenuListener(new OnCreateContextMenuListener() {  
              
            public void onCreateContextMenu(ContextMenu menu, View v,ContextMenuInfo menuInfo) {  
                menu.setHeaderTitle("长按菜单-ContextMenu");     
                menu.add(0, 0, 0, "弹出长按菜单0");  
                menu.add(0, 1, 0, "弹出长按菜单1");     
            }  
        });   
    }  
      
    //长按菜单响应函数  
    @Override  
    public boolean onContextItemSelected(MenuItem item) {  
        setTitle("点击了长按菜单里面的第"+item.getItemId()+"个项目");   
        return super.onContextItemSelected(item);  
    }  
}  
