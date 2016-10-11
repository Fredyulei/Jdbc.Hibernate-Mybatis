package com.qingke.jdbc.command.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.qingke.jdbc.app.OrderManagementDao;
import com.qingke.jdbc.command.ClientCommand;
import com.qingke.jdbc.content.Client;
import com.qingke.jdbc.content.Production;
import com.qingke.jdbc.util.QingkeConsole;

public class ProductCommand extends ClientCommand{
	SessionFactory sf = new Configuration().configure("xmlfolder/hibernate.xml").buildSessionFactory();
	Session session = sf.openSession();
	OrderManagementDao dao=new OrderManagementDao(session);
	
	public ProductCommand(Client client) {
		super(client);
	
	}

	private Client client;
	public void execute() {
	
		Production product=null;
		
	
		QingkeConsole.println("========"+client.getName()+"======");
		QingkeConsole.println("总订单");

		//System.out.println(dao.getdescription(1));
		//QingkeConsole.println("总商品"+dao.);
		
	}
	@Override
	public void executeClientCommand() {
		// TODO Auto-generated method stub
		
	}

}
