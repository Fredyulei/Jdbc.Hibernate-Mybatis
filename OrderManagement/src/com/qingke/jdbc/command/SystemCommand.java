package com.qingke.jdbc.command;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class SystemCommand implements Command {
	protected Session session = new Configuration().configure("xmlfolder/hibernate.xml").buildSessionFactory().openSession();
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

}
