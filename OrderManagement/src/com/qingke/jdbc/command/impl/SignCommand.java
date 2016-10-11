package com.qingke.jdbc.command.impl;

import java.util.regex.Pattern;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.qingke.jdbc.app.OrderManagementApplication;
import com.qingke.jdbc.app.OrderManagementDao;
import com.qingke.jdbc.command.SystemCommand;
import com.qingke.jdbc.content.Client;
import com.qingke.jdbc.util.QingkeConsole;

public class SignCommand extends SystemCommand {
	SessionFactory sf = new Configuration().configure("xmlfolder/hibernate.xml").buildSessionFactory();
	Session session = sf.openSession();
	public void execute() {
		OrderManagementDao dao = new OrderManagementDao(session);
		String username = QingkeConsole.askUserInput("请输入用户名");
		while (dao.isUsernameExists(username,session)) {
			QingkeConsole.println("用户名已存在");
			username = QingkeConsole.askUserInput("请重新输入用户名");
		
		}
		String password = null;
		while (true) {
			password = QingkeConsole.askUserInput("请输入密码");
			try {
				validatePasswords(password);
				break;
			} catch (Exception e) {

				QingkeConsole.println("密码格式不对！" + e.getMessage());
				continue;
			}
		}
		
		String name = QingkeConsole.askUserInput("请输入姓名");
		String gender = QingkeConsole.askUserInput("请输入性别");
		String location = QingkeConsole.askUserInput("请输入地址");
		String phone = QingkeConsole.askUserInput("请输入手机号");
		
		// 调用方法
		Client client = dao.signup(username, password, name,gender,location,phone);
		session.update(client);
		// 调用单例。获得当前用户
		OrderManagementApplication.getInstance().setClientProfile(client);
		QingkeConsole.println("注册成功");

	}

	private void validatePasswords(String passwords) throws Exception {
		// 模式
		Pattern lenPattern = Pattern.compile("[0-9a-zA-Z]{6,}");
		if (!lenPattern.matcher(passwords).find()) {
			throw new Exception("密码长度必须大于等于6位");
		}
		Pattern numPattern = Pattern.compile("[0-9]");
		if (!numPattern.matcher(passwords).find()) {
			throw new Exception("密码至少需要含有一位数字");
		}
		Pattern wordPattern = Pattern.compile("[a-zA-Z]");
		if (!wordPattern.matcher(passwords).find()) {
			throw new Exception("密码至少需要含有一位字母");
		}
	}
}
