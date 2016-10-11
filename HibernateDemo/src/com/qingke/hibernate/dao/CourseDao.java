package com.qingke.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.qingke.hibernate.bean.Course;

public class CourseDao {
	private Session session;
	public CourseDao(Session session){
		this.session=session;
	}
	
	public List<Course> getcourse(){
		Query<Course> query=session.createQuery("from Course",Course.class);
		return query.getResultList();
	}
	public void insert(Course course){
		Transaction tx=session.beginTransaction();
		try{
		session.save(course);
		tx.commit();
		}catch(Exception e){
		e.printStackTrace();
		tx.rollback();
		}
	}
	public void update(Course course){
		Transaction tx=session.beginTransaction();
		try{
			session.update(course);
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}
	}
	public void delete(Course course){
		Transaction tx=session.beginTransaction();
				try{
					session.delete(course);
					tx.commit();
				}catch(Exception e){
					e.printStackTrace();
					tx.rollback();
				}
	}
}
