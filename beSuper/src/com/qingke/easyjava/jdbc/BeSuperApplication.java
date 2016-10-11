package com.qingke.easyjava.jdbc;

import com.qingke.easyjava.jdbc.command.CommandFactory;
import com.qingke.easyjava.jdbc.command.Command;
import com.qingke.easyjava.jdbc.command.CommandFactory.CommandCode;
import com.qingke.easyjava.jdbcapp.pojo.Player;
import com.qingke.easyjava.jdbcapp.util.QingkeConsole;

public class BeSuperApplication {
	// l. 懒汉式单例类 : 在第一次调用的时候实例化自己
	// 2. 饿汗式单例类 : 在类初始化的时候,已经自行实例化

	// 饿汉模式直接实例化
	private static BeSuperApplication instance = new BeSuperApplication();

	private BeSuperApplication() {
	}

	// 为懒汉模式加上synchronized安全锁(懒汉模式是非线程安全的)
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
				QingkeConsole.println("你输入了一个不合法的命令,请使用  Help 查看帮助");
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
