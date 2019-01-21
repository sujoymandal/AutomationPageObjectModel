package com.PageObjectModel.Utilities;

import java.net.InetAddress;

public class RoughWork1 {

	public static void main(String[] args) throws Exception {
		
		MonitoringMail mail = new MonitoringMail();
		String messageBody="http://"+InetAddress.getLocalHost().getHostAddress();
		System.out.println(messageBody);
		mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, messageBody);

	}

}
