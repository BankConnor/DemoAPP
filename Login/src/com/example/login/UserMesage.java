package com.example.login;

import java.io.Serializable;

public class UserMesage implements Serializable
{
	private String username;
	private String password;
	private String emali;
	private String sex;
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getEmali()
	{
		return emali;
	}
	public void setEmali(String emali)
	{
		this.emali = emali;
	}
	public String getSex()
	{
		return sex;
	}
	public void setSex(String sex)
	{
		this.sex = sex;
	}
	
	
}
