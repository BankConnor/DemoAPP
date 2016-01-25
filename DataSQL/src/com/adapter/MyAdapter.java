package com.adapter;

import java.util.List;

import com.bean.User;
import com.example.datasql.R;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyAdapter extends CursorAdapter
{
	private Activity act;//View
	private List<User> users;
	public MyAdapter(Context context, Cursor c)
	{
		super(context, c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public View newView(Context arg0, Cursor arg1, ViewGroup arg2)
	{
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public void bindView(View arg0, Context arg1, Cursor arg2)
	{
		// TODO Auto-generated method stub
		
	}
	
	
	/*public MyAdapter(Activity act, List<User> users)
	{
		super();
		this.act = act;
		this.users = users;
	}

	@Override
	public int getCount()
	{
		return users.size();
	}

	@Override
	public Object getItem(int position)
	{
		return users.get(position);
	}

	@Override
	public long getItemId(int position)
	{
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		User user = (User) getItem(position);
		ViewHoldder holdder=null;
		if(convertView==null)
		{
			//µÚÒ»ÆÁÄ»
			convertView = act.getLayoutInflater().inflate(R.layout.usermessage_item,null);
			holdder = new ViewHoldder((TextView)convertView.findViewById(R.id.usermessage_item_name), 
					(TextView)convertView.findViewById(R.id.usermessage_item_age), 
					(TextView)convertView.findViewById(R.id.usermessage_item_sex));
			convertView.setTag(holdder);
		}
		else
		{
			holdder = (ViewHoldder) convertView.getTag();
		}
		holdder.getName().setText(user.getName());
		holdder.getAge().setText(String.valueOf(user.getAge()));
		holdder.getSex().setText(user.getSex());
		return convertView;
	}*/
	



}
