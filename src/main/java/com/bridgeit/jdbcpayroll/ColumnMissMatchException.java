package com.bridgeit.jdbcpayroll;

public class ColumnMissMatchException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public ColumnMissMatchException(String string) {
		super(string);
	}	
}
