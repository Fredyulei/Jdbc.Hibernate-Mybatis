package com.qingke.hibernate.dao;

import org.hibernate.Session;

public class EducationDao {
	private Session session;

	public EducationDao(Session session) {
		this.session = session;
	}
	
}
