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
		String username = QingkeConsole.askUserInput("�������û���");
		while (!dao.isUsernameExists(username,session)) {
			QingkeConsole.println("�û�������");
			username = QingkeConsole.askUserInput("�������û���");
		}
		String password = QingkeConsole.askUserInput("����������");
		Client client = dao.login(username, password);
		if (client == null) {
			QingkeConsole.println("��½ʧ�ܣ��û����������벻��ȷ");
			return;
		}
		
		QingkeConsole.println("��ӭ����"+client.getName());
		
		OrderManagementApplication.getInstance().setClientProfile(client);
	}
}
