package com.qingke.easyjava.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.codec.digest.DigestUtils;

import com.mysql.jdbc.Connection;
import com.qingke.easyjava.jdbcapp.pojo.Player;

public class BeSuperDao {

	public Player signup(String username, String password, String nickname) {
		String sql = "insert into `qingke`.`player`(`name`,`username`,`password` values(?,?,?) ";
		Connection conn = null;
		PreparedStatement statement = null;

		try {
			conn = getConnection();
			statement = conn.prepareStatement(sql);
			statement.setString(1, nickname);
			statement.setString(2, username);
			statement.setString(3, DigestUtils.md5Hex(password));
			
			int affectRows = statement.executeUpdate();
			if (affectRows > 0) {
				return login(username,password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cleanup(conn, statement, null);
		}
		return null;
	}

	private void cleanup(Connection conn, PreparedStatement statement,
			Object object) {
		// TODO Auto-generated method stub
		
	}

	private Player login(String username, String password) {
		String sql= "select id,name,score from player where username = ? and password = ?";
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			statement = conn.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, DigestUtils.md5Hex(password));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static Connection getConnection() {
		Connection conn = null;
		String url = "";
		
		return null;
	}
	
	

}
