package com.qingke.jdbc.command.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.qingke.jdbc.app.OrderManagementDao;
import com.qingke.jdbc.command.Command;

public class ExitCommand implements Command{
	SessionFactory sf = new Configuration().configure("xmlfolder/hibernate.xml").buildSessionFactory();
	Session session = sf.openSession();

	@Override
	public void execute() {
		OrderManagementDao dao=new OrderManagementDao(session);

	}

}
