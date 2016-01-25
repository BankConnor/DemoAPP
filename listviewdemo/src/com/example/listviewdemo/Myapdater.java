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
 * ��ע��
 * ����Դ �Ӳ���(Item View)
 */
public class Myapdater extends BaseAdapter
{
	private List<UserMessage> datas;//����Դ
	private Activity act;
	

	//�����ж��ٸ�Item 
	@Override
	public int getCount()
	{
		
		return datas.size();
	}

	//����ĳ��Item������Դ���� 
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
	
	//����ĳ��Item����ͼ����
	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		ViewHolder viewHolder=null;
		UserMessage message = (UserMessage) getItem(position);//��ǰ��ͼ������Դ
		if(convertView==null)
		{
			//ListView�������������View�������ǰ ��û�л����κ�View
			convertView = act.getLayoutInflater().inflate(R.layout.div_view, null);//��ȡ��ǰItem��ͼView
			//�ѿؼ�����ʼ������
			viewHolder = new ViewHolder();
			viewHolder.icon = (ImageView) convertView.findViewById(R.id.div_view_image);
			viewHolder.username = (TextView) convertView.findViewById(R.id.div_view_username);
			viewHolder.autograph = (TextView)convertView.findViewById(R.id.div_view_autograph);
			/*
			 * ��View������ͼ�󶨵�һ�� ���յ�ʱ��һ�����
			 * ��������Ŀ���� ����������Щ�ؼ� ���������»�ȡʵ������ �˷�ʱ�俪��
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

	//ltem��id ��ʾ
	@Override
	public long getItemId(int position)
	{
		//��ȫ����ʹ��position position��Item������ListView��λ�õ�idֵ
		return position;
	}
	
}
