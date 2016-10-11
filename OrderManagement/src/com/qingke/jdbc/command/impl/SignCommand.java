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
		String username = QingkeConsole.askUserInput("�������û���");
		while (dao.isUsernameExists(username,session)) {
			QingkeConsole.println("�û����Ѵ���");
			username = QingkeConsole.askUserInput("�����������û���");
		
		}
		String password = null;
		while (true) {
			password = QingkeConsole.askUserInput("����������");
			try {
				validatePasswords(password);
				break;
			} catch (Exception e) {

				QingkeConsole.println("�����ʽ���ԣ�" + e.getMessage());
				continue;
			}
		}
		
		String name = QingkeConsole.askUserInput("����������");
		String gender = QingkeConsole.askUserInput("�������Ա�");
		String location = QingkeConsole.askUserInput("�������ַ");
		String phone = QingkeConsole.askUserInput("�������ֻ���");
		
		// ���÷���
		Client client = dao.signup(username, password, name,gender,location,phone);
		session.update(client);
		// ���õ�������õ�ǰ�û�
		OrderManagementApplication.getInstance().setClientProfile(client);
		QingkeConsole.println("ע��ɹ�");

	}

	private void validatePasswords(String passwords) throws Exception {
		// ģʽ
		Pattern lenPattern = Pattern.compile("[0-9a-zA-Z]{6,}");
		if (!lenPattern.matcher(passwords).find()) {
			throw new Exception("���볤�ȱ�����ڵ���6λ");
		}
		Pattern numPattern = Pattern.compile("[0-9]");
		if (!numPattern.matcher(passwords).find()) {
			throw new Exception("����������Ҫ����һλ����");
		}
		Pattern wordPattern = Pattern.compile("[a-zA-Z]");
		if (!wordPattern.matcher(passwords).find()) {
			throw new Exception("����������Ҫ����һλ��ĸ");
		}
	}
}
