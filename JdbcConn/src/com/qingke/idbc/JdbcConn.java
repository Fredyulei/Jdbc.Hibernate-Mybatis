package com.qingke.idbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Properties;
import java.util.Scanner;

public class JdbcConn {

	public static void main(String[] args) {
		// ���ض����ݿ�����ӣ��Ự������������������ִ�� SQL ��䲢���ؽ����
		Connection conn = null;
		//һ���ӿ� ����ִ�о�̬ SQL ��䲢�����������ɽ���Ķ��� 
		Statement stmt = null;
		//��ʾ���ݿ����������ݱ�
		ResultSet rs = null;
		try {
			String driver = getProperties("db.driver");
			// ��������
			Class.forName(driver);
			// ��һ��·��
			String url = getProperties("db.url");
			// �û���
			String u = getProperties("db.username");
			// ����
			String p = getProperties("db.password");
			// ���һ��������
			conn = DriverManager.getConnection(url, u, p);
			// �õ�һ��ִ���࣬����һ������ִ�ж���
			stmt = conn.createStatement();
			// ѡ��sqlִ�����е�ĳ���ļ���ѯ�����ؽ�� ��ѯ����
			rs = stmt.executeQuery("select*from course");
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String des = rs.getString("description");
				System.out.println("student:id=" + id + ",name=" + name + ",description:" + des);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			ps = conn.prepareStatement("select*from course where id=?");
			
			ps.setInt(1, 9);
			
			rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String des = rs.getString("description");
				System.out.println("student:id=" + id + ",name=" + name + ",description:" + des);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter username pattern:");
		String pattern = scanner.nextLine();
		//����ִ�� SQL �洢���̵Ľӿڡ�(mysql���Ѿ������˴洢����)
		CallableStatement cs=null;
		try {
			conn = getConnection();
			//��������ʹ洢���̽�������
			cs=conn.prepareCall("call qingke.get_course(?,?)");
			//���ã������һ��������
			cs.setString(1, pattern);
			//
			cs.registerOutParameter(2, Types.INTEGER);
			//ִ�У�����
			cs.execute();
			//�õ������������ֵĸ����������
			int resultCount=cs.getInt(2);
			System.out.println("count="+resultCount);
			//
			rs=cs.getResultSet();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String des = rs.getString("description");
				System.out.println("course:id=" + id + ",name=" + name + ",description:" + des);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			scanner.close();
			try {
				cs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	protected static Connection getConnection() {

		try {
			String url = getProperties("db.url");
			String u = getProperties("db.username");
			String p = getProperties("db.password");
			return DriverManager.getConnection(url, u, p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//�׳�һ�������쳣
			throw new RuntimeException();
		}

	}

	private static String getProperties(String key) {
		//����һ��ʵ��
		Properties props = new Properties();
		try {
			// ӵ��һ�����صķ���load; �����ļ���
			props.load(new FileInputStream("jdbc.properties"));
			// ���ش������Ķ���
			return props.getProperty(key);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			//throw new RuntimeException();
		} catch (IOException e) {
			e.printStackTrace();
			//throw new RuntimeException();
		}
		return "";

	}
}