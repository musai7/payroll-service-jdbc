package com.bridgeit.jdbcpayroll;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

public class EmployeePayRollService {

	public static void main(String[] args) {
		String jdbcURL = "jdbc:mysql://localhost" + ":3306/payroll_service?useSSL=false";
		String userName = "root";
		String password = "root";
		Connection connection = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println("connecting to database : " + jdbcURL);
		try {
			connection = DriverManager.getConnection(jdbcURL, userName, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Connection is successfull...... " + connection);
		}
	}
}
