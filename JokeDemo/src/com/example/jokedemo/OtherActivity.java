package com.example.jokedemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class OtherActivity extends Activity
{
	private EditText text;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.data);
		
		initViews();
	}
	
	private void initViews()
	{
		text = (EditText) findViewById(R.id.other_ed);
	}

	public void show(View v)
	{
		Intent intent = new Intent(this, MainActivity.class);
		intent.putExtra("Data", text.getText().toString());
		startActivity(intent);
	}
}
