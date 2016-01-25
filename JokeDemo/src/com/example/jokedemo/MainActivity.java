package com.example.jokedemo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.view.Menu;
import android.widget.ListView;

public class MainActivity extends Activity
{
	private List<Joke> jokeDatas = new ArrayList<Joke>();
	private ListView listview;
	private ProgressDialog pro;
	private Handler handler = new Handler(){
		public void handleMessage(android.os.Message msg)
		{
			MyAdapter adapter = new MyAdapter(MainActivity.this, jokeDatas);
			listview.setAdapter(adapter);
			pro.dismiss();
		}
	};
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initViews();
		initData();
	}

	private void initData()
	{
		new Thread(){
			public void run() {
				List<BasicNameValuePair> datas = new ArrayList<BasicNameValuePair>();
				HttpClient client = new DefaultHttpClient();
				HttpPost httpPost = new HttpPost("http://route.showapi.com/341-1");
				try
				{
					datas.add(new BasicNameValuePair("showapi_appid", "14569"));
					datas.add(new BasicNameValuePair("showapi_sign", "00edcbcd34ec405d8771fabedca83551"));
					datas.add(new BasicNameValuePair("showapi_timestamp", String.valueOf(System.currentTimeMillis())));
					/*Date date = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String now = sdf.format(date);*/
					datas.add(new BasicNameValuePair("time", getIntent().getStringExtra("Data")));
					HttpEntity entity = new UrlEncodedFormEntity(datas,"UTF-8");
					httpPost.setEntity(entity);
					HttpResponse response = client.execute(httpPost);
					String jsonData = EntityUtils.toString(response.getEntity(),"UTF-8");
					OutputStream out = openFileOutput("Debug.txt", MODE_APPEND);
					out.write(jsonData.getBytes());
					JSONObject obj = new JSONObject(jsonData).getJSONObject("showapi_res_body");
					JSONArray array = obj.getJSONArray("contentlist");
					for (int i = 0; i < array.length(); i++)
					{
						JSONObject jsonObject =array.getJSONObject(i);
						jokeDatas.add(new Joke(jsonObject.getString("text"), jsonObject.getString("ct")));
					}
					handler.sendEmptyMessage(1);
				} catch (Exception e)
				{
					try
					{
						OutputStream out = openFileOutput("Debug.txt", MODE_APPEND);
						out.write(e.toString().getBytes());
					} catch (Exception e1)
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					throw new RuntimeException(e);
				}
			}
		}.start();
	}

	private void initViews()
	{
		listview = (ListView) findViewById(R.id.main_listview);
		pro = new ProgressDialog(MainActivity.this);
		pro.setMessage("加载数据中");
		pro.show();
	}


}
