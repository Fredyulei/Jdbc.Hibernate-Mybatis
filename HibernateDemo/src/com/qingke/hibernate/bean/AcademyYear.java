package com.qingke.hibernate.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "school_year")
public class AcademyYear {
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "code")
	private int code;
	@Column(name = "designation")
	private String designation;
	@Column(name = "semseter")
	private String semseter;
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
	public String getSemseter() {
		return semseter;
	}
	public void setSemseter(String semseter) {
		this.semseter = semseter;
	}
	@Override
	public String toString() {
		return "AcademyYear [id=" + id + ", code=" + code + ", designation=" + designation + ", semseter=" + semseter
				+ "]";
	}
	
}
