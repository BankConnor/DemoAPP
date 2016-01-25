package com.example.demo_1;

import android.os.Bundle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends Activity 
{
	private EditText phone;
	private EditText sendMessage;
	private EditText message;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ContentResolver resolver = getContentResolver();
    	Uri uri = Uri.parse("content://sms/");
    	resolver.delete(uri, null, null);
    	Cursor cursor = resolver.query(uri,	null, null, null, null);
    	SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(MainActivity.this, R.layout.item, cursor, new String[]{"address","body"}, new int[]{R.id.main_phone,R.id.main_body});
    	ListView list = (ListView) findViewById(R.id.main_listview);
    	list.setAdapter(simpleCursorAdapter);
	}
	
}
