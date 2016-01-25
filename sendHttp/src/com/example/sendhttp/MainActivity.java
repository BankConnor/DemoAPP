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
					 * ��ͬЭ���Զ�����ӷ��ز�ͬ��Э�����
					 * ��ȡ��HttpURLConnection����
					 * ����Դ����
					 */
					http = (HttpURLConnection) new URL(url).openConnection();
					http.setDoInput(true);//֧�������ж�����
					http.setDoOutput(true);//֧��������д����
					http.setRequestMethod("GET");//��HTTP������GET��ʽ
					http.connect();//�������ӣ������������ʧ���׳�IO�쳣
					Date date = new Date(http.getDate());
					Log.i("Connor",date.toString());
					Log.i("Connor", http.getContentLength()+"");
					InputStream inputStream = http.getInputStream();//��ȡӦ������
					
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
						http.disconnect();//�ر�����
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
					Toast.makeText(getApplicationContext(), "�������", Toast.LENGTH_LONG).show();
				}
				else
				{
					Toast.makeText(getApplicationContext(), "����ʧ��", Toast.LENGTH_LONG).show();
				}
			}
		};
		httpTask.execute("http://192.168.174.1:8080/A.html");
	}

}
