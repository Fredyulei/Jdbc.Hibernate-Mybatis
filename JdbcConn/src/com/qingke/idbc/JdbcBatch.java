package com.qingke.idbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

public class JdbcBatch extends JdbcConn {
	public static void main(String[] args) {
		Connection conn = null;
		//��ʾԤ����� SQL���Ķ��󡣿���ʹ�ô˶����θ�Ч��ִ�и����
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			ps = conn.prepareStatement("insert into qingke.course(id,name,description,code)value(?,?,?,?)");
			for (int i = 1; i <= 5; i++) {
				ps.setInt(1, i + 7);
				ps.setString(2, "Qingke" );
				ps.setString(3, "qingkebohsp" );
				ps.setInt(4, i+7);
				ps.addBatch();
			}
			int[] results = ps.executeBatch();
			System.out.println("result=" + Arrays.toString(results));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}