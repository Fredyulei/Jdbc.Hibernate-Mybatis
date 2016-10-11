package com.qingke.hibernate.bean;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "apartment")
@Entity
public class Apartment {
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "building")
	private String building;
	@Column(name = "floor")
	private int floor;
	@Column(name = "foom")
	private int foom;
	@Column(name = "bed")
	private int bed;

	@OneToMany
	@JoinColumn(name="apartment_id")
	private Set<Student> students;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public int getFoom() {
		return foom;
	}

	public void setFoom(int foom) {
		this.foom = foom;
	}

	public int getBed() {
		return bed;
	}

	public void setBed(int bed) {
		this.bed = bed;
	}

	
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "apartment [id=" + id + ", building=" + building + ", floor=" + floor + ", foom=" + foom + ", bed=" + bed
				+ "]";
	}

}
