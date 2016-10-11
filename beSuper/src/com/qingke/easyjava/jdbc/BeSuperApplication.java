package com.qingke.easyjava.jdbc;

import com.qingke.easyjava.jdbc.command.CommandFactory;
import com.qingke.easyjava.jdbc.command.Command;
import com.qingke.easyjava.jdbc.command.CommandFactory.CommandCode;
import com.qingke.easyjava.jdbcapp.pojo.Player;
import com.qingke.easyjava.jdbcapp.util.QingkeConsole;

public class BeSuperApplication {
	// l. ����ʽ������ : �ڵ�һ�ε��õ�ʱ��ʵ�����Լ�
	// 2. ����ʽ������ : �����ʼ����ʱ��,�Ѿ�����ʵ����

	// ����ģʽֱ��ʵ����
	private static BeSuperApplication instance = new BeSuperApplication();

	private BeSuperApplication() {
	}

	// Ϊ����ģʽ����synchronized��ȫ��(����ģʽ�Ƿ��̰߳�ȫ��)
	public static synchronized BeSuperApplication getInstance() {
		if (instance == null) {
			instance = new BeSuperApplication();
		}
		return instance;
	}

	private static Player playerProfile;

	public static void main(String[] args) {
		//start
		QingkeConsole.println("you can see \"HELP\" for command usage. Have fun!");

		// SystemCommandFactory factory = new SystemCommandFactory();

		while (true) {
			String cmd = QingkeConsole.askUserInput("cmd");
//			 if (cmd.equalsIgnoreCase("exit")){
//			 doExit();
//			 } else if (cmd.equalsIgnoreCase("help")) {
//			 doPrintUsage();
//			 }
//			 Command command = factory.buliCommand(cmd);
			CommandCode cmdCode = null;
			try {
				cmdCode = CommandCode.valueOf(cmd.toUpperCase());
			} catch (Exception e) {
				QingkeConsole.println("��������һ�����Ϸ�������,��ʹ��  Help �鿴����");
				continue;
			}
			CommandFactory cFactory = CommandFactory.getFactory(BeSuperApplication.getPlayerProfile());
			//Command command = cFactory.buildCommand(cmd);
			Command command = cFactory.buildCommand(cmdCode);
			command.execute();
			
		}
	}

	public static Player getPlayerProfile() {
		return playerProfile;
	}

	 private static void doExit(){
	 System.exit(0);
	 }
	
	 public static void doPrintUsage() {
	 QingkeConsole.println("------------- I want to be Ba commands -------------");
	 QingkeConsole.println("= EXIT  - Exit the application");
	 QingkeConsole.println("= HELP  - Print command usage");
	 QingkeConsole.println("= LOGIN  - Login the appllication");
	 QingkeConsole.println("= SIGNUP  - Sign up an player account");
	 QingkeConsole.println("= LIST  - Ask a question");
	 QingkeConsole.println("= ANSWER  - Answer a question");
	 QingkeConsole.println("= ACCEPT  - set best answer for a question");
	 QingkeConsole.println("= SCORE  - Show palyer's score");
	 }
}
