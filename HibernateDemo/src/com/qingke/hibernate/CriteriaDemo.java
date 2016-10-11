package com.qingke.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.DetachedCriteria;

import com.qingke.hibernate.bean.Student;

public class CriteriaDemo {
	public static void main(String[] args) {
		try {
			SessionFactory sf = new Configuration().configure("xmlfolder/hibernate.cfg.xml").buildSessionFactory();
			Session session = sf.openSession();
			Criteria criteria = session.createCriteria(Student.class);
			List students = criteria.list();
			for (Object obj : students) {
				System.out.println(obj);
			}
			DetachedCriteria c = DetachedCriteria.forClass(Student.class);
			Criteria cc = c.getExecutableCriteria(session);
			System.out.println("===============Detached  Criteria===============");
			List stds = criteria.list();
			for (Object ob : stds) {
				System.out.println(ob);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
}
