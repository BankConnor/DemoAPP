package com.example.sendhttp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity
{
	private WebView web;
	private HttpURLConnection http;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView	(R.layout.activity_main);
	}
	
	public void sendGet(View v)
	{
		AsyncTask<String, String, Boolean> httpTask = new AsyncTask<String, String, Boolean>()
		{
			@Override
			protected void onPreExecute()
			{
				web =(WebView) MainActivity.this.findViewById(R.id.main_web);
				web.setWebViewClient(new WebViewClient(){
					@Override
					public boolean shouldOverrideUrlLoading(WebView view, String url)
					{
						view.loadUrl(url);
						return true;
					}
				});
			}
			
			@Override
			protected Boolean doInBackground(String... params)
			{
				String url = params[0];
				try
				{
					/*
					 * (HttpURLConnection) new URL(url).openConnection();
					 * 不同协议打开远程链接返回不同的协议对象
					 * 获取到HttpURLConnection对象
					 * 打开资源链接
					 */
					http = (HttpURLConnection) new URL(url).openConnection();
					http.setDoInput(true);//支持请求中读数据
					http.setDoOutput(true);//支持请求中写数据
					http.setRequestMethod("GET");//该HTTP请求是GET形式
					http.connect();//建立链接，如果建立链接失败抛出IO异常
					Date date = new Date(http.getDate());
					Log.i("Connor",date.toString());
					Log.i("Connor", http.getContentLength()+"");
					InputStream inputStream = http.getInputStream();//读取应答数据
					
					InputStreamReader reader = new InputStreamReader(inputStream, "UTF-8");
					BufferedReader bufferedReader = new BufferedReader(reader);
					String line = null;
					String countLine = "";
					
					while((line = bufferedReader.readLine())!=null)
					{
						countLine = countLine+line;
					}
					publishProgress(countLine);
				} catch (Exception e)
				{
					return false;
				}
				finally {
					if(http!=null)
					{
						http.disconnect();//关闭链接
					}
				}
				return true;
			}
			
			@Override
			protected void onProgressUpdate(String... values)
			{
				String message = values[0];
				web.loadDataWithBaseURL(null, message, "text/html", "UTF-8", null);
			}
			
			@Override
			protected void onPostExecute(Boolean result)
			{
				if(result)
				{
					Toast.makeText(getApplicationContext(), "加载完毕", Toast.LENGTH_LONG).show();
				}
				else
				{
					Toast.makeText(getApplicationContext(), "链接失败", Toast.LENGTH_LONG).show();
				}
			}
		};
		httpTask.execute("http://192.168.174.1:8080/A.html");
	}

}
