package mysql;

import java.sql.*;

public class Get {

	// JDBC DRIVER and DB
	static final String DRIVER = "com.mysql.jdbc.Driver";
	static final String DB = "jdbc:mysql://localhost:3306/test";
	static final String USER = "root";
	static final String PASSWD = "123456";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			//
			Class.forName(DRIVER);
			System.out.println("Connecting to test database...");
			// 打开一个连接
			conn = DriverManager.getConnection(DB, USER, PASSWD);
			// 执行一个查询
			stmt = conn.createStatement();
			String sql = "select name,English from student where name='scofield'";
			rs = stmt.executeQuery(sql);
			System.out.println("name"+"\t\t"+"English");
			while(rs.next()) {
				System.out.print(rs.getString(1)+"\t\t");
				System.out.println(rs.getInt(2));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}