package com.bridgeit.jdbcpayroll;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmployeePayRollMain {

	private static final int EXIT = 7;

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		EmployeePayRollService employeePayRollService = new EmployeePayRollService();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Loaded Driver class");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection connection = null;
		ResultSet resultSet = null;
		int exit = 0;
		Scanner scanner = new Scanner(System.in);
		while (EXIT != exit) {
			System.out.println("enter \n 1.to create connection and statement \n 2.to retrieve Data "
					+ "\n 3.to update data \n 4.to print retrieve data \n 5.to select employees who join between date \n"
					+ "6.retrieve mathoperations like sumavg max min \n"+ EXIT + ".to exit");
			int key = scanner.nextInt();
			switch (key) {
			case 1:
				connection = employeePayRollService.getConnection();
				break;
			case 2:
				resultSet = employeePayRollService.retrieveData(connection);
				break;
			case 3:
				employeePayRollService.updateData(connection);
				break;
			case 4:
				try {
					employeePayRollService.printRetrivedData(resultSet);
				} catch (ColumnMissMatchException e) {
					e.printStackTrace();
				}
				break;
			case 5:
				employeePayRollService.retrieveEmployees();
				break;
			case 6:
				employeePayRollService.retrieveMathOPerations();
				break;
			case EXIT:
				employeePayRollService.close();
				exit = EXIT;
				break;
			default:
				System.out.println("invalide selection");
				break;
			}
		}
	}
}
