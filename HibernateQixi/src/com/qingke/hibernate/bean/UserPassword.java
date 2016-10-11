package com.qingke.hibernate.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_password")
public class UserPassword {
	@Id
	@Column(name = "user_id")
	private int user_id;
	@Column(name = "password")
	private String password;
	@OneToOne(mappedBy="password")
	private User user;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "UserPassword [user_id=" + user_id + ", password=" + password + "]";
	}
	
}
