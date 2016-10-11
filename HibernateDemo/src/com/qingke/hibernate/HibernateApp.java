package com.qingke.hibernate;

import java.util.List;
import java.util.Scanner;

import javax.transaction.Transaction;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.qingke.hibernate.bean.Apartment;
import com.qingke.hibernate.bean.Course;
import com.qingke.hibernate.bean.Student;
import com.qingke.hibernate.bean.StudentStatus;
import com.qingke.hibernate.bean.Student_status;
import com.qingke.hibernate.bean.Teacher;
import com.qingke.hibernate.dao.ApartmentDao;
import com.qingke.hibernate.dao.CourseDao;
import com.qingke.hibernate.dao.StudentDao;

public class HibernateApp {
	// private static Scanner scanner=new Scanner(System.in);
	public static void main(String[] args) {
		try {
			SessionFactory sf = new Configuration().configure("xmlfolder/hibernate.cfg2.xml").buildSessionFactory();
			Session session = sf.openSession();

			// StudentStatus stat=session.get(StudentStatus.class,1);
			// System.out.println(stat);

			// session.clear();
			// StudentStatus stat=null;
			// stat=session.get(StudentStatus.class, 1);
			// System.out.println(stat);

			// 宿舍信息
			StudentDao dao = new StudentDao(session);
			// ApartmentDao dao=new ApartmentDao(session);
			// List<Apartment> apartments = dao.lists();
			// for (Apartment ap : apartments) {
			// System.out.println(ap);
			// }
			// Student student = dao.getStudentById(1);
			// System.out.println("apartment:" + student.getApartment());
			// System.out.println("-------------------------");
			// Apartment ap = session.get(Apartment.class, 1);
			// System.out.println("apartment :" + ap);
			// System.out.println("apartment student : " +
			// ap.getStudents().size());
			// System.out.println("=============================");
			// Apartment apartment=new Apartment();
			// apartment.setBed(4);
			// apartment.setBuilding("5");
			// apartment.setFloor(3);
			// apartment.setFoom(5);
			// apartment.setId(716);
			// dao.insert(apartment);
			//
			// apartment.setBed(1);;
			// dao.update(apartment);
			//
			// CourseDao dao=new CourseDao(session);
			// List<Course> a=dao.getcourse();
			// for(Course b : a){
			// System.out.println(b);
			// }
			//

			// Student studentss = session.get(Student.class, 1);
			// System.out.println(studentss.getLastname() +
			// studentss.getFirstname());

			//
			// Student student=dao.getStudentById(111);
			//
			// System.out.println("------Many to Many------");
			// System.out.println("student
			// teachers:"+student.getTeachers().size());
			// Teacher teacher=session.get(Teacher.class, 1);
			// System.out.println("teachers:"+teacher);
			// System.out.println("teacher
			// students:"+teacher.getStudents().size());
			// System.out.println(student);
			// System.out.println(student.getLogin());
			// System.out.println("---------------------------");
			// System.out.println("student status :"+student.getStatus());
			//
			//	// System.out.println("status :"+status);
			// Student students= session.get(Student.class, 1);
			// System.out.println(students.getStatus());
			Student st = session.get(Student.class, 1);
			System.out.println("qwer"+st.getStatus()); 
			StudentStatus status = session.get(StudentStatus.class, 1);

			System.out.println("student" + status.getName());
			System.out.println("个数 :" + status.getStudents().size());

			System.out.println("=============================");
			List<Student> students = dao.getLi("在读");
			for (Student student : students) {
				
				System.out.println(student);
				
			}
			// 学生的一些查询信息
			// List<Student>students=dao.list();
			// for(Student st:students){
			// System.out.println(st);
			// }
			//
			// students=dao.listByName("小");
			// for(Student st:students){
			// System.out.println(st.getFirstname());
			// }
			// 插入数据
			// Student student=new Student();
			// Student student=dao.getStudentById(3);
			// student.setId(115);
			// student.setSide(201208);
			// student.setFirstname("八");
			// student.setLastname("孙");
			// student.setEmail("@asdfsdas");
			// student.setGender("女");
			// student.setAge(23);
			// student.setPhone("1231213");
			// student.setBirthday("5.25");
			//
			// dao.insert(student);
			// System.out.println("Press 'ENTER' to continue....");
			// scanner.nextLine();
			//
			// student.setGender("女");
			// dao.update(student);
			// System.out.println("Press 'ENTER' to continue....");
			//
			// scanner.nextLine();
			// dao.delete(student);
			//
			//
			//
			// NativeQuery query=session.createNativeQuery("select*from
			// student");
			// List list=query.getResultList();
			// System.out.println("find recodes:"+list.size());
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
}