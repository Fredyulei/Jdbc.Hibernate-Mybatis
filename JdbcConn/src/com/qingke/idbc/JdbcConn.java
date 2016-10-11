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
		// 与特定数据库的连接（会话）。在连接上下文中执行 SQL 语句并返回结果。
		Connection conn = null;
		//一个接口 用于执行静态 SQL 语句并返回它所生成结果的对象。 
		Statement stmt = null;
		//表示数据库结果集的数据表
		ResultSet rs = null;
		try {
			String driver = getProperties("db.driver");
			// 加载驱动
			Class.forName(driver);
			// 找一个路径
			String url = getProperties("db.url");
			// 用户名
			String u = getProperties("db.username");
			// 密码
			String p = getProperties("db.password");
			// 获得一个连接类
			conn = DriverManager.getConnection(url, u, p);
			// 得到一个执行类，申请一个数据执行对象
			stmt = conn.createStatement();
			// 选择sql执行类中的某个文件查询，返回结果 查询操作
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
		//用于执行 SQL 存储过程的接口。(mysql中已经建立了存储过程)
		CallableStatement cs=null;
		try {
			conn = getConnection();
			//让连接类和存储过程建立连接
			cs=conn.prepareCall("call qingke.get_course(?,?)");
			//设置，定义第一个“？”
			cs.setString(1, pattern);
			//
			cs.registerOutParameter(2, Types.INTEGER);
			//执行，运行
			cs.execute();
			//得到含有输入名字的个数，并输出
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
			//抛出一个运行异常
			throw new RuntimeException();
		}

	}

	private static String getProperties(String key) {
		//创建一个实例
		Properties props = new Properties();
		try {
			// 拥有一个加载的方法load; 传入文件流
			props.load(new FileInputStream("jdbc.properties"));
			// 返回传进来的东西
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