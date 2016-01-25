package com.example.httppost;

import android.os.Bundle;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

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
					HttpURLConnection connection = (HttpURLConnection) new URL("http://192.168.1.100:8080/").openConnection();
					connection.setDoInput(true);
					connection.setDoOutput(true);
					InputStream inputStream = new FileInputStream(new File("/mnt/sdcard/Connor.mp3"));
					OutputStream out = connection.getOutputStream();
					int len=0;
					byte[] buff = new byte[1024*1024];
					while((len=inputStream.read(buff))!=-1)
					{
						out.write(buff, 0, len);
						out.flush();
					}
					connection.connect();
					
				} catch (Exception e)
				{
					throw new RuntimeException(e);
				} 
			}
		}.start();
	}
	
	

}
