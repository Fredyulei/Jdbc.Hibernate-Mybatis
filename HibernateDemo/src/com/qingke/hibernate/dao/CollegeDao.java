package com.qingke.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.qingke.hibernate.bean.Apartment;
import com.qingke.hibernate.bean.College;

public class CollegeDao {
	private Session session;
	public CollegeDao(Session session){
		this.session=session;
	}
	public List<College> lists(){
		Query<College> query=session.createQuery("from College",College.class);
		return  query.getResultList();
	}
	public void insert(College college){
		Transaction tx=session.beginTransaction();
		try{
		session.save(college);
		tx.commit();
		}catch(Exception e){
		e.printStackTrace();
		tx.rollback();
		}
	}
	public void update(College college){
		Transaction tx=session.beginTransaction();
		try{
			session.update(college);
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}
	}
	public void delete(College college){
		Transaction tx=session.beginTransaction();
				try{
					session.delete(college);
					tx.commit();
				}catch(Exception e){
					e.printStackTrace();
					tx.rollback();
				}
	}
}
