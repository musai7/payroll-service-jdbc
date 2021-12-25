package com.bridgeit.jdbcpayroll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayRollService {

	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	public static List<EmployeePayroll> list = new ArrayList<EmployeePayroll>();
	EmployeePayroll payroll = new EmployeePayroll();
	Scanner scanner = new Scanner(System.in);

	public int updateData(Statement statement) {

		System.out.println("update quary : ");
		String updateString = scanner.nextLine();
		int count = 0;
		try {
			count = statement.executeUpdate(updateString);
			System.out.println("successfully updated...");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public ResultSet retrieveData(Statement statement) {

		System.out.println("enter Select quary : ");
		String selectString = scanner.nextLine();
		try {
			resultSet = statement.executeQuery(selectString);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}

	public Statement getConnection() {

		String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service";
		String userName = "root";
		String password = "root";
		System.out.println("connecting to database : " + jdbcURL);
		try {
			connection = DriverManager.getConnection(jdbcURL, userName, password);
			System.out.println("Connection is successfull...... " + connection);
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return statement;
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
			throw new ColumnMissMatchException("column miss match - check the fields in database");
		}
		System.out.println(list);
	}
}
