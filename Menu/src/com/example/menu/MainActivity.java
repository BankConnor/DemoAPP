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
		 * ͨ���÷�������ѡ��˵����Ӳ˵����� ���ڻ�ȡ���Ӳ˵�������������ѡ��
		 */
		SubMenu subMenu = menu.addSubMenu(1, 1, 1, "�罻���").setIcon(android.R.drawable.ic_dialog_email);
		subMenu.add(2, 2, 2, "Facebook");
		subMenu.add(3, 3, 3, "Twtter");
		subMenu.setHeaderIcon(android.R.drawable.ic_menu_help);//����Ӳ˵�ͷ��ͼ��
		subMenu.setHeaderTitle("�罻");//����Ӳ˵���ͷ������
		
		SubMenu subMenu2 = menu.addSubMenu(4, 4, 4, "Ӱ������").setIcon(android.R.drawable.ic_lock_power_off);
		subMenu2.add(5, 5, 5, "Google Movie");
		subMenu2.add(6, 6, 6, "splicy");
		
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		/*
		 * ʹ��public boolean onOptionsItemSelected(MenuItem item)����
		 * ���������¼� ���û����ĳ��SubMenu����Itmenu��ʱ��ͻᴥ���¼���Ӧ
		 *���ݽ�����item���ǵ����Menuitem����
		 *Ȼ���������id���ж�MenuItem���� ����Ӧ���߼������¼�
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
