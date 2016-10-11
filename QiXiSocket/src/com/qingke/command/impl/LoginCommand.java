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
		String username = Console.Input("请输入用户名");
		while(! testMybatis.isUsernameExit(username)) {
			Console.println("用户名不存在");
			Console.Input("请重新输入用户名");
		}
		
		String password = Console.Input("请输入密码");
		
		Users user = testMybatis.login(username, password);
		
		if (user == null) {
			Console.println("登入失败");
			return;
		}
		
		Console.println("欢迎回来");
		
		ApplicationTest.getInstance().setClientProfile(user);
		
	}
}
