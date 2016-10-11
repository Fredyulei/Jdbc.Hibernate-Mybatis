package com.qingke.app;

import com.qingke.command.Command;
import com.qingke.command.CommandFactory;
import com.qingke.command.CommandFactory.CommandCode;
import com.qingke.util.Console;

import test.domain.Users;

public class ApplicationTest {
	public ApplicationTest() {
		
	}
	
	private static ApplicationTest instance = new ApplicationTest();
	
	public static synchronized ApplicationTest getInstance() {
		if (instance == null) {
			instance = new ApplicationTest();
		}
		return instance;
	}
	
	private static Users clientProfile;
	
	public static void main(String[] args) {
	
		Console.println("��ӭʹ����Ϧ����įϵͳ,����������");
		while(true){
			String cmd = Console.Input("cmd");
			CommandCode cmdCode = null;
			try {
				cmdCode = CommandCode.valueOf(cmd.toUpperCase());
			} catch (Exception e) {
				Console.Input("���벻�Ϸ���������\"HELP\"Ѱ�����");
				continue;
			}			
			CommandFactory cf = CommandFactory.getFactory(ApplicationTest.getClientProfile());
			Command command = cf.buildCommand(cmdCode);
			command.execute();	
		}
	}

	public static Users getClientProfile() {
		return clientProfile;
	}

	public void setClientProfile(Users user) {
		ApplicationTest.clientProfile = user;
	}

}