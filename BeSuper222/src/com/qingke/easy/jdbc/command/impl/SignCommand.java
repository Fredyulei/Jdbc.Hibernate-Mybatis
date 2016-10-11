package com.qingke.easy.jdbc.command.impl;

import java.util.regex.Pattern;

import com.qingke.easy.Player;
import com.qingke.easy.jdbc.app.BeSuperApplication;
import com.qingke.easy.jdbc.app.BesuperDao;
import com.qingke.easy.jdbc.command.SystemCommand;
import com.qingke.jdbcapp.util.QingkeConsole;
//注册用户
public class SignCommand extends SystemCommand {
	public void execute() {
		//数据库入口，创建一个实例
		BesuperDao dao = new BesuperDao();
		String username = QingkeConsole.askUserInput("请输入用户名");
		//判断用户名是否在数据库中存在
		while (dao.isUsernameExists(username)) {
			QingkeConsole.println("用户名已存在");
			username = QingkeConsole.askUserInput("请重新输入用户名");
		}
		String passwords = null;
		while (true) {
			passwords = QingkeConsole.askUserInput("请输入密码");
			try {
				//
				validatePasswords(passwords);
				break;
			} catch (Exception e) {
				QingkeConsole.println("密码格式不对！" + e.getMessage());
				continue;
			}
		}
		//定义一个昵称
		String nickname = QingkeConsole.askUserInput("请输入昵称");
		//调用方法
		Player player = dao.signup(username, passwords, nickname);
		//调用单例。获得当前用户
		BeSuperApplication.getInstance().setPlayerProfile(player);
	}
//验证密码 只是个方法
	private void validatePasswords(String passwords) throws Exception{
		//模式
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
