package com.example.menu;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.ImageView;

public class ContextMenuDemo extends Activity
{
	private ImageView imageview;
	private ImageView image;
	private ImageView imageview2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contextdemo);
		imageview = (ImageView)findViewById(R.id.iamgeview);
		imageview2 = (ImageView)findViewById(R.id.iamgeview);
		Log.i("Connor", imageview.hashCode()+"");
		Log.i("Connor", imageview2.hashCode()+"");
		intoViews();
	}

	private void intoViews()
	{
		imageview = (ImageView)findViewById(R.id.iamgeview);
		image = (ImageView)findViewById(R.id.imageview2);
		
		registerForContextMenu(image);//��ContextMenu�˵�
		registerForContextMenu(imageview);
	
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item)
	{
		/*
		 * ContextMenu�˵���������¼��ص�����
		 * �����û������Menultem���� �ص�����������
		 * ͨ����ȡ�ص�������Menultem�����id�� �ж��û�������Ǹ�ѡ��
		 */
		switch (item.getItemId())
		{
		case 1:
			AlertDialog.Builder builder = new Builder(this);
			builder.setMessage("Hello Connor");
			builder.show();
			break;
		}
		return super.onContextItemSelected(item);
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo)
	{
		/*
		 * ContextMenu�ص����� ��ĳ���ؼ���ContextMenu֮��
		 * ��ס�ؼ�2�����ϻص��÷���
		 * ����1 ContextMenu�˵�����
		 * ����2 �Ǹ��ؼ���ס2��ص��ĸ÷���
		 * ����3 �˵����ݵĸ�������
		 */
		if(v == imageview)
		{
			menu.add(1, 1, 1, "Conor");
			menu.add(2, 2, 2, "Bank");
			menu.add(3, 3, 3, "Jude");
			menu.setHeaderIcon(android.R.drawable.ic_dialog_map);
			menu.setHeaderTitle("ѡ��");
		}
		else if(v == image)
		{
			menu.add(4, 4, 4, "Google");
			menu.add(5, 5, 5, "Android");
			menu.add(6, 6, 6, "Java");
			menu.setHeaderIcon(android.R.drawable.ic_dialog_map);
			menu.setHeaderTitle("ѡ��");
		}
		super.onCreateContextMenu(menu, v, menuInfo);
	}
}
