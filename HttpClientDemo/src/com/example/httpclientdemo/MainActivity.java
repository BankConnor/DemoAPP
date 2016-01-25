package com.example.httpclientdemo;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity
{
	private ProgressDialog pro;
	private HttpClient http;
	private HttpEntity entity;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void downoladMusic(View v)
	{
		AsyncTask<URI,Integer, Boolean> task = new AsyncTask<URI, Integer, Boolean>()
		{
			@Override
			protected void onPreExecute()
			{
				pro = new ProgressDialog(MainActivity.this);
				pro.setTitle("下载音频");
				pro.setMessage("下载中....");
				pro.setIcon(android.R.drawable.ic_delete);
				pro.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
				pro.setMax(100);
				pro.show();
			}
			
			@Override
			protected Boolean doInBackground(URI... params)
			{
				InputStream inputStream=null;
				OutputStream outputStream = null;
				try
				{
					http = new DefaultHttpClient();//创建HttpClient对象
					HttpGet get = new HttpGet(params[0]);//指定HTTP是以GET形式请求数据 并传递请求的IP地址
					
					/*
					 * 发送请求，并且返回HttpResponse对象
					 * HttpResponse对象是应答数据对象
					 */
					HttpResponse response = http.execute(get);
					
						entity = response.getEntity();//获取实体数据
						inputStream = entity.getContent();//获取实体数据的内容InputStream
						outputStream = new FileOutputStream(new File("/mnt/sdcard/connor.jpg"));
						//Log.i("Connor", entity.getContentEncoding().getName()+" = "+entity.getContentEncoding().getValue());
						
						byte[] datas = EntityUtils.toByteArray(entity);//抛异常
						
						int len=0;
						byte[] buff = new byte[1024*1024];
						int count=0;
						while((len=inputStream.read(buff))!=-1)
						{
							outputStream.write(buff, 0, len);
							count = count+len;
							/*
							 * entity.getContentLength()获取实体数据的长度
							 */
							publishProgress((int)(count*100/entity.getContentLength()));
						}
						
			
					
				} catch (Exception e)
				{
					Log.i("Connor", e.toString());
					throw new RuntimeException(e);
					//return false;
				}
				finally {
					if(inputStream!=null)
					{
						try
						{
							inputStream.close();
						} catch (IOException e)
						{
						}
					}
					if(outputStream!=null)
					{
						try
						{
							outputStream.close();
						} catch (IOException e)
						{
						}
					}
				}
				return true;
			}
			
			@Override
			protected void onProgressUpdate(Integer... values)
			{
				pro.setProgress(values[0]);
				pro.onStart();
			}
			
			@Override
			protected void onPostExecute(Boolean result)
			{
				pro.dismiss();
				if(result)
				{
					Toast.makeText(getApplicationContext(), "下载完毕", Toast.LENGTH_LONG).show();
				}
				else
				{
					Toast.makeText(getApplicationContext(), "下载失败", Toast.LENGTH_LONG).show();
				}
			}
		};
		try
		{
			task.execute(new URI("http://192.168.1.100:8080/preson.jpg"));
		} catch (URISyntaxException e)
		{
			e.printStackTrace();
		}
	}
	
	
}
