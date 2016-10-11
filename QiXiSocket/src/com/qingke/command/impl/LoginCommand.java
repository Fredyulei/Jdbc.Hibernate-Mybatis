package com.qingke.command.impl;
import com.qingke.app.ApplicationTest;
import com.qingke.app.TestMyBatis;
import com.qingke.command.Command;
import com.qingke.util.Console;

import test.domain.Users;

public class LoginCommand implements Command {

	@Override
	public void execute() {
		TestMyBatis  testMybatis = new TestMyBatis(null);
		String username = Console.Input("�������û���");
		while(! testMybatis.isUsernameExit(username)) {
			Console.println("�û���������");
			Console.Input("�����������û���");
		}
		
		String password = Console.Input("����������");
		
		Users user = testMybatis.login(username, password);
		
		if (user == null) {
			Console.println("����ʧ��");
			return;
		}
		
		Console.println("��ӭ����");
		
		ApplicationTest.getInstance().setClientProfile(user);
		
	}
}
