package com.example.pass;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Photo extends Activity implements OnClickListener, android.view.View.OnClickListener 
{
	private EditText username;
	private EditText password;
	private DialogInterface dialog;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.demo3_re);
		initViews();
	}

	private void initViews()
	{
		AlertDialog.Builder builder = new Builder(Photo.this);
		builder.setIcon(android.R.drawable.ic_menu_call);
		builder.setTitle("登陆进入新世界");
		View view = Photo.this.getLayoutInflater().inflate(R.layout.login_demo, null);
		username = (EditText)view.findViewById(R.id.LogIn_username);
		password = (EditText)view.findViewById(R.id.Login_password);
		builder.setPositiveButton("登陆", this);
		builder.setView(view);
		builder.create().show();
	}

	@Override
	public void onClick(DialogInterface dialog, int which)
	{
		if(username.getText().toString().equals("Touch")&&password.getText().toString().equals("Connor"))
		{
			this.dialog = dialog;
			Log.i("Connor", "登陆成功");
			AlertDialog.Builder builder = new Builder(Photo.this);
			ImageView imageView = new ImageView(this);
			imageView.setImageResource(R.drawable.trconn);
			imageView.setOnClickListener(Photo.this);
			builder.setView(imageView);
			builder.create().show();
		}
		else
		{
			Log.i("Connor", "登陆失败,强制退出");
			throw new RuntimeException();
		}
	}

	@Override
	public void onClick(View v)
	{
		dialog.dismiss();
	}

}
