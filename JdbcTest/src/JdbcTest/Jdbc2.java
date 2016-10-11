
package JdbcTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Properties;
import java.util.Scanner;

public class Jdbc2 {

	public static void main(String[] args) {
		Connection cc = null;
		Statement sat = null;
		ResultSet rs = null;
		try {
			String driver = getProperties("db.driver");
			Class.forName(driver);
			cc = getConnection();
			sat = cc.createStatement();
			rs = sat.executeQuery("select*from eduction");
			while (rs.next()) {
				int id = rs.getInt("id");
				String school = rs.getString("school");
				String major = rs.getString("major");
				String degree = rs.getString("degree");
				System.out.println("�����Ϧ����į  id:" + id + "school:" + school + "major:" + major + "degree:" + degree);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection( cc, rs, sat);
		}
		while (true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println(" HelloWorld :");
			String s = scanner.nextLine();
			CallableStatement cs = null;
			try {
				cc = getConnection();
				cs = cc.prepareCall("call �����Ϧ����į.get_eduction(?,?)");
				cs.setString(1, s);
				cs.registerOutParameter(2, Types.INTEGER);
				cs.executeQuery();
				int resultcount = cs.getInt(2);
				System.out.println("count:" + resultcount+"\n");
				rs = cs.getResultSet();
				while (rs.next()) {
					String a = rs.getString("school");
					String b = rs.getString("degree");
					String c = rs.getString("major");
					int d = rs.getInt("id");
					System.out.println("��į id:" + d + "school:" + a + "degree:" + b + "major:" + c);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				
				closeConnection( cc, rs, cs);
			}
			System.out.println("�Ƿ������ѯ ������ yes�����˳�no");
			String i=scanner.nextLine();
			while(true){
				if(!(("yes".equals(i))||("no".equals(i)))){
					System.out.println("��������ȷ����");
					i=scanner.nextLine();
					continue;
				}
				break;
			}
			if("yes".equals(i)){
				continue;
			}
			scanner.close();
			System.out.println("�Ѿ��˳���ѯ");
			break;
		}
		
		

	}
	private static void closeConnection(Connection conn,ResultSet rs,Statement cs){
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			cs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static String getProperties(String key) {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("jdbc.properties"));
			return prop.getProperty(key);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	private static Connection getConnection() {
		try {
			String url = getProperties("db.url");
			String u = getProperties("db.username");
			String p = getProperties("db.password");
			return DriverManager.getConnection(url, u, p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
