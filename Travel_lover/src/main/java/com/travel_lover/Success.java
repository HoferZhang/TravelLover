package com.travel_lover;

import com.travel_lover.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Success extends Activity{
	private TextView user_name;
	protected static final int MENU_DELETE=Menu.FIRST;
	protected static final int MENU_CHANGEPWD=Menu.FIRST+1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.show);
		findviews();
		showMsg();
	}

	private void showMsg() {
		// TODO Auto-generated method stub
		Bundle bundle=this.getIntent().getExtras();
		user_name.setText(bundle.getString("KEY_NAME"));
	}

	private void findviews() {
		// TODO Auto-generated method stub
		user_name=(TextView)findViewById(R.id.user);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
    	 super.onCreateOptionsMenu(menu);
    	menu.add(0,MENU_DELETE,0,"É¾³ý");
    	menu.add(0,MENU_CHANGEPWD,0,"ÐÞ¸ÄÃÜÂë");
    	return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()){
		case MENU_DELETE:
			DB db=new DB(this);
		        db.open();
			if(db.delete(user_name.getText().toString())){
				setResult(RESULT_OK);
				finish();
			}
			break;
		case MENU_CHANGEPWD: 
			Intent intent=new Intent();
			Bundle bundle=new Bundle();
			bundle.putString("KEY_NAME",user_name.getText().toString());
			intent.setClass(Success.this, ChangePwd.class);
			intent.putExtras(bundle);
			startActivity(intent);
			break;
		
		}
		return super.onOptionsItemSelected(item);
	}
}
