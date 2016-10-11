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
		String username = Console.Input("�������û���");
		
		while(tesrMyBaytis.isUsernameExit(username)) {
			Console.println("�û����Ѵ���");
			username = Console.Input("�����������û���");
		}
		String password = null;
		
		while(true) {	
			try {
				password = Console.Input("����������");
				validatePassword(password);
				break;
			} catch (Exception e) {
				Console.println("�����ʽ����ȷ --" + e.getMessage());
				continue;
			}
		}
		
		String name = Console.Input("������������ʵ����");
		String age = Console.Input("��������������");
		String height = Console.Input("�������������");
		String weight = Console.Input("��������������");
		String gender = Console.Input("�����������Ա�");
		String phone = Console.Input("���������ĵ绰");
		Users user = tesrMyBaytis.signup(username,password,name,age,height,weight,gender,phone);
		ApplicationTest.getInstance().setClientProfile(user);		
	}
	
	private void validatePassword(String password) throws Exception {
		Pattern lenPattern = Pattern.compile("[0-9a-zA-Z]{6,}");
		if (!lenPattern.matcher(password).find()){
			throw new Exception("���볤�ȴ��ڵ���6λ");
		}
		Pattern numPattern = Pattern.compile("[0-9a-zA-Z]");
		if (!numPattern.matcher(password).find()){
			throw new Exception("��������һλ����");
		}
		Pattern wordPattern = Pattern.compile("[a-zA-Z]");
		if (!wordPattern.matcher(password).find()){
			throw new Exception("��������һλ�ַ�");
		}
	
	}

}
