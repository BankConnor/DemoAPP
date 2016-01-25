package com.example.menu;

import android.os.Bundle;
import android.util.Log;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;

public class MainActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		/*
		 * SubMenu addSubMenu(final int groupId, final int itemId, int order, final CharSequence title);
		 * 通过该方法返回选项菜单的子菜单区域 对于获取到子菜单区域可以添加子选项
		 */
		SubMenu subMenu = menu.addSubMenu(1, 1, 1, "社交软件").setIcon(android.R.drawable.ic_dialog_email);
		subMenu.add(2, 2, 2, "Facebook");
		subMenu.add(3, 3, 3, "Twtter");
		subMenu.setHeaderIcon(android.R.drawable.ic_menu_help);//添加子菜单头部图标
		subMenu.setHeaderTitle("社交");//添加子菜单的头部标题
		
		SubMenu subMenu2 = menu.addSubMenu(4, 4, 4, "影音娱乐").setIcon(android.R.drawable.ic_lock_power_off);
		subMenu2.add(5, 5, 5, "Google Movie");
		subMenu2.add(6, 6, 6, "splicy");
		
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		/*
		 * 使用public boolean onOptionsItemSelected(MenuItem item)方法
		 * 来做监听事件 当用户点击某个SubMenu或者Itmenu的时候就会触发事件响应
		 *传递进来的item就是点击的Menuitem对象
		 *然后逐个根据id来判断MenuItem对象 做相应的逻辑处理事件
		 */
		if(item.getItemId()==1)
		{
			AlertDialog.Builder builder = new Builder(MainActivity.this);
			builder.setMessage("Demo");
			builder.show();
		}
		return super.onOptionsItemSelected(item);
	}
	
}
