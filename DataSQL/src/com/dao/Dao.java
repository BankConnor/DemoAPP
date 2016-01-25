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
	 * 专门用来处理Usermessage表的数据的dao
	 */
	
	private MyDataopenHelp dataopenHelp;
	private String table;
	private SQLiteDatabase sqLiteDatabase;
	
	
	public Dao(Context context, int ves, String table)
	{
		dataopenHelp = new MyDataopenHelp(context);
		this.table = table;
	}

	//添加数据
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

	//删除数据
	public void delete(int id)
	{
		/*
		 * Android封装的删除语句
		 * 参数1：表名
		 * 参数2：where子句表达式 采用参数化的方式指定的SQL语句
		 * 参数3：参数化值
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
		 * 更新SQL语句封装方法
		 * 参数1：表名
		 * 参数2：需要更新的内容的contentValues封装数据对象
		 * 参数3：where子句额参数化语句
		 * 参数4：参数化值
		 */
		SQLiteDatabase sqLiteDatabase = dataopenHelp.getWritableDatabase();
		sqLiteDatabase.update(table, contentValues, "id=?", new String[]{String.valueOf(id)});
		sqLiteDatabase.close();
	}
	
	//查询全部数据
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
			//表中有插入数据
			return cursor.getInt(0);
		}
		//表中没有插入数据
		return 1;
	}
}
