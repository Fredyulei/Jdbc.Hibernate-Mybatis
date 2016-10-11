package com.qingke.hibernate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.qingke.hibernate.bean.Student;

public class RistrictionsDemo {
	public static void main(String[] args) {
		try {
			SessionFactory sf = new Configuration().configure("xmlfolder/hibernate.cfg.xml").buildSessionFactory();
			Session session = sf.openSession();
			Criteria criteria = session.createCriteria(Student.class);
			
//			criteria.add(Restrictions.eq("gender", "ÄÐ"));
//			criteria.add(Restrictions.eq("lastname", "ÕÅ"));
			
			Map<String,Object> params=new HashMap<String,Object>();
			params.put("gender", "ÄÐ");
			params.put("lastname", "ÕÅ");
			criteria.add(Restrictions.allEq(params));
			
			List students=criteria.list();
			for(Object obj :students){
				System.out.println(obj);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
}
