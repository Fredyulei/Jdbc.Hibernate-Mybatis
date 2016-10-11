package com.qingke.jdbc.command;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.qingke.jdbc.content.Client;
import com.qingke.jdbc.util.QingkeConsole;

public abstract class ClientCommand implements Command {
	protected Session session = new Configuration().configure("xmlfolder/hibernate.xml").buildSessionFactory().openSession();
	protected Client client;
 public ClientCommand(){
	 
 }
 public ClientCommand(Client client){
	 this.client=client;
 }
 public void execute(){
	 if(client==null){
		 QingkeConsole.println("系统用户不存在");
	 }
	 executeClientCommand();
 }
 public abstract void executeClientCommand();
	
}
