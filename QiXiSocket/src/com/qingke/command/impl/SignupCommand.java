package com.qingke.command.impl;

import java.util.regex.Pattern;

import com.qingke.app.ApplicationTest;
import com.qingke.app.TestMyBatis;
import com.qingke.command.Command;
import com.qingke.util.Console;

import test.domain.Users;

public class SignupCommand implements Command {

	@Override
	public void execute() {
		TestMyBatis tesrMyBaytis = new TestMyBatis(null);
		String username = Console.Input("请输入用户名");
		
		while(tesrMyBaytis.isUsernameExit(username)) {
			Console.println("用户名已存在");
			username = Console.Input("请重新输入用户名");
		}
		String password = null;
		
		while(true) {	
			try {
				password = Console.Input("请输入密码");
				validatePassword(password);
				break;
			} catch (Exception e) {
				Console.println("密码格式不正确 --" + e.getMessage());
				continue;
			}
		}
		
		String name = Console.Input("请输入您的真实姓名");
		String age = Console.Input("请输入您的年龄");
		String height = Console.Input("请输入您的身高");
		String weight = Console.Input("请输入您的体重");
		String gender = Console.Input("请输入您的性别");
		String phone = Console.Input("请输入您的电话");
		Users user = tesrMyBaytis.signup(username,password,name,age,height,weight,gender,phone);
		ApplicationTest.getInstance().setClientProfile(user);		
	}
	
	private void validatePassword(String password) throws Exception {
		Pattern lenPattern = Pattern.compile("[0-9a-zA-Z]{6,}");
		if (!lenPattern.matcher(password).find()){
			throw new Exception("密码长度大于等于6位");
		}
		Pattern numPattern = Pattern.compile("[0-9a-zA-Z]");
		if (!numPattern.matcher(password).find()){
			throw new Exception("密码至少一位数字");
		}
		Pattern wordPattern = Pattern.compile("[a-zA-Z]");
		if (!wordPattern.matcher(password).find()){
			throw new Exception("密码至少一位字符");
		}
	
	}

}
