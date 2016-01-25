package com.example.joke;

import android.os.Bundle;
import android.util.Log;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		new Thread(){
			public void run() {
				
				try
				{
					
					List<Object> list = new ArrayList<Object>();
					list.add("Connor");
					list.add(1);
					list.add(true);
					list.add(new Joke("Bank", "1996"));
					JSONArray array = new JSONArray();
					JSONArray jsonArray = array.put(list);
					Log.i("Connor", array.toString());
				}
				catch(Exception e)
				{
					throw new RuntimeException(e);
				}
					
			}		
		}.start();
	}


}
