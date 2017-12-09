package com.travel_lover;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;




public class DB {

	public static final String KEY_NAME="name";
	public static final String KEY_PWD="pwd";
	
	private Context mctx;
	private DatabaseHelper dbHelper;
	private SQLiteDatabase db;
	
	//Constructor
	public DB(Context mctx){
		this.mctx=mctx;
	}
	public void open() {
		dbHelper=new DatabaseHelper(mctx);
	try{
		db=dbHelper.getWritableDatabase();
	}
	catch(SQLiteException e){
		db=dbHelper.getReadableDatabase();
	}
	}
	
	
	private static class DatabaseHelper extends SQLiteOpenHelper{
		private static final String DATABASE_NAME="load";
		private static final int DATABASE_VERSION=1;//版本号
		
		static final String DATABASE_TABLE="user";
		
		private static final String DATABASE_CREATE =
			"CREATE TABLE user ("+
			"name VARCHAR(20)PRIMARY KEY,"+
			"pwd VARCHAR(20)"+
			");" ;
			/*由于simpleCursorAdapter的方法只识别_id，所以，
			 * 用到sqlite的simpleCursorAdapter时，必须把数据表的主键命名为_id。*/
		public DatabaseHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
			// TODO Auto-generated constructor stub
		}
		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			db.execSQL(DATABASE_CREATE);
				}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			db.execSQL("DROP TABLE IF EXISTS "+DATABASE_TABLE);
			onCreate(db);
		}
	}
	
	public long adduser(String name,String pwd){
    	ContentValues args=new ContentValues();
    	args.put(KEY_NAME,name);
    	args.put(KEY_PWD,pwd);
    	return db.insert(DatabaseHelper.DATABASE_TABLE, null, args);
    }
	
	public boolean update(String name, String pwd) {
        ContentValues args = new ContentValues();
        args.put(KEY_PWD, pwd);
        return db.update(DatabaseHelper.DATABASE_TABLE, args, "name=?", new String[]{name}) > 0;
    }
	public Cursor checkUser(String name,String pwd){
		Cursor mCursor=(SQLiteCursor) db.query(true, DatabaseHelper.DATABASE_TABLE,
				new String[]{KEY_NAME}, 
				"name=? and pwd=?",
				new String[]{name,pwd}, null, null, null, null);
		
		return mCursor;
		
	}
	public boolean delete(String name){
		return db.delete(DatabaseHelper.DATABASE_TABLE, "name=?", new String[]{name})>0;
	}
}
