package com.example.gridview;

import java.util.List;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyApdater extends BaseAdapter
{
	private Activity mainActivity;

	private List<Data> datas;
	
	
	public MyApdater(Activity mainActivity, List<Data> datas)
	{
		super();
		this.mainActivity = mainActivity;
		this.datas = datas;
	}
	
	@Override
	public int getCount()
	{
		return datas.size();
	}

	@Override
	public Object getItem(int position)
	{
		return datas.get(position);
	}

	@Override
	public long getItemId(int position)
	{
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		Data dataMessage = (Data) getItem(position);//获取当前的数据
		
		VholderView vholderView = null;
		
		if(convertView==null)
		{
			convertView = mainActivity.getLayoutInflater().inflate(R.layout.item_demo, null);
			vholderView = new VholderView();
			vholderView.imageView = (ImageView) convertView.findViewById(R.id.item_demo_image);
			vholderView.tv = (TextView) convertView.findViewById(R.id.item_tv);
			convertView.setTag(vholderView);
		}
		else
		{
			vholderView = (VholderView) convertView.getTag();
		}
		
		vholderView.imageView.setImageResource(dataMessage.getIcon());
		vholderView.tv.setText(dataMessage.getText());
		
		return convertView;
	}

	static class VholderView
	{
		private ImageView imageView;
		private TextView tv; 
	}
}
