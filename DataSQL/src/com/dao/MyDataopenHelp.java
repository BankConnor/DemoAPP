package com.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDataopenHelp extends SQLiteOpenHelper
{
	/*
	 * 操作助手
	 */
	
	//该构造器创建出数据库
	public MyDataopenHelp(Context context)
	{
		/*
		 * 参数1：上下文
		 * 参数2：数据库的名字 一般在应用中都直接静态指定 因为数据库名字不可能每次都变
		 * 参数3: 游标工厂 一般不指定 游标一把都不来自外部进行获取 传入null
		 * 参数4：版本号 常用升级数据库(更新数据库的信息)
		 */
		super(context, "User.db", null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db)
	{
		/*
		 * 表格创建
		 * SQLiteDatabase 操作员
		 * 专门用来操作数据执行SQL语句的
		 */
		String sql = "create table usermessage (_id integer primary key autoincrement, name varchar(10), "
				+ "age integer, sex varchar(4))";
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
		/*
		 * 数据库更新 
		 * 常用与更新数据表的信息
		 */
	}

}
