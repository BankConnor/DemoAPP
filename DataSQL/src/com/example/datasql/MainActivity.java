package com.example.datasql;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.bean.User;
import com.dao.Dao;
import com.dao.MyDataopenHelp;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;

public class MainActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		MyDataopenHelp dataopenHelp = new MyDataopenHelp(this);
		SQLiteDatabase database = dataopenHelp.getWritableDatabase();
		SQLiteDatabase database2 = dataopenHelp.getWritableDatabase();	
		Log.i("Connor", database.hashCode()+"");
		Log.i("Connor", database2.hashCode()+"");
	}
	
	public void insert(View v)
	{
		Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
		startActivityForResult(intent, 100);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		
		if(requestCode==100&&resultCode==RESULT_OK)
		{
			Toast.makeText(this, "用户添加成功", Toast.LENGTH_LONG).show();
		}
	}
	
	public void allusermessage(View v)
	{
		Intent intent = new Intent(this, ShowAllMesage.class);
		startActivity(intent);
	}
}
