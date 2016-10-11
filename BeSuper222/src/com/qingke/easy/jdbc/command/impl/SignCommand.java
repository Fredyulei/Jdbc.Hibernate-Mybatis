package com.qingke.easy.jdbc.command.impl;

import java.util.regex.Pattern;

import com.qingke.easy.Player;
import com.qingke.easy.jdbc.app.BeSuperApplication;
import com.qingke.easy.jdbc.app.BesuperDao;
import com.qingke.easy.jdbc.command.SystemCommand;
import com.qingke.jdbcapp.util.QingkeConsole;
//ע���û�
public class SignCommand extends SystemCommand {
	public void execute() {
		//���ݿ���ڣ�����һ��ʵ��
		BesuperDao dao = new BesuperDao();
		String username = QingkeConsole.askUserInput("�������û���");
		//�ж��û����Ƿ������ݿ��д���
		while (dao.isUsernameExists(username)) {
			QingkeConsole.println("�û����Ѵ���");
			username = QingkeConsole.askUserInput("�����������û���");
		}
		String passwords = null;
		while (true) {
			passwords = QingkeConsole.askUserInput("����������");
			try {
				//
				validatePasswords(passwords);
				break;
			} catch (Exception e) {
				QingkeConsole.println("�����ʽ���ԣ�" + e.getMessage());
				continue;
			}
		}
		//����һ���ǳ�
		String nickname = QingkeConsole.askUserInput("�������ǳ�");
		//���÷���
		Player player = dao.signup(username, passwords, nickname);
		//���õ�������õ�ǰ�û�
		BeSuperApplication.getInstance().setPlayerProfile(player);
	}
//��֤���� ֻ�Ǹ�����
	private void validatePasswords(String passwords) throws Exception{
		//ģʽ
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
