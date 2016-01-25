package com.example.spinner;

import android.os.Bundle;
import android.text.Html;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemSelectedListener
{
	private Spinner sp;
	private ArrayAdapter<String> arr;
	public static List<String> data = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		inttoData();
		
		intoViews();
	}

	private void inttoData()
	{
		String message[] = {"��","����","����","�ֱ�","��·","����","��԰","��","����","����","Ⱥɽ","Bank","Connor"};
		for (int i = 0; i < message.length; i++)
		{
			data.add(message[i]);
		}
	}

	private void intoViews()
	{
		sp = (Spinner) findViewById(R.id.main_spinner);
		
		//ָ���б��Ĳ��� ָ������Դ
		arr = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
		
		//ָ�������б�Ĳ���
		arr.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		//ָ������ͷ
		sp.setPrompt(Html.fromHtml("<h1>ѡ������</h1>"));
		
		//��������
		sp.setAdapter(arr);
		
		//ѡ��Ĭ��ѡ����  �����ڰ�������֮�� ��Ϊû������Դ Spinner���ǿհ�һ��ѡ��Ĭ��ѡ�����û�������
		sp.setSelection(11);
		
		//���ü���
		sp.setOnItemSelectedListener(this);
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
	{
		Toast.makeText(this, data.get(position)+"�����", Toast.LENGTH_LONG).show();
		String message[] = {"Java","C","Html","CSS","MySQL","Android"};
		for (int i = 0; i < message.length; i++)
		{
			data.add(message[i]);
		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent)
	{
		//ûʲô��;�ķ���
	}

}
