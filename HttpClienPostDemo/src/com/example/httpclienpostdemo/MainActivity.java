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
				List<NameValuePair> pairs = new ArrayList<NameValuePair>();//������������
				pairs.add(new BasicNameValuePair("Connor", "DylanO'Brien"));//��ӱ�����
				try
				{
					HttpEntity entity = new UrlEncodedFormEntity(pairs,"UTF-8");//������ʵ��
					post.setEntity(entity);//��������ӵ�POST������
					client.execute(post);//����HTTP����
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			
			}
		}.start();
	}



}
