package com.qingke.jdbc.command;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.qingke.jdbc.command.CommandFactory.CommandCode;
import com.qingke.jdbc.command.impl.ExitCommand;
import com.qingke.jdbc.command.impl.HelpCommand;
import com.qingke.jdbc.command.impl.ListCommand;
import com.qingke.jdbc.command.impl.LoginCommand;
import com.qingke.jdbc.command.impl.OrderCommand;
import com.qingke.jdbc.command.impl.PaymentCommand;
import com.qingke.jdbc.command.impl.ProductCommand;
import com.qingke.jdbc.command.impl.SignCommand;
import com.qingke.jdbc.command.impl.TransactionCommand;

public class SystemCommandFactory extends CommandFactory {
	protected Session session = new Configuration().configure("xmlfolder/hibernate.xml").buildSessionFactory().openSession();
	private static Map<CommandCode, Class<? extends Command>> commandMap = new HashMap<>();

	static {
		commandMap.put(CommandCode.EXIT, ExitCommand.class);
		commandMap.put(CommandCode.HELP, HelpCommand.class);
		commandMap.put(CommandCode.LOGIN, LoginCommand.class);
		commandMap.put(CommandCode.SIGNUP, SignCommand.class);
		commandMap.put(CommandCode.ORDER, OrderCommand.class);
		commandMap.put(CommandCode.LIST, ListCommand.class);
		commandMap.put(CommandCode.PAYMENT, PaymentCommand.class);
		commandMap.put(CommandCode.PRODUCT, ProductCommand.class);		
		commandMap.put(CommandCode.TRANSACTION, TransactionCommand.class);		
		
	}

	public Command buildCommand(CommandCode cmdCode) {
		Class<? extends Command> cmdClass = commandMap.get(cmdCode);

		Command command = null;
		try {
			command = cmdClass.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return command;
	}
}
