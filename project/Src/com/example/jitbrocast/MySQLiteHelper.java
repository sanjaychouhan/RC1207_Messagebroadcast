package com.example.jitbrocast;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteHelper extends SQLiteOpenHelper {
	
	 private static final String DATABASE_NAME = "JIT_BRODCAST";
	  private static final int DATABASE_VERSION= 3;

	  
	  public static final String TABLE_NAME = "USER_DETAIL";
	  public static final String COLUMN_USER_ID="USER_ID";
	  public static final String COLUMN_USER_NUMBER="USER_NUMBER";
	  
	  private static final String sql = "create table " + TABLE_NAME 
				+ "(" + COLUMN_USER_ID + " integer primary key autoincrement,"+
				COLUMN_USER_NUMBER + " text not null)";
	public MySQLiteHelper(Context context) {
		super(context,DATABASE_NAME , null,DATABASE_VERSION );
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase database) {
		// TODO Auto-generated method stub
		database.execSQL(sql);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		database.execSQL("DROP TABLE IF EXISTS" + MySQLiteHelper.TABLE_NAME);
		onCreate(database);
	}

}
