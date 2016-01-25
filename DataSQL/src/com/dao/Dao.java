package com.dao;

import java.util.ArrayList;
import java.util.List;

import com.bean.User;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;

public class Dao
{
	/*
	 * ר����������Usermessage������ݵ�dao
	 */
	
	private MyDataopenHelp dataopenHelp;
	private String table;
	private SQLiteDatabase sqLiteDatabase;
	
	
	public Dao(Context context, int ves, String table)
	{
		dataopenHelp = new MyDataopenHelp(context);
		this.table = table;
	}

	//�������
	public void insert(User user)
	{
		SQLiteDatabase sqLiteDatabase = dataopenHelp.getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		contentValues.put("name", user.getName());
		contentValues.put("age", user.getAge());
		contentValues.put("sex", user.getSex());
		sqLiteDatabase.insert(table, null, contentValues);
		sqLiteDatabase.close();
	}

	//ɾ������
	public void delete(int id)
	{
		/*
		 * Android��װ��ɾ�����
		 * ����1������
		 * ����2��where�Ӿ���ʽ ���ò������ķ�ʽָ����SQL���
		 * ����3��������ֵ
		 */
		SQLiteDatabase sqLiteDatabase = dataopenHelp.getWritableDatabase();
		sqLiteDatabase.delete(table, "id=?", new String[]{String.valueOf(id)});
		sqLiteDatabase.close();
	}
	
	public void update(int id, User newuser)
	{
		ContentValues contentValues = new ContentValues();
		contentValues.put("name", newuser.getName());
		contentValues.put("age", newuser.getAge());
		contentValues.put("sex", newuser.getSex());
		
		/*
		 * ����SQL����װ����
		 * ����1������
		 * ����2����Ҫ���µ����ݵ�contentValues��װ���ݶ���
		 * ����3��where�Ӿ����������
		 * ����4��������ֵ
		 */
		SQLiteDatabase sqLiteDatabase = dataopenHelp.getWritableDatabase();
		sqLiteDatabase.update(table, contentValues, "id=?", new String[]{String.valueOf(id)});
		sqLiteDatabase.close();
	}
	
	//��ѯȫ������
	public List<User> findAll()
	{
		SQLiteDatabase sqLiteDatabase = dataopenHelp.getWritableDatabase();
		List<User> users = new ArrayList<User>();
		Cursor cursor = sqLiteDatabase.rawQuery("select * from usermessage", null);
		
		while(cursor.moveToNext())
		{
			User user = new User(cursor.getString(cursor.getColumnIndex("name")), cursor.getString(cursor.getColumnIndex("sex")), cursor.getInt(cursor.getColumnIndex("age")));
			users.add(user);
		}
		return users;
	}
	
	public Cursor  returncursor()
	{
		sqLiteDatabase = dataopenHelp.getWritableDatabase();
		Cursor cursor = sqLiteDatabase.rawQuery("select * from usermessage", null);
		return cursor;
	}
	
	public void cursorclose()
	{
		sqLiteDatabase.close();
	}
	
	private int getMax_id()
	{
		SQLiteDatabase sqLiteDatabase = dataopenHelp.getWritableDatabase();
		sqLiteDatabase = dataopenHelp.getWritableDatabase();
		Cursor cursor = sqLiteDatabase.rawQuery("select max(id) from usermessage", null);
		if(cursor.moveToNext())
		{
			//�����в�������
			return cursor.getInt(0);
		}
		//����û�в�������
		return 1;
	}
}
