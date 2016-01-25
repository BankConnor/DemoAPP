package com.example.contentprovider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteOpenHelp extends SQLiteOpenHelper
{

	public MySQLiteOpenHelp(Context context)
	{
		//创建Student数据库
		super(context, "Student.db", null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db)
	{
		//初始化Student数据库的表
		db.execSQL("create table studentMessage (_id integer primary key autoincrement, name varchar(10), "
				+ "age integer, sex varchar(4))");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
		//暂且不更新数据
	}

}
