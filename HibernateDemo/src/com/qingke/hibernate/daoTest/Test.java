package com.qingke.hibernate.daoTest;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.qingke.hibernate.bean.Student;
import com.qingke.hibernate.dao.StudentDao;

public class Test {
	
	
		public static void main(String[] args) {
			try {
				SessionFactory sf = new Configuration().configure("xmlfolder/hibernate.cfg.xml").buildSessionFactory();
				Session session = sf.openSession();
				StudentDao dao=new StudentDao(session);
				//更新数据
				
				//Student student=dao.getStudentById(1);
				Student students=dao.getStudentByPhone("456");
			
				System.out.println(students.getAge());
				students.setGender("男");
			    dao.update(students);
				
				//System.out.println(student);
				session.close();
			} catch (HibernateException e) {
				e.printStackTrace();
			}
		}
	}

