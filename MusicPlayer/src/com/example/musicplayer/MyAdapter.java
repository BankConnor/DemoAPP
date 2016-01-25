package com.example.musicplayer;

import java.util.List;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter
{
	private Activity ac;
	private List<Music> datas;
	
	

	public MyAdapter(Activity ac, List<Music> datas)
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
		Viewinside viewinside = null;
		if(convertView==null)
		{
			viewinside = new Viewinside();
			convertView = ac.getLayoutInflater().inflate(R.layout.item, null);
			viewinside.name = (TextView) convertView.findViewById(R.id.itme_name);
			viewinside.author = (TextView) convertView.findViewById(R.id.item_author);
			convertView.setTag(viewinside);
		}
		else
		{
			viewinside = (Viewinside) convertView.getTag();
		}
		
		viewinside.name.setText(datas.get(position).getMusicName());
		viewinside.author.setText(datas.get(position).getAuthor());
		
		return convertView;
	}
	
	static class Viewinside
	{
		public TextView name;
		public TextView author;
	}
}
