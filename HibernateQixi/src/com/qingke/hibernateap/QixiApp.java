package com.qingke.hibernateap;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.qingke.hibernate.bean.Education;
import com.qingke.hibernate.bean.User;
import com.qingke.hibernate.dao.UserDao;

public class QixiApp {

	public static void main(String[] args) {
		try {
			SessionFactory sf = new Configuration().configure("xmlfolder/hibernate.xml").buildSessionFactory();
			Session session = sf.openSession();
			UserDao dao = new UserDao(session);
		
			//用户，学历
//			List<User> client = dao.list();
//			for (User c : client) {
//				System.out.println(c+""+c.getEducation());
//			}
			
//			List<User> clients = dao.getint();
//			for (User c : clients) {
//				System.out.println(c+""+c.getInterest());
//			}
			User us = dao.getinviter();
			System.out.println(us);
		System.out.println("====================");
			List<User> users = dao.getUser();
			for (User st : users) {
				System.out.println(st);			
			}	
			List<User> user = dao.getGender();
			for (User st : user) {
				System.out.println(st);			
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

}
