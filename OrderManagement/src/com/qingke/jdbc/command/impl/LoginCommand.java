package com.qingke.jdbc.command.impl;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.qingke.jdbc.app.OrderManagementApplication;
import com.qingke.jdbc.app.OrderManagementDao;
import com.qingke.jdbc.command.SystemCommand;
import com.qingke.jdbc.content.Client;
import com.qingke.jdbc.util.QingkeConsole;

public class LoginCommand extends SystemCommand {
	public void execute() {
		OrderManagementDao dao = new OrderManagementDao(session);
		String username = QingkeConsole.askUserInput("请输入用户名");
		while (!dao.isUsernameExists(username,session)) {
			QingkeConsole.println("用户不存在");
			username = QingkeConsole.askUserInput("请输入用户名");
		}
		String password = QingkeConsole.askUserInput("请输入密码");
		Client client = dao.login(username, password);
		if (client == null) {
			QingkeConsole.println("登陆失败：用户名或者密码不正确");
			return;
		}
		
		QingkeConsole.println("欢迎回来"+client.getName());
		
		OrderManagementApplication.getInstance().setClientProfile(client);
	}
}
