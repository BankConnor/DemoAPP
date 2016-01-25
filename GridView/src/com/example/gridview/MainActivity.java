package com.example.gridview;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;


import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class MainActivity extends Activity implements OnItemClickListener
{

	private GridView gridview;
	private List<Data> datas = new ArrayList<Data>();
	private MyApdater apdater;
	private  int imageicon[] ={R.drawable.ue404, R.drawable.ue405,R.drawable.ue406,R.drawable.ue407,
			R.drawable.ue408,R.drawable.ue409,R.drawable.ue410,R.drawable.ue411,
			R.drawable.ue412,R.drawable.ue413,R.drawable.ue414,R.drawable.ue415,R.drawable.ue404};
	private  String message[] = {"»ð³µ","ºþ±ß","º£±ß","½Ö±ß","ÌúÂ·","»¨Ìï",
			"²ÝÔ°","»ð","¾¨Óã","ÂäÈÕ","ÈºÉ½","Bank","Connor"};

	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gridview_demo);
		gridview = (GridView) findViewById(R.id.gridview_demo_main);
		intoData();
		apdater = new MyApdater(this, datas);
		gridview.setAdapter(apdater);
		gridview.setOnItemClickListener(this);
	}

	private void intoData()
	{
		for (int i = 0; i < message.length; i++)
		{
			Data data = new Data(imageicon[i], message[i]);
			datas.add(data);
		}
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id)
	{
		
		Intent intent = new Intent(MainActivity.this, OtherActivity.class);
		intent.putExtra("icon", position);
		startActivity(intent);
	}



}
