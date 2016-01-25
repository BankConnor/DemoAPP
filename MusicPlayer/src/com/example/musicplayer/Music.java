package com.example.musicplayer;

public class Music
{
	private String author;
	private int id;
	private String musicName;
	private long time;
	private String data;
	public String getAuthor()
	{
		return author;
	}
	public void setAuthor(String author)
	{
		this.author = author;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getMusicName()
	{
		return musicName;
	}
	public void setMusicName(String musicName)
	{
		this.musicName = musicName;
	}
	public long getTime()
	{
		return time;
	}
	public void setTime(long time)
	{
		this.time = time;
	}
	public String getData()
	{
		return data;
	}
	public void setData(String data)
	{
		this.data = data;
	}
	public Music(String author, int id, String musicName, long time, String data)
	{
		super();
		this.author = author;
		this.id = id;
		this.musicName = musicName;
		this.time = time;
		this.data = data;
	}
	public Music(String author, String musicName, long time, String data)
	{
		super();
		this.author = author;
		this.musicName = musicName;
		this.time = time;
		this.data = data;
	}

	
	
	
	
}
