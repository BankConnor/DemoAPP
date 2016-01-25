package com.example.listviewdemo;

public class UserMessage
{
	private int icon;
	private String username;
	private String autograph;
	public int getIcon()
	{
		return icon;
	}
	public void setIcon(int icon)
	{
		this.icon = icon;
	}
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getAutograph()
	{
		return autograph;
	}
	public void setAutograph(String autograph)
	{
		this.autograph = autograph;
	}
	public UserMessage(int icon, String username, String autograph)
	{
		super();
		this.icon = icon;
		this.username = username;
		this.autograph = autograph;
	}
	public UserMessage()
	{
		super();
	}
	@Override
	public String toString()
	{
		return "UserMessage [icon=" + icon + ", username=" + username + ", autograph=" + autograph + "]";
	}
	
	
}
