package com.qingke.jdbc.content;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="myorder")
public class Order {
	@Id
	@Column(name="id")
	long id ;
	@Column(name="create_datetime")
	String create_datetime ;
	@Column(name="order_status_id")
	long order_status_id ;
	@Column(name="clientId")
	long clientId ;
	public Order(){}
	public Order(long id, String create_datetime, long order_status_id, Client client) {
		// TODO Auto-generated constructor stub
		this.clientId=clientId;
		this.create_datetime=create_datetime;
		this.id=id;
		this.order_status_id=order_status_id;
	}

	public void setProductions(List<Production> products) {
		// TODO Auto-generated method stub
		
	}

	public static long getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getCreate_datetime() {
		return create_datetime;
	}

	public void setCreate_datetime(String create_datetime) {
		this.create_datetime = create_datetime;
	}

	public long getOrder_status_id() {
		return order_status_id;
	}

	public void setOrder_status_id(long order_status_id) {
		this.order_status_id = order_status_id;
	}

	public long getClientId() {
		return clientId;
	}

	public void setClientId(long clientId) {
		this.clientId = clientId;
	}

	public void setId(long id) {
		this.id = id;
	}

}
