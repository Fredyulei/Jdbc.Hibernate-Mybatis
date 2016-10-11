package com.qingke.hibernate.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="coursetype")
public class CourseTemplateType {
	@Id
	@Column(name="id")
private int id;
	@Column(name="electivecourse")
private String electivecourse;
	@Column(name="requiredcourse")
private String requiredcourse;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getElectivecourse() {
		return electivecourse;
	}
	public void setElectivecourse(String electivecourse) {
		this.electivecourse = electivecourse;
	}
	public String getRequiredcourse() {
		return requiredcourse;
	}
	public void setRequiredcourse(String requiredcourse) {
		this.requiredcourse = requiredcourse;
	}
	@Override
	public String toString() {
		return "CourseTemplateType [id=" + id + ", electivecourse=" + electivecourse + ", requiredcourse="
				+ requiredcourse + "]";
	}
}
