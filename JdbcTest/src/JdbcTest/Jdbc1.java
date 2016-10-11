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

public class Jdbc1 {

	public static void main(String[] args) {
		Connection con = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			String driver = getProperties("db.driver");
			Class.forName(driver);
			con = getConnection();
			stm = con.createStatement();
			rs = stm.executeQuery("select*from report");
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String sex = rs.getString("sex");
				int score = rs.getInt("score");
				System.out.println("report:id=" + id + "  name:" + name + "  sex:" + sex + " " + "   score:" + score);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				stm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Scanner scanner=new Scanner(System.in);
		System.out.print("Enter username na :");
		String na=scanner.nextLine();
		CallableStatement cs=null;	
		try {
			con=getConnection();
			cs=con.prepareCall("call mydb.get_report(?,?)");
			cs.setString(1, na);
			cs.registerOutParameter(2, Types.INTEGER);
			cs.executeQuery();
			int resultCount=cs.getInt(2);
			System.out.println("count="+resultCount);
			rs=cs.getResultSet();
			while(rs.next()){
				int id=rs.getInt("id");
				String name=rs.getString("name");
				String sex=rs.getString("sex");
				int score=rs.getInt("score");
				System.out.println("report id:"+id+"name:"+name+"sex:"+sex+"score:"+score);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				cs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			scanner.close();
		}
	}

	private static String getProperties(String key) {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("jdbc.properties"));
			return prop.getProperty(key);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
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
			throw new RuntimeException();
		}
		// return null;

	}
}
