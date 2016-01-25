package com.example.spinner;

import android.os.Bundle;
import android.text.Html;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemSelectedListener
{
	private Spinner sp;
	private ArrayAdapter<String> arr;
	public static List<String> data = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		inttoData();
		
		intoViews();
	}

	private void inttoData()
	{
		String message[] = {"火车","湖边","海边","街边","铁路","花田","草园","火","鲸鱼","落日","群山","Bank","Connor"};
		for (int i = 0; i < message.length; i++)
		{
			data.add(message[i]);
		}
	}

	private void intoViews()
	{
		sp = (Spinner) findViewById(R.id.main_spinner);
		
		//指定列表框的布局 指定数据源
		arr = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
		
		//指定下拉列表的布局
		arr.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		//指定标题头
		sp.setPrompt(Html.fromHtml("<h1>选择类型</h1>"));
		
		//绑定适配器
		sp.setAdapter(arr);
		
		//选择默认选中项  必须在绑定适配器之后 因为没有数据源 Spinner就是空白一边选中默认选中项将是没有意义的
		sp.setSelection(11);
		
		//设置监听
		sp.setOnItemSelectedListener(this);
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
	{
		Toast.makeText(this, data.get(position)+"被点击", Toast.LENGTH_LONG).show();
		String message[] = {"Java","C","Html","CSS","MySQL","Android"};
		for (int i = 0; i < message.length; i++)
		{
			data.add(message[i]);
		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent)
	{
		//没什么用途的方法
	}

}
