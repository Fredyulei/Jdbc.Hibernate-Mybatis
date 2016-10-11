package com.qingke.jdbc.command;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public interface Command {
	//Session session = new Configuration().configure("xmlfolder/hibernate.xml").buildSessionFactory().openSession();
public abstract void execute();
}
