package com.example.contact;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore.Audio.Media;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.net.Uri;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemClickListener
{
	private Cursor cursor;
	private ListView listview;
	private SimpleCursorAdapter simpleCursorAdapter;
	private ContentResolver contentResolver;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		intoViews();
	}

	private void intoViews()
	{
		listview = (ListView) findViewById(R.id.main_listview);//��ȡListView������ʾ�����б��View
		contentResolver =  getContentResolver();//��ȡ���ݷ�����
		/*
		 * ���ʸ�Media.EXTERNAL_CONTENT_URI��ַָ��ı�
		 * �����α���� ���ڱ�������
		 */
		cursor = contentResolver.query(Media.EXTERNAL_CONTENT_URI, null, null, null,null);
		/*
		 * ʹ��SimpleCursorAdaapter�������������и����ĸ��������������ߣ������ľ���·��
		 */
		simpleCursorAdapter = new SimpleCursorAdapter(this, R.layout.playermp3_item, cursor, 
				new String[]{Media._ID, Media.ARTIST,Media.COMPOSER}, 
				new int[]{R.id.playermp3_miuscname,R.id.playermp3_artist,R.id.playermp3_path});
		//��������
		listview.setAdapter(simpleCursorAdapter);
		//ListView�����¼�
		listview.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id)
	{
		TextView tv = (TextView) view.findViewById(R.id.playermp3_path);
		String path = String.valueOf(tv.getText());
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_VIEW);
		intent.setDataAndType(Uri.parse("file://"+path), "audio/mp3");
		startActivity(intent);
	}

}
