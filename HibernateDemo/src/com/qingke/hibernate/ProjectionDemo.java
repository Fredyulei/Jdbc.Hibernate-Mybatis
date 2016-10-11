package com.qingke.hibernate;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import com.qingke.hibernate.bean.Student;

public class ProjectionDemo {
	public static void main(String[] args) {
		try {
			SessionFactory sf = new Configuration().configure("xmlfolder/hibernate.cfg.xml").buildSessionFactory();
			Session session = sf.openSession();
			Student std = new Student();
			
			Criteria criteria = session.createCriteria(Student.class);
			ProjectionList projList=Projections.projectionList();
			projList.add(Projections.countDistinct("id"));
			projList.add(Projections.max("phone"));
			projList.add(Projections.groupProperty("gender"));
			criteria.setProjection(projList);
			List list = criteria.list();
			
			for (Object obj : list) {
				System.out.println(Arrays.toString((Object[])obj));
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
}
