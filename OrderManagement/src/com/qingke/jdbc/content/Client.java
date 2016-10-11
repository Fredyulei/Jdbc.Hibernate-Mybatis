package com.qingke.jdbc.content;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="client")
public class Client  {
	@Id
	@Column(name="id")
	private long id;
	@Column(name="name")
	private String name;
	@Column(name="gender")
	private String gender;
	@Column(name="phone")
	private String phone;
	@Column(name="location")
	private String location;
	@Column(name="balance")
	private Double balance;
	@Column(name="username")
	private String username;
	private String password;
//	@OneToMany
//	@JoinColumn(name="production_id")
//	private Set<Production> productions;
	//private List<Order> orders;
	//private List<Production> productions;

	public Client() {
	}
	
	public Client(long id, String name,String phone,String location,String gender) {
		this.id = id;
		this.name = name;
		this.phone=phone;
		this.location=location;
		this.gender=gender;
//		this.orders = new ArrayList<Order>();
//		this.productions = new ArrayList<Production>();
	}
	public Client(long id, String name,String phone,String location){
		this.id = id;
		this.name = name;
		this.phone=phone;
		this.location=location;
	}
	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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
		this.location =location;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	public Set<Production> getProductions() {
//		return productions;
//	}
//
//	public void setProductions(Set<Production> productions) {
//		this.productions = productions;
//	}
//	
//	public List<Order> getOrders() {
//		return orders;
//	}
//
//	public void setOrders(List<Order> orders) {
//		this.orders = orders;
//	}
//
//	public List<Production> getProductions() {
//		return productions;
//	}
//
//	public void setProductions(List<Production> productions) {
//		this.productions = productions;
//	}

	
}
