package com.qingke.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;

import com.qingke.hibernate.bean.Student;

public class ExampleDemo {
	public static void main(String[] args) {
		try {
			SessionFactory sf = new Configuration().configure("xmlfolder/hibernate.cfg.xml").buildSessionFactory();
			Session session = sf.openSession();
			Student std = new Student();
			std.setLastname("Àî");
			std.setGender("ÄÐ");
			
			Example studentExample = Example.create(std);
			studentExample.excludeZeroes();
			Criteria criteria = session.createCriteria(Student.class);
			criteria.add(studentExample);
			
			List<Student> students = criteria.list();
			
			for (Object obj : students) {
				System.out.println(obj);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
}
