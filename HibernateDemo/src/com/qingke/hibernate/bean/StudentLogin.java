package com.qingke.hibernate.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="student_login")
public class StudentLogin {
@Id
@Column(name="id")
private int id;
@Column(name="usename")
private String usename;
@Column(name="password")
private String password;

@OneToOne(mappedBy="login")
private Student student;



public int getId() {
	return id;
}



public void setId(int id) {
	this.id = id;
}



public String getUsename() {
	return usename;
}



public void setUsename(String usename) {
	this.usename = usename;
}



public String getPassword() {
	return password;
}



public void setPassword(String password) {
	this.password = password;
}



public Student getStudent() {
	return student;
}



public void setStudent(Student student) {
	this.student = student;
}



@Override
public String toString() {
	return "Student_login :[id=" + id + ", usename=" + usename + ", password=" + password + "]";
}

}
