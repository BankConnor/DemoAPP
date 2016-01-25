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
		//��ȡ��ǰ��Ҫ���Ƶ�����
		Datamessage datamessage = (Datamessage) getItem(position);
		//����ListView���Ż�ԭ�� �Ż����ݻ�����ʾ
		if(convertView==null)
		{
			//��ȡ��ǰ����ͼ(����)����
			convertView = activity.getLayoutInflater().inflate(R.layout.photo_show, null);
			holder = new ViewHolder();//������Ҫ����������ͼ���� �ﵽ����ʱ��Ŀ���
			holder.imageView = (ImageView) convertView.findViewById(R.id.phpto_show_image);
			holder.textView = (TextView)convertView.findViewById(R.id.photo_show_tv);
			convertView.setTag(holder);//�󶨵�һ�� һ��ϵͳ����
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
