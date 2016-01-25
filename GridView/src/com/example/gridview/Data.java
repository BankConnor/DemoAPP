package com.example.gridview;

public class Data
{
	private int icon;
	private String text;
	
	public int getIcon()
	{
		return icon;
	}
	public void setIcon(int icon)
	{
		this.icon = icon;
	}
	public String getText()
	{
		return text;
	}
	public void setText(String text)
	{
		this.text = text;
	}
	
	public Data(int icon, String text)
	{
		super();
		this.icon = icon;
		this.text = text;
	}
	
	
}
