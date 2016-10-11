package com.qingke.hibernate.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.qingke.hibernate.bean.Invitation;

public class InvitationDao {
	private Session session;

	public InvitationDao(Session session) {
		this.session = session;
	}

	public void insert(Invitation invitation) {
		Transaction tx = session.beginTransaction();
		try {
			session.save(invitation);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	public void update(Invitation invitation) {
		Transaction tx = session.beginTransaction();
		try {
			session.update(invitation);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	public void delete(Invitation invitation) {
		Transaction tx = session.beginTransaction();
		try {
			session.delete(invitation);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

}
