package com.bridgeit.jdbcpayroll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayRollService {

	public static List<EmployeePayroll> list = new ArrayList<EmployeePayroll>();

	public static void main(String[] args) throws ColumnMissMatchException {
		String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service";
		String userName = "root";
		String password = "root";
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		EmployeePayroll payroll = new EmployeePayroll();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("connecting to database : " + jdbcURL);
		try {
			connection = DriverManager.getConnection(jdbcURL, userName, password);
			System.out.println("Connection is successfull...... " + connection);
			statement = connection.createStatement();
			String quary = "select * from employee_payroll;";
			resultSet = statement.executeQuery(quary);
			try {
				while (resultSet.next()) {

					payroll.setEmp_id(resultSet.getInt("emp_id"));
					payroll.setEmp_name(resultSet.getString("emp_name"));
					payroll.setPhonenumber(resultSet.getLong("phonenumber"));
					payroll.setAddress(resultSet.getString("address"));
					payroll.setDepartment(resultSet.getString("department"));
					payroll.setGender(resultSet.getString("gender"));
					payroll.setBasic_pay(resultSet.getDouble("basic_pay"));
					payroll.setDeduction(resultSet.getString("deduction"));
					payroll.setTaxable_pay(resultSet.getString("taxable_pay"));
					payroll.setIncome_tax(resultSet.getString("income_tax"));
					payroll.setNet_pay(resultSet.getString("net_pay"));
					payroll.setStartdate(resultSet.getDate("startdate"));
					list.add(payroll);
				}
			} catch (Exception ex) {
				throw new ColumnMissMatchException("column miss match - check the fields in database");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					statement.close();
					System.out.println("statement closed...");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
					System.out.println("connection closed...");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println(list);
	}
}
