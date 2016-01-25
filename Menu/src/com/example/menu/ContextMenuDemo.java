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
		
		registerForContextMenu(image);//绑定ContextMenu菜单
		registerForContextMenu(imageview);
	
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item)
	{
		/*
		 * ContextMenu菜单点击监听事件回调方法
		 * 根据用户点击的Menultem对象 回调到本方法中
		 * 通过获取回调过来的Menultem对象的id来 判断用户点击的那个选项
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
		 * ContextMenu回调方法 当某个控件绑定ContextMenu之后
		 * 按住控件2秒以上回调该方法
		 * 参数1 ContextMenu菜单容器
		 * 参数2 那个控件按住2秒回调的该方法
		 * 参数3 菜单内容的附加数据
		 */
		if(v == imageview)
		{
			menu.add(1, 1, 1, "Conor");
			menu.add(2, 2, 2, "Bank");
			menu.add(3, 3, 3, "Jude");
			menu.setHeaderIcon(android.R.drawable.ic_dialog_map);
			menu.setHeaderTitle("选择");
		}
		else if(v == image)
		{
			menu.add(4, 4, 4, "Google");
			menu.add(5, 5, 5, "Android");
			menu.add(6, 6, 6, "Java");
			menu.setHeaderIcon(android.R.drawable.ic_dialog_map);
			menu.setHeaderTitle("选择");
		}
		super.onCreateContextMenu(menu, v, menuInfo);
	}
}
