package com.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDataopenHelp extends SQLiteOpenHelper
{
	/*
	 * ��������
	 */
	
	//�ù��������������ݿ�
	public MyDataopenHelp(Context context)
	{
		/*
		 * ����1��������
		 * ����2�����ݿ������ һ����Ӧ���ж�ֱ�Ӿ�ָ̬�� ��Ϊ���ݿ����ֲ�����ÿ�ζ���
		 * ����3: �α깤�� һ�㲻ָ�� �α�һ�Ѷ��������ⲿ���л�ȡ ����null
		 * ����4���汾�� �����������ݿ�(�������ݿ����Ϣ)
		 */
		super(context, "User.db", null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db)
	{
		/*
		 * ��񴴽�
		 * SQLiteDatabase ����Ա
		 * ר��������������ִ��SQL����
		 */
		String sql = "create table usermessage (_id integer primary key autoincrement, name varchar(10), "
				+ "age integer, sex varchar(4))";
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
		/*
		 * ���ݿ���� 
		 * ������������ݱ����Ϣ
		 */
	}

}
