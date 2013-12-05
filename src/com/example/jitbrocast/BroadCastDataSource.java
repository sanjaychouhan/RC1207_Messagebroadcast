package com.example.jitbrocast;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class BroadCastDataSource {
	
	private MySQLiteHelper  helper;
	private SQLiteDatabase database;
	
	public BroadCastDataSource(Context context) {
		super();
		helper = new MySQLiteHelper(context);
	}
	
	public void open(){
		database = helper.getWritableDatabase();
	}
	
	public void close(){
		database.close();
	}
	
	public boolean getAllData(){
		String sql = "select * from " + MySQLiteHelper.TABLE_NAME;
		Cursor cursor = database.rawQuery(sql, null);
		if(cursor.getCount() != 0){
			return true;
		}
		
		return false;
		
	}
	
	
	public void registerUser(String mobile){
		ContentValues contentValues = new ContentValues();
		contentValues.put(MySQLiteHelper.COLUMN_USER_NUMBER, mobile);
		database.insert(MySQLiteHelper.TABLE_NAME, null, contentValues);
	}
	
	

}
