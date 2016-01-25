package com.example.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

public class Logoin extends Activity
{
	private EditText useranme;
	private EditText password;
	private EditText repeatpassword;
	private EditText email;
	private RadioGroup sexgroup;
	private UserMesage usermessage = new UserMesage();
	private String sex;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.logoin);
		
		initViews();
	}

	private void initViews()
	{
		useranme = (EditText)findViewById(R.id.logoin_username);
		password = (EditText)findViewById(R.id.logoin_password);
		repeatpassword = (EditText)findViewById(R.id.logoin_password2);
		email = (EditText)findViewById(R.id.logoin_email);
		sexgroup = (RadioGroup)findViewById(R.id.logoin_group);
		sexgroup.setOnCheckedChangeListener(new OnCheckedChangeListener()
		{
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId)
			{
				if(checkedId == R.id.logoin_man)
				{
					sex = "男";
				}
				else
				{
					sex = "女";
				}
			}
		});
	}
	
	public void register(View v)
	{
		if(!password.getText().toString().equals(repeatpassword.getText().toString()))
		{
			Toast.makeText(this, "密码不一致，请检查", Toast.LENGTH_LONG).show();
			return;
		}
		usermessage.setUsername(useranme.getText().toString());
		usermessage.setPassword(password.getText().toString());
		usermessage.setEmali(email.getText().toString());
		usermessage.setSex(sex);
		Intent intent = new Intent();
		intent.putExtra("UserMessage",usermessage);
		setResult(RESULT_OK, intent);
		finish();
	}
}
