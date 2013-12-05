package com.example.jitbrocast;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		BroadCastDataSource broadCastDataSource = new BroadCastDataSource(this);
		broadCastDataSource.open();
		if(broadCastDataSource.getAllData()){
			Intent intent = new Intent(this, CreateAccount.class);
			startActivity(intent);
		}else{
			setContentView(R.layout.activity_main);
		}
		broadCastDataSource.close();
	}

	public void createAccount(View view){
		Intent intent = new Intent(this, CreateAccount.class);
		startActivity(intent);
	}
	
	public void userLogin(View view){
		
		Intent intent = new Intent(this, UserLogin.class);
		startActivity(intent);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
