package com.qingke.jdbcapp.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {
	private static Properties props;
	 private static PropertyManager instance;
	
	 private PropertyManager() {
	 props = new Properties();
	 try {
	 props.load(new FileInputStream(new File("jdbc.properties")));
	 } catch (IOException e) {
	 e.printStackTrace();
	 }
	 }
	 public static PropertyManager getInstance() {
	 if (instance == null) {
	 instance = new PropertyManager();
	 }
	 return instance;
	 }
	 public static String getInstance(String key) {
	 return props.getProperty("db.driver");
	 }
	 public static void main(String[] args) {
	 PropertyManager.getInstance();
	 System.out.println("props:" + props.getProperty("db.driver"));
	 }
//	private static PropertyManager instance = new PropertyManager();
//	private PropertyManager() {
//		props = new Properties();
//		try {
//			props.load(new FileInputStream(new File("jdbc.properties")));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	public static PropertyManager getInstance() {
//		return instance;
//	}
//	public static void main(String[] args) {
//		//PropertyManager.getInstance();
//		System.out.println("props:" + props.getProperty("db.driver"));
//	}
}
