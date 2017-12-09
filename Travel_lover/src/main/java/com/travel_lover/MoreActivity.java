package com.travel_lover;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MoreActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);
        
        this.setTitle("¸ü¶à...");
        
        Button button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(new UsListener());
        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new LogListener());
        
    }
    
    class LogListener implements OnClickListener{

		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(MoreActivity.this, Load.class);
			MoreActivity.this.startActivity(intent);
		}
	}
    
    class UsListener implements OnClickListener{

		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(MoreActivity.this, UsActivity.class);
			MoreActivity.this.startActivity(intent);
		}
	}

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_more, menu);
        return true;
    }
}

    

