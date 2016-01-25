package com.example.jokedemo;

import java.util.List;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter
{
	private Activity ac;
	private List<Joke> datas;
	
	
	
	public MyAdapter(Activity ac, List<Joke> datas)
	{
		super();
		this.ac = ac;
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
		ViewInside inside = null;
		if(convertView==null)
		{
			inside = new ViewInside();
			convertView = ac.getLayoutInflater().inflate(R.layout.item, null);
			inside.content = (TextView) convertView.findViewById(R.id.item_content);
			inside.time = (TextView) convertView.findViewById(R.id.item_time);
			convertView.setTag(inside);
		}
		else
		{
			inside = (ViewInside) convertView.getTag();
		}
		inside.content.setText(datas.get(position).getContent());
		inside.time.setText(datas.get(position).getTime());
		return convertView;
	}

	static class ViewInside
	{
		public TextView content;
		public TextView time;
	}
}
