package com.qingke.hibernatemana;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.qingke.hibernatemana.bean.Client;
import com.qingke.hibernatemana.bean.ClientLogin;
import com.qingke.hibernatemana.dao.ClientDao;

public class HibernateManagementApp {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure("xmlfolder/hibernate.cfg.xml").buildSessionFactory();
		Session session = sf.openSession();
		//�鿴���еĿͻ���Ϣ
		
		ClientDao dao = new ClientDao(session);
		List<Client> clients = dao.list();
		for (Client c : clients) {
			System.out.println(c);
		}
		System.out.println("======================================");
		//���ע�����Ϣ
		List<ClientLogin> logins=dao.login();
		for(ClientLogin cl :logins){
			System.out.println("login"+cl);
		}
	}
}
