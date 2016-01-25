package com.example.contactdemo;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class MainActivity extends Activity implements OnItemClickListener
{
	private Cursor cursor;
	private SimpleCursorAdapter simplecursoradapter;
	private ListView listview;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initData();
		inotViews();
	}

	private void inotViews()
	{
		
		listview = (ListView) findViewById(R.id.Contact_listview);
		simplecursoradapter = new SimpleCursorAdapter(this, R.layout.contact_item, cursor, new String[]{ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,ContactsContract.CommonDataKinds.Phone.NUMBER}
		, new int[]{R.id.contact_item_name,R.id.contact_item_phone});
		listview.setAdapter(simplecursoradapter);
		listview.setOnItemClickListener(this);
	}

	private void initData()
	{
		ContentResolver contentResolver =  getContentResolver();
		cursor = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id)
	{
		TextView tv = (TextView)view.findViewById(R.id.contact_item_phone);
		String phone = String.valueOf(tv.getText());
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_CALL);
		intent.setData(Uri.parse("tel://"+phone));
		startActivity(intent);
	}


}
