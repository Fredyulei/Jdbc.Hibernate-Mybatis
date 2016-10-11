package JdbcTest;

import java.awt.print.Paper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

public class JdbcBatch extends Paper {
	public static void main(String[] args) {
		Connection conn = null;
		//表示预编译的 SQL语句的对象。可以使用此对象多次高效地执行该语句
		PreparedStatement ps = null;
		try {
			conn = ps.getConnection();
			ps = conn.prepareStatement("insert into qingke.player(id,name,password,code)value(?,?,?,?)");
			for (int i = 1; i <= 5; i++) {
				ps.setInt(1, i + 3);
				ps.setString(2, "Qingke"+i );
				ps.setString(3, "qingke"+i );
				ps.setInt(4, i+3);
				ps.addBatch();
			}
			int[] results = ps.executeBatch();
			System.out.println("result=" + Arrays.toString(results));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}