package com.qingke.hibernatemana.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.qingke.hibernatemana.bean.Client;
import com.qingke.hibernatemana.bean.ClientLogin;

public class ClientDao {
	private Session session;

	public ClientDao(Session session) {
		this.session = session;
	}
	public List<Client> list(){
		Query<Client> query=session.createQuery("from Client",Client.class);
		return query.getResultList();		
	}
	public List<ClientLogin> login(){
		Query<ClientLogin> query=session.createQuery("from ClientLogin",ClientLogin.class);
		return query.getResultList();
	}
}
