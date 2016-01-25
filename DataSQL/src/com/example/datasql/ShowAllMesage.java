package com.example.datasql;

import java.util.List;

import com.adapter.MyAdapter;
import com.bean.User;
import com.dao.Dao;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ShowAllMesage extends Activity
{
	private SimpleCursorAdapter simpleCursorAdapter;
	private ListView list;
	private Dao dao;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.showallmessage_listview);
		
		initView();
	}

	private void initView()
	{
		list = (ListView) findViewById(R.id.showallmessage_listview);
		dao = new Dao(this, 2, "usermessage");
		simpleCursorAdapter = new SimpleCursorAdapter(this, R.layout.usermessage_item, dao.returncursor(), new String[]{"name","age","sex"}, new int[]{R.id.usermessage_item_name,R.id.usermessage_item_age,R.id.usermessage_item_sex});
		list.setAdapter(simpleCursorAdapter);
	}
	
	@Override
	public void onBackPressed()
	{
		super.onBackPressed();
		simpleCursorAdapter.getCursor().close();
		dao.cursorclose();
	}
	
}
