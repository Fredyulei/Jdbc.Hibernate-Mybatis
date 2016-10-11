package com.qingke.jdbc.command;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.qingke.jdbc.content.Client;

public abstract class CommandFactory {
	protected Session session = new Configuration().configure("xmlfolder/hibernate.xml").buildSessionFactory().openSession();
	public static enum CommandCode {
		// sysytem
		HELP, 
		EXIT, 
		LOGIN, 
		SIGNUP,
		// CLIENT
		ORDER, 
		PAYMENT, 
		PRODUCT, 
		TRANSACTION, 
		LIST,
		
	}
	public static CommandFactory getFactory(Client client) {
		if (client == null) {
			return new SystemCommandFactory();
		}
		return new ClientCommandFactory(client);
	}
	public abstract Command buildCommand(CommandCode cmd);
}
