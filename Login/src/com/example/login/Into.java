package com.example.login;

import android.os.Bundle;
import android.util.Log;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Into extends Activity
{
	private EditText username;
	private EditText password;
	private UserMesage usermessage;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		
		intoVew();
	}

	private void intoVew()
	{
		username = (EditText)findViewById(R.id.main_username);
		password = (EditText)findViewById(R.id.main_password);
	}
	
	public void login(View v)
	{
		Intent intent = new Intent(this, Logoin.class);
		startActivityForResult(intent, 100);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		if(requestCode==100)
		{
			if(resultCode==RESULT_OK)
			{
				//获取到注册之后的响应
				usermessage = (UserMesage) data.getSerializableExtra("UserMessage");
				username.setText(usermessage.getUsername());
				password.setText(usermessage.getPassword());
			}
		}
	}

}
