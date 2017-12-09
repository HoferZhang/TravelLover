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
        this.setTitle("��ѡ�����..");
        setContentView(R.layout.main_lisvtiew);  
          
        ListView list = (ListView) findViewById(R.id.ListView01);  
          
        //���ɶ�̬���飬��������  
        ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();  
       
            HashMap<String, Object> map = new HashMap<String, Object>();  
            map.put("ItemImage", R.drawable.jinan);  
            map.put("ItemTitle", "           ����");  
            map.put("ItemText", "Ȫ�ǣ�����ɻ������� ��һ��ɽɫ��Ǻ� ");  
            listItem.add(map);
            
            map = new HashMap<String, Object>();
            map.put("ItemImage", R.drawable.hangzhou);
            map.put("ItemTitle", "           ����"); 
            map.put("ItemText", "��ʷ�����ߴ�Ŷ�֮һ���С��˼����á�֮��");  
            listItem.add(map);
            
            map = new HashMap<String, Object>();
            map.put("ItemImage", R.drawable.chengdu);
            map.put("ItemTitle", "           �ɶ�"); 
            map.put("ItemText", "�츮֮��������֮��ֳ�ܽ�س�");  
            listItem.add(map);
            
            map = new HashMap<String, Object>();
            map.put("ItemImage", R.drawable.guangzhou);
            map.put("ItemTitle", "           ����"); 
            map.put("ItemText", "ʳ�ڹ��ݡ�ɽ��ˮ�㣬�����");  
            listItem.add(map);
            
            map = new HashMap<String, Object>();
            map.put("ItemImage", R.drawable.zhuhai);
            map.put("ItemTitle", "           �麣"); 
            map.put("ItemText", "�ٵ�֮�У������Ϲ���Ϊ�й����ʺ������ס�ĵط�");  
            listItem.add(map);
            
            map = new HashMap<String, Object>();
            map.put("ItemImage", R.drawable.lijiang);
            map.put("ItemTitle", "           ����"); 
            map.put("ItemText", "���Ҽ���Ϫ������������������Ϊ����������˹��������ԭ���ա�");  
            listItem.add(map);
            
            map = new HashMap<String, Object>();
            map.put("ItemImage", R.drawable.nanjing);
            map.put("ItemTitle", "           �Ͼ�"); 
            map.put("ItemText", "������۵أ���������ݡ�ʮ���������ڵأ��й��Ĵ�Ŷ�֮һ");  
            listItem.add(map);
            
            map = new HashMap<String, Object>();
            map.put("ItemImage", R.drawable.qingdao);
            map.put("ItemTitle", "           �ൺ"); 
            map.put("ItemText", "��������������ɽ�ǡ�������ʷ�Ļ����ǣ��й��������γ���");  
            listItem.add(map);
            
            map = new HashMap<String, Object>();
            map.put("ItemImage", R.drawable.sanya);
            map.put("ItemTitle", "           ����"); 
            map.put("ItemText", "�������ǡ��������ġ������Ǹ�������Ȼ�軵�˵ĵط���");  
            listItem.add(map);
            
            map = new HashMap<String, Object>();
            map.put("ItemImage", R.drawable.shanghai);
            map.put("ItemTitle", "           �Ϻ�"); 
            map.put("ItemText", "�ֳơ��Ϻ�̲�����й���һ����У��Ĵ�ֱϽ��֮һ��");  
            listItem.add(map);
            
            map = new HashMap<String, Object>();
            map.put("ItemImage", R.drawable.xian);
            map.put("ItemTitle", "           ����"); 
            map.put("ItemText", "���������Ŷ���˿��֮·��㣬�������ٸ���ڵ�");  
            listItem.add(map);
            
            map = new HashMap<String, Object>();
            map.put("ItemImage", R.drawable.guilin);
            map.put("ItemTitle", "           ����"); 
            map.put("ItemText", "ˮ����ɽɽ��ˮ��ɽ����ˮˮ��ɽ");  
            listItem.add(map);
            
            map = new HashMap<String, Object>();
            map.put("ItemImage", R.drawable.dalian);
            map.put("ItemTitle", "           ����"); 
            map.put("ItemText", "��������ó�����ڡ���Ѷ�����ε����ģ����С�������ۡ���������");  
            listItem.add(map);
            
            map = new HashMap<String, Object>();
            map.put("ItemImage", R.drawable.shenyang);
            map.put("ItemTitle", "           ����"); 
            map.put("ItemText", "�ų�ʢ�������һ���ģ�����С�����԰���̻����С��й���ʷ�Ļ�����");  
            listItem.add(map);
            
            map = new HashMap<String, Object>();
            map.put("ItemImage", R.drawable.haerbin);
            map.put("ItemTitle", "           ������"); 
            map.put("ItemText", "���С�����С���衱��������Ī˹�ơ�����������ʷһ������û�г�ǽ�ĳ���");  
            listItem.add(map);
            
            
            
            
            
            
         
        //������������Item�Ͷ�̬�����Ӧ��Ԫ��  
        SimpleAdapter listItemAdapter = new SimpleAdapter(this,listItem,//����Դ   
            R.layout.visit,//ListItem��XMLʵ��  
            //��̬������ImageItem��Ӧ������          
            new String[] {"ItemImage","ItemTitle", "ItemText"},   
            //ImageItem��XML�ļ������һ��ImageView,����TextView ID  
            new int[] {R.id.ItemImage,R.id.ItemTitle,R.id.ItemText}  
        );  
         
        //��Ӳ�����ʾ  
        list.setAdapter(listItemAdapter);  
          
        //��ӵ��  
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
          
      //��ӳ������  
        list.setOnCreateContextMenuListener(new OnCreateContextMenuListener() {  
              
            public void onCreateContextMenu(ContextMenu menu, View v,ContextMenuInfo menuInfo) {  
                menu.setHeaderTitle("�����˵�-ContextMenu");     
                menu.add(0, 0, 0, "���������˵�0");  
                menu.add(0, 1, 0, "���������˵�1");     
            }  
        });   
    }  
      
    //�����˵���Ӧ����  
    @Override  
    public boolean onContextItemSelected(MenuItem item) {  
        setTitle("����˳����˵�����ĵ�"+item.getItemId()+"����Ŀ");   
        return super.onContextItemSelected(item);  
    }  
}  
