package com.qingke.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.qingke.hibernate.bean.Apartment;

public class ApartmentDao {
	private Session session;
	public ApartmentDao(Session session){
		this.session=session;
	}
	public List<Apartment> lists(){
		Query<Apartment> query=session.createQuery("from Apartment",Apartment.class);
		return  query.getResultList();
	}
	public void insert(Apartment apartment){
		Transaction tx=session.beginTransaction();
		try{
		session.save(apartment);
		tx.commit();
		}catch(Exception e){
		e.printStackTrace();
		tx.rollback();
		}
	}
	public void update(Apartment apartment){
		Transaction tx=session.beginTransaction();
		try{
			session.update(apartment);
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}
	}
	public void delete(Apartment apartment){
		Transaction tx=session.beginTransaction();
				try{
					session.delete(apartment);
					tx.commit();
				}catch(Exception e){
					e.printStackTrace();
					tx.rollback();
				}
	}
}
