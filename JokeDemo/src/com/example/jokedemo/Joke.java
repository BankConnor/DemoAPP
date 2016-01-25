package com.example.jokedemo;

public class Joke
{
	private String content;
	private String time;
	public Joke(String content, String time)
	{
		super();
		this.content = content;
		this.time = time;
	}
	public String getContent()
	{
		return content;
	}
	public void setContent(String content)
	{
		this.content = content;
	}
	public String getTime()
	{
		return time;
	}
	public void setTime(String time)
	{
		this.time = time;
	}
	
	
}
