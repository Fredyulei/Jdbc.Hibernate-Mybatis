package com.qingke.hibernate.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.soap.SOAPBinding.Use;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.qingke.hibernate.bean.Education;
import com.qingke.hibernate.bean.Interest;
import com.qingke.hibernate.bean.Invitation;
import com.qingke.hibernate.bean.User;

public class UserDao {
	private Session session;

	public UserDao(Session session) {
		this.session = session;
	}

	public List<User> getu() {
		Query<User> query = session.createQuery("from User where height >= 165 and height <= 175 ", User.class);
		return query.getResultList();
	}

	public List<User> list() {
		Query<User> query = session.createQuery("from User", User.class);
		return query.getResultList();
	}

	public List<User> getlist() {
		Query<User> query = session.createQuery("from User where age > 15 and age <30 and gender='M'", User.class);
		return query.getResultList();
	}

	public void insert(User user) {
		Transaction tx = session.beginTransaction();
		try {
			session.save(user);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	public void update(User user) {
		Transaction tx = session.beginTransaction();
		try {
			session.update(user);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	public void delete(User user) {
		Transaction tx = session.beginTransaction();
		try {
			session.delete(user);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	public User getUserById(int id) {
		return session.get(User.class, id);
	}

	
	public List<Education> getLi(String gender) {
		
		Query<User> query = session.createQuery("from User where gender =:gender", User.class);
		query.setParameter("gender", gender);

		int ssId = query.getSingleResult().getId();

		Query<Education> query1 = session.createQuery("from Education where user_id =:ssId", Education.class);
		query1.setParameter("user_id", ssId);

		return query1.getResultList();

	}

	public List<User> getUser() {
		List<User> users = new ArrayList<User>();
		
		Query<Education> query = session.createQuery("from Education where school = :schools", Education.class);
		query.setParameter("schools", "Zjut");	
		List<Education> educations = query.getResultList();	
		for (Education education : educations) {
			System.out.println(education);
			int ssId = education.getUser().getId();
			System.out.println(ssId);
			Query<User> query1 = session.createQuery("from User where id =:sId and sex =:gen", User.class);
			query1.setParameter("sId", ssId);
			query1.setParameter("gen", "F");
			User user;
			try {
				user = query1.getSingleResult();
			} catch (Exception e) {
				continue;
			}		
			System.out.println(user);		
		}
		return users;
	}
	
public List<User> getGender(){
	List<User> users = new ArrayList<User>();
	Query<Education> query=session.createQuery("from Education where major =:major and school =:school",Education.class);
	//Õ¼Î»·û
	query.setParameter("major", "IT");
	query.setParameter("school", "zjut");
	List<Education> educations=query.getResultList();
	for (Education education : educations) {
		int ssID=education.getUser().getId();
		Query<User> query1=session.createQuery("from User where id=:sId and sex=:gen ",User.class);
		query1.setParameter("gen", "F");
		query1.setParameter("sId", ssID);
		User user;
		try {
			user = query1.getSingleResult();
		} catch (Exception e) {
			continue;
		}		
		System.out.println(user);		
	}
	return users;
				
}
	public List<User> getint() {
		
		Query<Interest> query = session.createQuery("from Interest where level >8", Interest.class);
		// int ssId=query.getSingleResult().getId();
		Query<User> query1 = session.createQuery("from User where interest_id=:ssId", User.class);
		// query1.setParameter("ssId", ssId);
		return query1.getResultList();
	}
	public User getinviter(){
		List<User> users = new ArrayList<User>();
		Query<Invitation> query=session.createQuery("from Invitation where is_accepted =:ac",Invitation.class);
		query.setParameter("ac", "Y");
		
		List<Invitation> inviter=query.getResultList();
		User maxUser = null;
		for(Invitation inv :inviter){
			int Id=inv.getUser().getId();
			Query<User> query1=session.createQuery("from User where id=:id and sex=:sex",User.class);
			query1.setParameter("id",Id);
			query1.setParameter("sex","M");
			
			List<User> user=query1.getResultList();
			Map<User,Integer> u=new HashMap<User,Integer>();
			for(User a : user){
				if(u.containsKey(a)){
					u.put(a, u.get(a)+1);
				}else{
					u.put(a, 1);
				}
				
			}
		
			int max=0;
			for(User a : user){
			if(u.get(a)>max){
				max=u.get(a);
				maxUser=a;
				}
			}
		}
			return maxUser;
//			User user;
//			try {
//				user = query1.getSingleResult();
//			} catch (Exception e) {
//				continue;
//			}		
//			System.out.println(user);		
			
	}
}