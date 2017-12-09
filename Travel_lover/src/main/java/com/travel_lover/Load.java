package com.travel_lover;


import com.travel_lover.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Load extends Activity {
	private Button button_load;
	private Button button_regist;
	private EditText user_name;
	private EditText user_pwd;
	private Button button_exit;
	private DB db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        db=new DB(this);
        db.open();
        findViews();
        setListeners();
    }

	private void findViews() {
		// TODO Auto-generated method stub
		button_load=(Button)findViewById(R.id.ld);
		button_regist=(Button)findViewById(R.id.reg);
		button_exit=(Button)findViewById(R.id.exit);
		user_name=((EditText)findViewById(R.id.name));
		user_pwd=((EditText)findViewById(R.id.password));
		
	}
	
	private void setListeners() {
		// TODO Auto-generated method stub
		button_exit.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
			new AlertDialog.Builder(Load.this).setMessage("�Ƿ�Ҫ���ظ������ã�")
				.setPositiveButton("yes", new DialogInterface.OnClickListener() {
					
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						finish();
					}
				})
				.setNegativeButton("no", new DialogInterface.OnClickListener() {
					
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						
					}
				}).show();
			}
		});
		button_load.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				//��¼��֤你好
				if(db.checkUser(user_name.getText().toString(),user_pwd.getText().toString()).moveToNext()){
				Intent intent=new Intent();
				Bundle bundle=new Bundle();
				bundle.putString("KEY_NAME",user_name.getText().toString());
				intent.setClass(Load.this, Success.class);
				intent.putExtras(bundle);
				startActivity(intent);
				}
				else{
					new AlertDialog.Builder(Load.this).setMessage("�û������ڻ����벻��ȷ")
					.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
						
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							user_name.setText("");
							user_pwd.setText("");
							user_name.requestFocus();
						}
					}).show();
				}
			}
		});
		
		button_regist.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				//ע��
				if(db.adduser(user_name.getText().toString(), user_pwd.getText().toString())!=-1)
				{
					new AlertDialog.Builder(Load.this).setMessage("ע��ɹ�")
					.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
						
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							Intent intent=new Intent();
							Bundle bundle=new Bundle();
							bundle.putString("KEY_NAME",user_name.getText().toString());
							intent.setClass(Load.this, Success.class);
							intent.putExtras(bundle);
							startActivity(intent);
						}
					}).show();
				}
				else{
					new AlertDialog.Builder(Load.this).setMessage("�û�����ռ��")
					.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
						
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							user_name.setText("");
							user_pwd.setText("");
							user_name.requestFocus();
						}
					}).show();
				}
				
			}
		});
	}
	
}