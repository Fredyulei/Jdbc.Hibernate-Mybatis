package com.qingke.easyjava.jdbcapp.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class PropertyManager {	
	
	public String[] getPropertyList(String key) {
		return null;
	}
	
	//private static PropertyManager instance = new PropertyList();
	//public static synchronized PropertyManager getInstance(){
		//return instance;
	//}
	
	private static PropertyManager instance = null;
	
	private PropertyManager() {
		
	}
	
	public static synchronized PropertyManager getInstance(){
		if(instance == null) {
			instance = new PropertyManager();
		}
		return instance;
	}
	
	public static void main(String[] args) {
		Connection conn = null;
		String driver = getProperty("db.driver");
		try {
			Class.forName(driver);
			String url = getProperty("db.url");
			String u = getProperty("db.username");
			String p = getProperty("db.password");
			conn = DriverManager.getConnection(url,u,p);
			Statement st = conn.createStatement();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String key) {
		Properties pro = new Properties();
		try {
			pro.load(new FileInputStream("jdbc.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return pro.getProperty(key);
	}
	
	
}
