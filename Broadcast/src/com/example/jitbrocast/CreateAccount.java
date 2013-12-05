package com.example.jitbrocast;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class CreateAccount extends Activity {

	ProgressDialog dialog;
	EditText name, mobile, email;
	OpenUrlGetResponse getResponse;
	JSONObject response;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.createaccount);
		name = (EditText) findViewById(R.id.name);
		mobile = (EditText) findViewById(R.id.mobile);
		email = (EditText) findViewById(R.id.email);
	}
	
	public void createAccount(View view){
		new Registration().execute();
		
	}
	
	public class Registration extends AsyncTask<Void, Void, Void>{

		private String url = "http://jitbroadcast.comuf.com/registration.php";
		//private String message;
		List<NameValuePair> list = new ArrayList<NameValuePair>();
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			dialog = new ProgressDialog(CreateAccount.this);
			dialog.setTitle("Working.....");
			dialog.setCancelable(false);
			dialog.show();
		}
		
		@Override
		protected Void doInBackground(Void... params) {
			
			String aName = name.getText().toString();
			String aMobile = mobile.getText().toString();
			String aEmail = email.getText().toString();
			
			list.add(new BasicNameValuePair("name", aName));
			list.add(new BasicNameValuePair("mobile", aMobile));
			list.add(new BasicNameValuePair("email", aEmail));
			
			getResponse = new OpenUrlGetResponse();
			response = getResponse.makeHttpRequest(url, "POST", list);
			try {
				int i = response.getInt("success");
				if(i != 0){
					BroadCastDataSource source = new BroadCastDataSource(CreateAccount.this);
					source.open();
					source.registerUser(aMobile);
					source.close();	
					Intent intent = new Intent(CreateAccount.this, MessageList.class );
					startActivity(intent);
					
				}else{
					Log.i("$$$$$$", response.getString("message"));
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			return null;
		}
		
		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
			dialog.dismiss();
			
			
		}
		
	}
}
