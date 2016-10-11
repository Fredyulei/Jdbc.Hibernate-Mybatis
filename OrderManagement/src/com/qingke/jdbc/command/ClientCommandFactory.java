package com.qingke.jdbc.command;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.qingke.jdbc.command.CommandFactory.CommandCode;
import com.qingke.jdbc.command.impl.ListCommand;
import com.qingke.jdbc.command.impl.OrderCommand;
import com.qingke.jdbc.command.impl.PaymentCommand;
import com.qingke.jdbc.command.impl.ProductCommand;
import com.qingke.jdbc.command.impl.TransactionCommand;
import com.qingke.jdbc.content.Client;



public class ClientCommandFactory extends CommandFactory{
	protected Session session = new Configuration().configure("xmlfolder/hibernate.xml").buildSessionFactory().openSession();
	
	private static Map<CommandCode, Class<? extends Command>> commandMap = new HashMap<>();
	static {
		commandMap.put(CommandCode.ORDER, OrderCommand.class);
		commandMap.put(CommandCode.LIST, ListCommand.class);
		commandMap.put(CommandCode.PAYMENT, PaymentCommand.class);
		commandMap.put(CommandCode.PRODUCT, ProductCommand.class);		
		commandMap.put(CommandCode.TRANSACTION, TransactionCommand.class);		
			
	}
	private Client client;
	public ClientCommandFactory(Client client){
		this.client=client;
	}
		public Command buildCommand(CommandCode cmdCode){
			Command command = null;
			Class<? extends Command> cmdClass = commandMap.get(cmdCode);
			if (cmdClass != null) {
				try {
					command = cmdClass.getConstructor(Client.class).newInstance(client);
				} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
						| InvocationTargetException | NoSuchMethodException | SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			return command;

		}
	}
