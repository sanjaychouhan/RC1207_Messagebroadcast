


package com.example.jitbrocast;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class OpenUrlGetResponse {
	InputStream is;
	StringBuilder json;;
	JSONObject jsonObject;
	public JSONObject makeHttpRequest(String url, String method, List<NameValuePair> list){		
			try {
				if(method.equalsIgnoreCase("post")){
					DefaultHttpClient client = new DefaultHttpClient();
					HttpPost post = new HttpPost(url);
					post.setEntity(new UrlEncodedFormEntity(list));
					HttpResponse response = client.execute(post);
					HttpEntity entity = response.getEntity();
					is = entity.getContent();
				}
				else if(method.equalsIgnoreCase("get")){
					DefaultHttpClient client = new DefaultHttpClient();
					HttpGet get = new HttpGet(url);
					String paramString = URLEncodedUtils.format(list, "utf-8");
					url += "?" + paramString;
					HttpResponse response = client.execute(get);
					HttpEntity entity = response.getEntity();
					is = entity.getContent();
				}
				
				json = new StringBuilder();
				BufferedInputStream br = new BufferedInputStream(is);
				int line = 0;
				while((line = br.read()) != -1){
					json.append((char)line);
					Log.i("#######", json.toString());
				}
				
				jsonObject = new JSONObject(json.toString());
				Log.i("#######", jsonObject.toString());
				return jsonObject;
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return null;
		
	}

}
