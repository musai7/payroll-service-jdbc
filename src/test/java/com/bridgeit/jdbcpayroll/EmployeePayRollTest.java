package com.bridgeit.jdbcpayroll;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.PreparedStatement;
import java.sql.Statement;

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
		PreparedStatement preparedStatement = employeePayRollService.getConnection();
		int actual = employeePayRollService.updateData(preparedStatement);
		assertEquals(1, actual);
	}
}
