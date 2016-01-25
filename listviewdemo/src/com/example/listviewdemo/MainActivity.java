package com.example.listviewdemo;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.NotificationManager;
import android.content.Context;
import android.content.res.Resources;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class MainActivity extends Activity implements OnItemClickListener 
{
	/*
	 * ͼƬ����
	 */
	private int image[] ={R.drawable.ue404, R.drawable.ue405,R.drawable.ue406,R.drawable.ue407,
			R.drawable.ue408,R.drawable.ue409,R.drawable.ue410,R.drawable.ue411,
			R.drawable.ue412,R.drawable.ue413,R.drawable.ue414,R.drawable.ue415,R.drawable.ue404, R.drawable.ue405}; 
	private List<UserMessage> data = new ArrayList<UserMessage>();
	private ListView listview;
	private Myapdater myapdater;
	private String[] datas = {"Connor","Jude","Manke","Java","Android",
			"��","XML","weibo","TroyeSivan","Pchy","Fleuk","FaceBook","Connor","Jude"};
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		intoViews();
		listview.setOnItemClickListener(this);
	}

	private void intoViews()
	{
		listview = (ListView) findViewById(R.id.main_lv);
		for (int i = 0; i < image.length; i++)
		{
			UserMessage message = new UserMessage(image[i], datas[i], "Hello Connor");
			data.add(message);
		}
		
		myapdater = new Myapdater(data, this);
		listview.setAdapter(myapdater);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id)
	{
		data.clear();
		//myapdater.notifyDataSetChanged();
	}




}
