package com.qingke.hibernate.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="professional")
public class Major {
	@Id
	@Column(name="id")
private int id;
	@Column(name="code")
private int code;
	@Column(name="designation")
private String designation;
	@Column(name="description")
private String description;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Major [id=" + id + ", code=" + code + ", designation=" + designation + ", description=" + description
				+ "]";
	}
	
}
