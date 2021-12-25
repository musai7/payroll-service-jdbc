package com.bridgeit.jdbcpayroll;

public class EmployeePayroll {
		private int emp_id;
		private String emp_name ;
		private long phonenumber ;
		private String address ;
		private String department ;
		private String gender ;
		private double basic_pay ;
		private String deduction ;
		private String taxable_pay ;
		private String income_tax;
		private String net_pay ;
		private java.sql.Date startdate;
		public int getEmp_id() {
			return emp_id;
		}
		public void setEmp_id(int emp_id) {
			this.emp_id = emp_id;
		}
		public String getEmp_name() {
			return emp_name;
		}
		public void setEmp_name(String emp_name) {
			this.emp_name = emp_name;
		}
		public long getPhonenumber() {
			return phonenumber;
		}
		public void setPhonenumber(long phonenumber) {
			this.phonenumber = phonenumber;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getDepartment() {
			return department;
		}
		public void setDepartment(String department) {
			this.department = department;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public double getBasic_pay() {
			return basic_pay;
		}
		public void setBasic_pay(double basic_pay) {
			this.basic_pay = basic_pay;
		}
		public String getDeduction() {
			return deduction;
		}
		public void setDeduction(String deduction) {
			this.deduction = deduction;
		}
		public String getTaxable_pay() {
			return taxable_pay;
		}
		public void setTaxable_pay(String taxable_pay) {
			this.taxable_pay = taxable_pay;
		}
		public String getIncome_tax() {
			return income_tax;
		}
		public void setIncome_tax(String income_tax) {
			this.income_tax = income_tax;
		}
		public String getNet_pay() {
			return net_pay;
		}
		public void setNet_pay(String net_pay) {
			this.net_pay = net_pay;
		}
		public java.sql.Date getStartdate() {
			return startdate;
		}
		public void setStartdate(java.sql.Date startdate) {
			this.startdate = startdate;
		}
		@Override
		public String toString() {
			return "EmployeePayroll [emp_id=" + emp_id + ", emp_name=" + emp_name + ", phonenumber=" + phonenumber
					+ ", address= \"" +address +" \""+ ", department=" + department + ", gender=" + gender + ", basic_pay="
					+ basic_pay + ", deduction=" + deduction + ", taxable_pay=" + taxable_pay + ", income_tax="
					+ income_tax + ", net_pay=" + net_pay + ", startdate=" + startdate + "]";
		}
		
}
