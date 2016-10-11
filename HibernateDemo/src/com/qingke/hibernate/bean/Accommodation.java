package com.qingke.hibernate.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "accommodation")
public class Accommodation {
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "create_datetime")
	private String create_datetime;
	@Column(name = "expire_datetime")
	private String expire_datetime;
	@Column(name = "id")
	private int apartment_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCreate_datetime() {
		return create_datetime;
	}
	public void setCreate_datetime(String create_datetime) {
		this.create_datetime = create_datetime;
	}
	public String getExpire_datetime() {
		return expire_datetime;
	}
	public void setExpire_datetime(String expire_datetime) {
		this.expire_datetime = expire_datetime;
	}
	public int getApartment_id() {
		return apartment_id;
	}
	public void setApartment_id(int apartment_id) {
		this.apartment_id = apartment_id;
	}
	@Override
	public String toString() {
		return "Accommodation [id=" + id + ", create_datetime=" + create_datetime + ", expire_datetime="
				+ expire_datetime + ", apartment_id=" + apartment_id + "]";
	}
	
}
