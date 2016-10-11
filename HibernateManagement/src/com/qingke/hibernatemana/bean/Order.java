package com.qingke.hibernatemana.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order")
public class Order {
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "code")
	private String code;
	@Column(name = "create_datetime")
	private String create_datetime;
	@Column(name = "clientId")
	private String clientId;
	@Column(name = "order_status_id")
	private String order_status_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCreate_datetime() {
		return create_datetime;
	}

	public void setCreate_datetime(String create_datetime) {
		this.create_datetime = create_datetime;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getOrder_status_id() {
		return order_status_id;
	}

	public void setOrder_status_id(String order_status_id) {
		this.order_status_id = order_status_id;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", code=" + code + ", create_datetime=" + create_datetime + ", clientId=" + clientId
				+ ", order_status_id=" + order_status_id + "]";
	}

}
