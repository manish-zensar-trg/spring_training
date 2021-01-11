package com.zensar;

import java.sql.*;

public class LoginRepository {

	public Connection getDbConnection() {
		Connection con = null;
		String driverClassName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/java_training";
		String dbUserName = "root";
		String dbPassword = "root";
		try {
		Class.forName(driverClassName);
		con = DriverManager.getConnection(url, dbUserName, dbPassword);
		
		}catch(Exception e) {
			System.out.println("Exception Occured:"+e);
		}
		
		return con;
	}
	
	public boolean checkLogin(String userId, String password) {
		boolean result = false;
		Connection con = getDbConnection();
		String sql = "select * from login where user_name=?";
		try {
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, userId);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			String dbPassword = rs.getString("password");
			if(dbPassword.equals(password)) {
				result = true;
			}
		}
		
		}catch(Exception e) {
			System.out.println("Exception Occured:"+e);
		}
		
		return result;
	}
}
