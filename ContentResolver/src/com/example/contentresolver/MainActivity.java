package com.example.contentresolver;

import android.os.Bundle;
import android.util.Log;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.view.Menu;

public class MainActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ContentResolver contentResolver =  getContentResolver();
		Cursor cursor = contentResolver.query(Uri.parse("content://"+"com.example.contentprovider"+"/studentMessage"),null, null, null, null);
		if(cursor.moveToNext())
		{
			Log.i("Connor", cursor.getString(1));
		}
		else
		{
			Log.i("Connor", "没有数据");
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
