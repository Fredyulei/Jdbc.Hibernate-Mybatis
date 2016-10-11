package com.qingke.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.qingke.hibernate.bean.Student;

public class JunctionDemo {
	public static void main(String[] args) {
		try {
			SessionFactory sf = new Configuration().configure("xmlfolder/hibernate.cfg.xml").buildSessionFactory();
			Session session = sf.openSession();
			Property gen=Property.forName("gender");
			Property lastname=Property.forName("lastname");
			
		
			Criteria criteria = session.createCriteria(Student.class);
			criteria.add(Restrictions.conjunction().add(gen.eq("ÄÐ")).add(lastname.like("ÕÅ")));
			
			List<Student> students = criteria.list();
			
			for (Object obj : students) {
				System.out.println(obj);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
}
