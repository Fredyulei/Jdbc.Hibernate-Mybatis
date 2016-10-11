package com.qingke.hibernate.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class CourseTemplate {
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "time")
	private String time;
	@Column(name = "course_id")
	private int course_id;
	@Column(name = "teacher_id")
	private int teacher_id;
	@Column(name = "curriculum_provision_id")
	private String curriculum_provision_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public int getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}
	public String getCurriculum_provision_id() {
		return curriculum_provision_id;
	}
	public void setCurriculum_provision_id(String curriculum_provision_id) {
		this.curriculum_provision_id = curriculum_provision_id;
	}
	@Override
	public String toString() {
		return "CourseTemplate [id=" + id + ", time=" + time + ", course_id=" + course_id + ", teacher_id=" + teacher_id
				+ ", curriculum_provision_id=" + curriculum_provision_id + "]";
	}
	
}
