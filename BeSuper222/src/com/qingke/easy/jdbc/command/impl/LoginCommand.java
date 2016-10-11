package com.qingke.easy.jdbc.command.impl;

import com.qingke.easy.Player;
import com.qingke.easy.jdbc.app.BeSuperApplication;
import com.qingke.easy.jdbc.app.BesuperDao;
import com.qingke.easy.jdbc.command.SystemCommand;
import com.qingke.jdbcapp.util.QingkeConsole;

public class LoginCommand extends SystemCommand {

	public void execute() {
		BesuperDao dao = new BesuperDao();
		String username = QingkeConsole.askUserInput("请输入用户名");
		while (!dao.isUsernameExists(username)) {
			QingkeConsole.println("用户名不存在");
			username = QingkeConsole.askUserInput("请输入用户名");
		}
		String password = QingkeConsole.askUserInput("请输入密码");
		Player player = dao.login(username, password);
	
		if (player == null) {
			QingkeConsole.println("登陆失败！密码不正确");
			return;
		}
		QingkeConsole.println("欢迎您回来"+player.getName());
		BeSuperApplication.getInstance().setPlayerProfile(player);
	}
}
