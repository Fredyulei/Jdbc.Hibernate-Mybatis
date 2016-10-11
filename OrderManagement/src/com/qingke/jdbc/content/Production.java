package com.qingke.jdbc.content;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="production")
public class Production {
	@Id
	@Column(name="id")
	private long id;
	@Column(name="client_id")
	private long client_id;
	@Column(name="name")
	private String name;
	@Column(name="prize")
	private double prize;
	@Column(name="description")
	private String description;
	
//	@ManyToOne
//	@JoinColumn(name="client")
//	private Client client;

	public Production() {

	}

	public Production(long id,double prize) {
		this.id = id;
		this.prize = prize;
	}

	public Production(long id, String name, double prize, String description) {
		this.id = id;
		this.name = name;
		this.prize = prize;
		this.description = description;
	}

	public Production(long id, String name) {

		this.id = id;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getClient_id() {
		return client_id;
	}

	public void setClient_id(long client_id) {
		this.client_id = client_id;
	}

	public String getName() {
		return name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrize() {
		return prize;
	}

	public void setPrize(double prize) {
		this.prize = prize;
	}

}
