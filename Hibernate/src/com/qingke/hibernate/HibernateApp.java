package com.qingke.hibernate;

import java.util.List;

import javax.security.auth.login.Configuration;

public class HibernateApp {
public static void main(String[] args ){
	try{
		SessionFactory sf=	
			new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		NativeQuery query=session.createNativeQuery("select*from player");
		List<E> list=query.getResultList();
		System.out.println("find recodes"+list.size());
		session.close();
}catch(HibernateException e){
	e.printStackTrace();
}
}
}