package com.bridgeit.jdbcpayroll;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class EmployeePayRollMain {

	private static final int EXIT =5;
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		EmployeePayRollService employeePayRollService = new EmployeePayRollService();
		Statement statement = null;
		ResultSet resultSet = null;
		int exit=0;
		Scanner scanner = new Scanner(System.in);
		while (EXIT != exit) {
			System.out.println("enter 1.to create connection and statement \n 2.to retrieve Data "
					+ "\n 3.to update data \n 4.to print retrieve data \n"+EXIT+".to exit");
			int key = scanner.nextInt();
			switch (key) {
			case 1:
				statement = employeePayRollService.getConnection();
				break;
			case 2:
				resultSet = employeePayRollService.retrieveData(statement);
				break;
			case 3:
				employeePayRollService.updateData(statement);
				break;
			case 4:
				try {
					employeePayRollService.printRetrivedData(resultSet);
				} catch (ColumnMissMatchException e) {
					e.printStackTrace();
				}
				break;
			case EXIT:
				exit=EXIT;
				break;
			default:
				System.out.println("invalide selection");
				break;
			}
		}
	}
}
