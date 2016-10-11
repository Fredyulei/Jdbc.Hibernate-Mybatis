package com.qingke.hibernatemana.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Table(name = "client")
@Entity
public class Client {
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "gender")
	private String gender;
	@Column(name = "phone")
	private String phone;
	@Column(name = "location")
	private String location;
	// @Column(name="username")
	// private String username;
	// @Column(name="password")
	// private String password;
	@Column(name = "balance")
	private String balabce;
	@OneToOne
	@PrimaryKeyJoinColumn
	private ClientLogin login;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	// public String getUsername() {
	// return username;
	// }
	// public void setUsername(String username) {
	// this.username = username;
	// }
	// public String getPassword() {
	// return password;
	// }
	// public void setPassword(String password) {
	// this.password = password;
	// }
	public String getBalabce() {
		return balabce;
	}

	public void setBalabce(String balabce) {
		this.balabce = balabce;
	}

	public ClientLogin getLogin() {
		return login;
	}

	public void setLogin(ClientLogin login) {
		this.login = login;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", gender=" + gender + ", phone=" + phone + ", location="
				+ location + ", balabce=" + balabce + "]";
	}

}
