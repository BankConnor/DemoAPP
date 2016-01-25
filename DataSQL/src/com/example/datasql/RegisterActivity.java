package com.example.datasql;

import com.bean.User;
import com.dao.Dao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RegisterActivity extends Activity
{
	private User user;
	private EditText edname;
	private EditText edage;
	private EditText edsex;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register_message);
		
		intoViews();
	}

	private void intoViews()
	{
		edname = (EditText) findViewById(R.id.register_name);
		edage = (EditText) findViewById(R.id.register_age);
		edsex = (EditText) findViewById(R.id.register_sex);
	}
	
	public void register(View v)
	{
		user = new User();
		user.setName(edname.getText().toString());
		user.setAge(Integer.valueOf(edage.getText().toString()));
		user.setSex(edsex.getText().toString());
		Dao dao = new Dao(this, 2, "usermessage");
		dao.insert(user);
		setResult(RESULT_OK, new Intent());
		finish();
	}
}
