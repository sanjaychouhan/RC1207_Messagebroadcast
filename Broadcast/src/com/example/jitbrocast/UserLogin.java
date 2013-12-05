package com.example.jitbrocast;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class UserLogin extends Activity {
	EditText number;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.userlogin);
		number = (EditText) findViewById(R.id.mblnumber);
	}
    
	public void userLogin (View view){
		
		//String mblnum = number.getText().toString();
		
		//if()
		
	}
}
