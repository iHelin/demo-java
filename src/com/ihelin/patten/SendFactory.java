package com.ihelin.patten;

/**
 * 简单的工厂模式
 * 
 * @author iHelin
 * @since 2016
 * 
 */
public class SendFactory {

	public static void main(String[] args) {
		SendFactory factory = new SendFactory();
		Sender sender = factory.produce("sms");
		//Sender sender = factory.produce("mail");
		sender.Send();
	}

	public Sender produce(String type) {
		if ("mail".equals(type)) {
			return new MailSender();
		} else if ("sms".equals(type)) {
			return new SmsSender();
		} else {
			System.out.println("请输入正确的类型!");
			return null;
		}
	}

}
