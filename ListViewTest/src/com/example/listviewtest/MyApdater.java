package com.example.listviewtest;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.example.listviewtest.Data.Datamessage;

import android.app.Activity;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyApdater extends BaseAdapter
{
	private Activity activity;
	
	static
	{
		Data.intoData();
		Log.i("Connor", Data.data.toString());
	}

	@Override
	public int getCount()
	{
		return Data.data.size();
	}

	@Override
	public Object getItem(int position)
	{
		
		return Data.data.get(position);
	}

	@Override
	public long getItemId(int position)
	{
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		ViewHolder holder = null;
		//获取当前需要绘制的数据
		Datamessage datamessage = (Datamessage) getItem(position);
		//采用ListView的优化原则 优化数据绘制显示
		if(convertView==null)
		{
			//获取当前的视图(容器)对象
			convertView = activity.getLayoutInflater().inflate(R.layout.photo_show, null);
			holder = new ViewHolder();//保存需要更改数据视图对象 达到减少时间的开销
			holder.imageView = (ImageView) convertView.findViewById(R.id.phpto_show_image);
			holder.textView = (TextView)convertView.findViewById(R.id.photo_show_tv);
			convertView.setTag(holder);//绑定到一起 一起被系统回收
		}
		else
		{
			holder = (ViewHolder) convertView.getTag();
		}
		holder.imageView.setImageResource(datamessage.icon);
		holder.textView.setText(datamessage.message);
		return convertView;
	}
	
	public MyApdater(Activity activity)
	{
		super();
		this.activity = activity;
	}

	static class ViewHolder
	{
		public  ImageView imageView;
		public  TextView textView;
	}

}
