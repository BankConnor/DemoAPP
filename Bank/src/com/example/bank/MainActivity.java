package com.example.bank;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity 
{
	private TextView textView;
	private CheckBox checkbox1;
	private CheckBox checkbox2;
	private String likes="";

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);//去除掉标题
		setContentView(R.layout.check_demo);
		initViews();
	}
	
	private void initViews()
	{
		textView = (TextView)findViewById(R.id.tvs);
		
		checkbox1 = (CheckBox)findViewById(R.id.c1);
		checkbox1.setOnCheckedChangeListener(new OnCheckedChangeListener()
		{
			//1.实现该接口 当点击该CheckBox的时候 将会触发该事件
			@Override
			public void onCheckedChanged(CompoundButton button, boolean cheked)
			{
				if(cheked)
				{
					likes = likes+"Connor";
				}
				else
				{
					likes = likes.replaceAll("Connor", "");
				}
				textView.setText(likes);
			}
		});
		checkbox2 = (CheckBox)findViewById(R.id.c2);
		checkbox2.setOnCheckedChangeListener(new OnCheckedChangeListener()
		{
			
			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean checked)
			{
				
					if(checked)
					{
						likes = likes+"Bank";
					}
					else
					{
						likes = likes.replaceAll("Bank", "");
					}
					textView.setText(likes);
				}
			
		});
	}


	

}
