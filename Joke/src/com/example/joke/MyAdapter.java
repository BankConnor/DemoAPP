package com.example.joke;

import java.util.ArrayList;
import java.util.List;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter
{
	private List<Joke> jokes = new ArrayList<Joke>();
	private Activity ac;
	
	
	public MyAdapter(List<Joke> jokes, Activity ac)
	{
		super();
		this.jokes = jokes;
		this.ac = ac;
	}

	@Override
	public int getCount()
	{
		return jokes.size();
	}

	@Override
	public Object getItem(int position)
	{
		return jokes.get(position);
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
		if(convertView==null)
		{
			//convertView = ac.getLayoutInflater().inflate(R.layout.item, null);
		}
		return convertView;
	}
	
	static class ViewHolder
	{
		public TextView content;
		public TextView time;
	}

}
