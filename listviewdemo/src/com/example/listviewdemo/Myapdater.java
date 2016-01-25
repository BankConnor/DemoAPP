package com.example.listviewdemo;

import java.util.List;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/*
 * 关注点
 * 数据源 子布局(Item View)
 */
public class Myapdater extends BaseAdapter
{
	private List<UserMessage> datas;//数据源
	private Activity act;
	

	//返回有多少个Item 
	@Override
	public int getCount()
	{
		
		return datas.size();
	}

	//返回某个Item的数据源对象 
	@Override
	public Object getItem(int position)
	{
		return datas.get(position);
	}
	
	static class ViewHolder
	{
		public ImageView icon;
		public TextView username;
		public TextView autograph;
	}
	
	//返回某个Item的视图对象
	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		ViewHolder viewHolder=null;
		UserMessage message = (UserMessage) getItem(position);//当前视图的数据源
		if(convertView==null)
		{
			//ListView调用这里面绘制View对象代表当前 并没有回收任何View
			convertView = act.getLayoutInflater().inflate(R.layout.div_view, null);//获取当前Item视图View
			//把控件都初始化出来
			viewHolder = new ViewHolder();
			viewHolder.icon = (ImageView) convertView.findViewById(R.id.div_view_image);
			viewHolder.username = (TextView) convertView.findViewById(R.id.div_view_username);
			viewHolder.autograph = (TextView)convertView.findViewById(R.id.div_view_autograph);
			/*
			 * 跟View容器视图绑定到一起 回收的时候一起回收
			 * 这样做的目的是 可以重用这些控件 而不用重新获取实例对象 浪费时间开销
			 */
			convertView.setTag(viewHolder);
		}
		else
		{
			viewHolder = (ViewHolder) convertView.getTag();
		}
		viewHolder.icon.setImageResource(message.getIcon());
		viewHolder.username.setText(message.getUsername());
		viewHolder.autograph.setText(message.getAutograph());
		Log.i("Connor", position+"");
		return convertView;
	}
	



	public Myapdater(List<UserMessage> datas, Activity act)
	{
		super();
		this.datas = datas;
		this.act = act;
	}

	//ltem的id 标示
	@Override
	public long getItemId(int position)
	{
		//完全可以使用position position是Item对象在ListView的位置的id值
		return position;
	}
	
}
