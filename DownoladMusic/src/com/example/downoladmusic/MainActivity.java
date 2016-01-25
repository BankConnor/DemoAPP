package com.example.downoladmusic;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.R.anim;
import android.app.Activity;
import android.app.ProgressDialog;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity
{

	private ProgressDialog pro;
	private HttpURLConnection http;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void downoladMusic(View v)
	{
		AsyncTask<String, Integer, Boolean> task = new AsyncTask<String, Integer, Boolean>()
		{
			@Override
			protected void onPreExecute()
			{
				pro = new ProgressDialog(MainActivity.this);
				pro.setTitle("下载歌曲中...");
				pro.setMessage("下载中....");
				pro.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
				pro.setMax(100);
				pro.setIcon(android.R.drawable.ic_input_add);
				pro.show();
			}
			
			@Override
			protected Boolean doInBackground(String... params)
			{
				try
				{
					http = (HttpURLConnection) new URL(params[0]).openConnection();
					
					http.setDoInput(true);
					http.setDoOutput(true);//需要往请求中写入数据
					http.setRequestMethod("POST");
					
					http.connect();
					InputStream inputStream = http.getInputStream();
					OutputStream outputStream = openFileOutput("Connor.mp3", MODE_PRIVATE);
					int len=0;
					int count=0;
					byte[] buff = new byte[1024*1024];
					
					while((len=inputStream.read(buff))!=-1)
					{
						outputStream.write(buff, 0, len);
						count = count + len;
						publishProgress(count);
					}
					
				} catch( Exception e)
				{
					Log.i("Connor", e+"");
					return false;
				}
				finally {
					if(http!=null)
					{
						http.disconnect();
					}
				}
				return true;
			}
			
			@Override
			protected void onProgressUpdate(Integer... values)
			{
				int length = http.getContentLength();
				pro.setProgress(100*values[0]/length);
				pro.onStart();
			}
			
			@Override
			protected void onPostExecute(Boolean result)
			{
				pro.dismiss();
				if(result)
				{
					Toast.makeText(getApplicationContext(), "下载完毕", Toast.LENGTH_LONG).show();;
					Log.i("Connor", "下载成功");
				}
				else
				{
					Toast.makeText(getApplicationContext(), "下载失败", Toast.LENGTH_LONG).show();
					Log.i("Connor", "下载失败");
				}
			}
		};
		task.execute("http://192.168.174.1:8080/test.mp3");
	}

}
