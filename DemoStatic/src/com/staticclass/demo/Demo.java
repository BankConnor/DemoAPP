package com.staticclass.demo;

import com.staticclass.demo.Preson.Addres;

public class Demo
{
	public static void main(String[] args)
	{
		//静态内部类Addres类 不依赖Preson类创建
		Preson.Addres addres = new Addres("罗马");
	}
}
