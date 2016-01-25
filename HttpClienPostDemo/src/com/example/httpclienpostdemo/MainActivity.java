package com.example.httpclienpostdemo;

import android.os.Bundle;
import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

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
				
				HttpClient client = new DefaultHttpClient();
				HttpPost post = new HttpPost("http://192.168.1.100:8080/");
				List<NameValuePair> pairs = new ArrayList<NameValuePair>();//填充表单数据容器
				pairs.add(new BasicNameValuePair("Connor", "DylanO'Brien"));//添加表单数据
				try
				{
					HttpEntity entity = new UrlEncodedFormEntity(pairs,"UTF-8");//表单数据实体
					post.setEntity(entity);//表单数据添加到POST请求中
					client.execute(post);//发送HTTP请求
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			
			}
		}.start();
	}



}
