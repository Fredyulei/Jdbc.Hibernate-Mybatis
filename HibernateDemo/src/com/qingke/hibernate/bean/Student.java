package com.qingke.hibernate.bean;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Table(name = "student")
@Entity
public class Student {

	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "side")
	private int side;
	@Column(name = "firstname")
	private String firstname;
	@Column(name = "lastname")
	private String lastname;
	@Column(name = "gender")
	private String gender;
	@Column(name = "phone")
	private String phone;
	@Column(name = "email")
	private String email;
	@Column(name = "birthday")
	private String birthday;
	@Column(name = "age")
	private int age;

//	@ManyToOne
//	@JoinColumn(name="apartment_id")
//	private Apartment apartment;
	@ManyToOne
	@JoinColumn(name = "student_status_id")
	private StudentStatus status;

//	@OneToOne
//	@PrimaryKeyJoinColumn
//	private StudentLogin login;

//	@ManyToMany
//	@JoinTable(name = "teacher_has_student", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "teacher_id"))
//	private Set<Teacher> teachers;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSide() {
		return side;
	}

	public void setSide(int side) {
		this.side = side;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

//	public StudentLogin getLogin() {
//		return login;
//	}

//	public void setLogin(StudentLogin login) {
//		this.login = login;
//	}

	public StudentStatus getStatus() {
		return status;
	}

	public void setStatus(StudentStatus status) {
		this.status = status;
	}

//	public Set<Teacher> getTeachers() {
//		return teachers;
//	}

//	public void setTeachers(Set<Teacher> teachers) {
//		this.teachers = teachers;
//	}

//	public Apartment getApartment() {
//		return apartment;
//	}
//
//	public void setApartment(Apartment apartment) {
//		this.apartment = apartment;
//	}

	@Override
	public String toString() {
		return "Student : [id=" + id + ", side=" + side + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", gender=" + gender + ", phone=" + phone + ", email=" + email + ", birthday=" + birthday + ", age="
				+ age + "]";
	}

}