package com.qingke.hibernate.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.qingke.hibernate.bean.Apartment;
import com.qingke.hibernate.bean.Report;
import com.qingke.hibernate.bean.Student;
import com.qingke.hibernate.bean.StudentStatus;
import com.qingke.hibernate.bean.Student_status;


public class StudentDao {
	// 会话控制
	private Session session;

	// 使用连接
	public StudentDao(Session session) {
		this.session = session;
	}
	//student集合
	public List<Student> list() {
		Query<Student> query = session.createQuery("from Student", Student.class);
		return query.getResultList();
	}
	
	public List<Student>listByName(String name){
		
		Query<Student> query=session.createQuery("from Student where firstname like :name or lastname like :name",Student.class);
		query.setParameter("name", "%"+name+"%");
		return query.getResultList();
	}
	public List<Apartment> lists(){
		
		Query<Apartment> query=session.createQuery("from Apartment",Apartment.class);
		return  query.getResultList();
	}
	public Student getStudentById(int id){
		return session.get(Student.class, id);
	}
	public Student getStudentByPhone(String phone){
		return session.get(Student.class, phone);
	}
	public void insert(Apartment apartment){
		Transaction tx=session.beginTransaction();
		try{
		session.save(apartment);
		tx.commit();
		}catch(HibernateException e){
			e.printStackTrace();
			tx.rollback();
		}
	}
	public void update(Student student){
		Transaction tx=session.beginTransaction();
		try{
			session.update(student);
			tx.commit();
		}catch(HibernateException e){
			e.printStackTrace();
			tx.rollback();
		}
	}
	public void delete(Student student){
		Transaction tx=session.beginTransaction();
		try{
			session.delete(student);
			tx.commit();
		}catch(HibernateException e){
			e.printStackTrace();
			tx.rollback();
		}
	}
	public List<Report> lis(){
		Query<Report> query=session.createQuery("from Report",Report.class);
		return query.getResultList();
	}
	public List<StudentStatus>listl(){
		Query<StudentStatus> query=session.createQuery("from StudentStatus",StudentStatus.class);
		return query.getResultList();
	}
	public List<Student> getLi(String name){
		
		Query<StudentStatus> query=session.createQuery("from StudentStatus where name =:ssName",StudentStatus.class);
		query.setParameter("ssName", name);
		
		int ssId = query.getSingleResult().getId();
		
		Query<Student> query1=session.createQuery("from Student where student_status_id =:ssId",Student.class);
		query1.setParameter("ssId", ssId);
		
		return query1.getResultList();
	}
	
}
