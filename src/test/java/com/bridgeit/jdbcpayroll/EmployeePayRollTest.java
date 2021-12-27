package com.bridgeit.jdbcpayroll;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;

import org.junit.BeforeClass;
import org.junit.Test;

public class EmployeePayRollTest {

	static EmployeePayRollService employeePayRollService;

	@BeforeClass
	public static void initialize() {

		employeePayRollService = new EmployeePayRollService();
	}

	@Test
	public void shouldAnswerWithTrue() {
		Connection connection  = employeePayRollService.getConnection();
		int actual = employeePayRollService.updateData(connection);
		assertEquals(1, actual);
	}
}
