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
	
	public static final int STUDENT_DIR = 0;//标示访问StudentMessage表所有数据
	public static final int STUDENT_ITEM=1;//标示访问指定id值的StudentMessage表的数据
	
	static
	{
		//自定义URI 调用者使用定义好的URI 来访问对应的数据
		uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
		//填充定义好的URI 调用match()方法的时候就会返回指定的URI对象 匹配该URI对象获取用户的信息
		
		/*
		 *参数1：权限部分 在内容提供者中提供应用程序的包名
		 *参数2：表名
		 *参数3：为这个URI提供标识 用于解析URI的时候返回int值 做逻辑处理
		 */
		uriMatcher.addURI(URI, "studentMessage", STUDENT_DIR);//该URI信息标示 用户查询所有StudentMessage信息
		/*
		 * 获取到该URI标示 用户查询指定id的数据 /#标示id值 uriMatcher内部封装的标示符专门用来指定的id值的
		 */
		uriMatcher.addURI(URI, "studentMessage/#", STUDENT_ITEM);
		
	}
	@Override
	public boolean onCreate()
	{
		//创建内容提供器 true标示创建成功内容提供器
		mySQLiteOpenHelp = new MySQLiteOpenHelp(getContext());
		return true;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder)
	{
		SQLiteDatabase database = mySQLiteOpenHelp.getWritableDatabase();
		Cursor cursor = null;
		switch (uriMatcher.match(uri))//解析用户的URI 返回是STUDENT_DIR(全表)或者STUDENT_ITEM(_id值)
		{
		case 0:
			//全表
			cursor = database.query("studentMessage", projection, selection, selectionArgs, null, null, sortOrder);
			break;

		case 1:
			//查询StudentMessage表的某个id
			String id = uri.getPathSegments().get(1);
			cursor = database.query("studentMessage", projection, "_id=?", new String[]{id}, null, null, sortOrder);
		}
		return cursor;//调用者需要判断游标是否为null
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
			//因为id是主键自增无需用户指定 如果用户传入进来直接舍弃
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
