package com.travel_lover;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class UsActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_us);
        
        this.setTitle("关于我们");
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_us, menu);
        return true;
    }

    
}
