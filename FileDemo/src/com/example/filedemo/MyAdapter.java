package com.example.filedemo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter
{
	
	private List<File> photo;//����Դ
	private Activity act;//���ݽ����Ļ
	
	
	public MyAdapter(List<File> photo, Activity act)
	{
		super();
		this.photo = photo;
		this.act = act;
	}

	@Override
	public int getCount()
	{
		return photo.size();
	}

	@Override
	public Object getItem(int position)
	{
		return photo.get(position);
	}

	@Override
	public long getItemId(int position)
	{
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		File file = (File) getItem(position);
		ViewHolder viewHolder = null;
		//�����Ż�ԭ��
		if(convertView==null)
		{
			//��һ��Ļ
			convertView = act.getLayoutInflater().inflate(R.layout.photo_item, null);
			viewHolder = new ViewHolder((ImageView) convertView.findViewById(R.id.photo_item_image), (TextView) convertView.findViewById(R.id.photo_item_textview));
			convertView.setTag(viewHolder);
		}
		else
		{
			//���ظ�����
			viewHolder = (ViewHolder) convertView.getTag();
		}
		//��ʼ�޸�����
		viewHolder.getTextview().setText(file.getName());
		
		//��������
		return convertView;
	}
	static class ViewHolder
	{
		private ImageView imageview;//��ʾ��ͼƬ
		private TextView textview;//��ʾ������
		public ImageView getImageview()
		{
			return imageview;
		}
		public ViewHolder(ImageView imageview, TextView textview)
		{
			super();
			this.imageview = imageview;
			this.textview = textview;
		}
		public void setImageview(ImageView imageview)
		{
			this.imageview = imageview;
		}
		public TextView getTextview()
		{
			return textview;
		}
		public void setTextview(TextView textview)
		{
			this.textview = textview;
		}
		
		
	}
}
