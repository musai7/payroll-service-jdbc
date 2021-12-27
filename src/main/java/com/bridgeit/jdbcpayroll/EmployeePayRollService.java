package com.bridgeit.jdbcpayroll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayRollService {

	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	public static List<EmployeePayroll> list = new ArrayList<EmployeePayroll>();
	EmployeePayroll payroll = new EmployeePayroll();
	Scanner scanner = new Scanner(System.in);

	public int updateData(Connection connection) {

		System.out.println("update Quiry : ");
		String updatedQuiry = scanner.nextLine();
		int count = 0;
		try {
			preparedStatement = connection.prepareStatement(updatedQuiry);
			count = preparedStatement.executeUpdate();
			System.out.println("successfully updated..."+count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public ResultSet retrieveData(Connection connection) {

		System.out.println("enter Select quary : ");
		String selectStatement = scanner.nextLine();
		try {
			preparedStatement = connection.prepareStatement(selectStatement);
			resultSet = preparedStatement.executeQuery();
			
			System.out.println("successfully retrived...");
			//System.out.println(resultSet.getDouble(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}

	public Connection getConnection() {

		String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service";
		String userName = "root";
		String password = "root";
		System.out.println("connecting to database : " + jdbcURL);
		try {
			connection = DriverManager.getConnection(jdbcURL, userName, password);
			System.out.println("Connection is successfull...... " + connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public void printRetrivedData(ResultSet resultSet) throws ColumnMissMatchException {
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
			ex.printStackTrace();
		}
		System.out.println(list);
	}
	
	public void retrieveEmployees() {

		System.out.println("enter from date in yyyy-mm-dd");
		String date =scanner.nextLine();
		try {
			preparedStatement = connection.prepareStatement("select emp_name from employee_payroll where startdate between cast('"+date+"' as date) and date(now());");
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			System.out.println("emp_name");
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			preparedStatement.close();
			connection.close();
			System.out.println("connection closed.......");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
