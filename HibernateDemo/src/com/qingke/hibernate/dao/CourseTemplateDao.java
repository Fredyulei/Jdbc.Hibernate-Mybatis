package com.qingke.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.qingke.hibernate.bean.CourseTemplate;

public class CourseTemplateDao {
	private Session session;
	public CourseTemplateDao(Session session){
		this.session=session;
	}
	public List<CourseTemplate> lists(){
		Query<CourseTemplate> query=session.createQuery("from CourseTemplate",CourseTemplate.class);
		return  query.getResultList();
	}
	public void insert(CourseTemplate coursetemplate){
		Transaction tx=session.beginTransaction();
		try{
		session.save(coursetemplate);
		tx.commit();
		}catch(Exception e){
		e.printStackTrace();
		tx.rollback();
		}
	}
	public void update(CourseTemplate coursetemplate){
		Transaction tx=session.beginTransaction();
		try{
			session.update(coursetemplate);
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}
	}
	public void delete(CourseTemplate coursetemplate){
		Transaction tx=session.beginTransaction();
				try{
					session.delete(coursetemplate);
					tx.commit();
				}catch(Exception e){
					e.printStackTrace();
					tx.rollback();
				}
	}
}
