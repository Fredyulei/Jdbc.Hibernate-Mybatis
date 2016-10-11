package com.qingke.hibernate.bean;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "username")
	private String username;
	@Column(name = "name")
	private String name;
	@Column(name = "age")
	private String age;
	@Column(name = "height")
	private String height;
	@Column(name = "sex")
	private String sex;
	@Column(name = "phone")
	private String phone;

//	@OneToOne
//	@PrimaryKeyJoinColumn
//	private UserPassword password;
	
	@OneToMany
	@JoinColumn(name = "user_id")
	private Set<Education> education;
	
	@OneToMany
	@JoinColumn(name = "user_id")
	private Set<Interest> interest;
	
	@OneToMany
	@JoinColumn(name = "inviter_user_id")
	private Set<Invitation> inviter;
	
	@OneToMany
	@JoinColumn(name = "invitee_user_id")
	private Set<Invitation> invitee;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getGender() {
		return sex;
	}
	public void setGender(String gender) {
		this.sex = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	//	public UserPassword getPassword() {
//		return password;
//	}
//	public void setPassword(UserPassword password) {
//		this.password = password;
//	}
//	
	public Set<Interest> getInterest() {
		return interest;
	}
	public void setInterest(Set<Interest> interest) {
		this.interest = interest;
	}
	public Set<Education> getEducation() {
		return education;
	}
	public void setEducation(Set<Education> education) {
		this.education = education;
	}

	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Set<Invitation> getInviter() {
		return inviter;
	}
	public void setInviter(Set<Invitation> inviter) {
		this.inviter = inviter;
	}
	public Set<Invitation> getInvitee() {
		return invitee;
	}
	public void setInvitee(Set<Invitation> invitee) {
		this.invitee = invitee;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", name=" + name + ", age=" + age + ", height=" + height
				+ ", gender=" + sex + ", phone=" + phone + "]";
	}

}
