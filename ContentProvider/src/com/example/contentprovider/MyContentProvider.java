package com.example.contentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class MyContentProvider extends ContentProvider
{
	public static final String URI = "com.example.contentprovider";

	private MySQLiteOpenHelp mySQLiteOpenHelp;
	private static UriMatcher uriMatcher;
	
	public static final int STUDENT_DIR = 0;//��ʾ����StudentMessage����������
	public static final int STUDENT_ITEM=1;//��ʾ����ָ��idֵ��StudentMessage�������
	
	static
	{
		//�Զ���URI ������ʹ�ö���õ�URI �����ʶ�Ӧ������
		uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
		//��䶨��õ�URI ����match()������ʱ��ͻ᷵��ָ����URI���� ƥ���URI�����ȡ�û�����Ϣ
		
		/*
		 *����1��Ȩ�޲��� �������ṩ�����ṩӦ�ó���İ���
		 *����2������
		 *����3��Ϊ���URI�ṩ��ʶ ���ڽ���URI��ʱ�򷵻�intֵ ���߼�����
		 */
		uriMatcher.addURI(URI, "studentMessage", STUDENT_DIR);//��URI��Ϣ��ʾ �û���ѯ����StudentMessage��Ϣ
		/*
		 * ��ȡ����URI��ʾ �û���ѯָ��id������ /#��ʾidֵ uriMatcher�ڲ���װ�ı�ʾ��ר������ָ����idֵ��
		 */
		uriMatcher.addURI(URI, "studentMessage/#", STUDENT_ITEM);
		
	}
	@Override
	public boolean onCreate()
	{
		//���������ṩ�� true��ʾ�����ɹ������ṩ��
		mySQLiteOpenHelp = new MySQLiteOpenHelp(getContext());
		return true;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder)
	{
		SQLiteDatabase database = mySQLiteOpenHelp.getWritableDatabase();
		Cursor cursor = null;
		switch (uriMatcher.match(uri))//�����û���URI ������STUDENT_DIR(ȫ��)����STUDENT_ITEM(_idֵ)
		{
		case 0:
			//ȫ��
			cursor = database.query("studentMessage", projection, selection, selectionArgs, null, null, sortOrder);
			break;

		case 1:
			//��ѯStudentMessage���ĳ��id
			String id = uri.getPathSegments().get(1);
			cursor = database.query("studentMessage", projection, "_id=?", new String[]{id}, null, null, sortOrder);
		}
		return cursor;//��������Ҫ�ж��α��Ƿ�Ϊnull
	}

	@Override
	public String getType(Uri uri)
	{
		switch (uriMatcher.match(uri))
		{
		case 0:
			
			return "vnd.android.cursor.dir/vnd."+URI+"studentMessage";

		case 1:
			return "vnd.android.cursor.item/vnd."+URI+"studentMessage";
		}
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values)
	{
		SQLiteDatabase database = mySQLiteOpenHelp.getWritableDatabase();
		Uri returnUri=null;
		switch (uriMatcher.match(uri))
		{
		case 0:
		case 1:
			//��Ϊid���������������û�ָ�� ����û��������ֱ������
			long id = database.insert("studentMessage", URI, values);
			returnUri.parse("content://"+URI+"studentMessage"+id);
			break;
		}
		return returnUri;
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs)
	{
		// TODO Auto-generated method stub
		return 0;
	}

}
