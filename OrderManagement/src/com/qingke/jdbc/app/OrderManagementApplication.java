package com.qingke.jdbc.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.qingke.jdbc.command.Command;
import com.qingke.jdbc.command.CommandFactory;
import com.qingke.jdbc.command.CommandFactory.CommandCode;
import com.qingke.jdbc.content.Client;
import com.qingke.jdbc.util.QingkeConsole;

public class OrderManagementApplication {
	SessionFactory sf = new Configuration().configure("xmlfolder/hibernate.xml").buildSessionFactory();
	Session session = sf.openSession();
	private static OrderManagementApplication instance = null;
	public OrderManagementApplication() {

	}
	public static synchronized OrderManagementApplication getInstance() {
		if (instance == null) {
			instance = new OrderManagementApplication();
		}
		return instance;
	}
	private static Client clientProfile;

	public static void main(String[] args) {
		QingkeConsole.println("ou can use the \"HELP\" for command usage. Have fun!");
		while (true) {
			String cmd = QingkeConsole.askUserInput("cmd");
			CommandCode cmdCode = null;
			try {
				cmdCode = CommandCode.valueOf(cmd.toUpperCase());
			} catch (Exception e) {
				QingkeConsole.println("你输入了一个不合法的命令,请使用  Help 查看帮助");
				continue;
			}
			CommandFactory cFactory = CommandFactory.getFactory(OrderManagementApplication.getClientProfile());
			Command command = cFactory.buildCommand(cmdCode);
			command.execute();
		}
	}

	public static Client getClientProfile() {
		return clientProfile;
	}
	public void setClientProfile(Client client) {
		OrderManagementApplication.clientProfile = client;
	}
}
