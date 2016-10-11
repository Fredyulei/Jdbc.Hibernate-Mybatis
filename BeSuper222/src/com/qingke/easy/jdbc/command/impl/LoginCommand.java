package com.qingke.easy.jdbc.command.impl;

import com.qingke.easy.Player;
import com.qingke.easy.jdbc.app.BeSuperApplication;
import com.qingke.easy.jdbc.app.BesuperDao;
import com.qingke.easy.jdbc.command.SystemCommand;
import com.qingke.jdbcapp.util.QingkeConsole;

public class LoginCommand extends SystemCommand {

	public void execute() {
		BesuperDao dao = new BesuperDao();
		String username = QingkeConsole.askUserInput("�������û���");
		while (!dao.isUsernameExists(username)) {
			QingkeConsole.println("�û���������");
			username = QingkeConsole.askUserInput("�������û���");
		}
		String password = QingkeConsole.askUserInput("����������");
		Player player = dao.login(username, password);
	
		if (player == null) {
			QingkeConsole.println("��½ʧ�ܣ����벻��ȷ");
			return;
		}
		QingkeConsole.println("��ӭ������"+player.getName());
		BeSuperApplication.getInstance().setPlayerProfile(player);
	}
}
