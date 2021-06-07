package com.hms.employeeservice.models;

public class Employee {
	private int employeeId;
	private String name;
	private String department;
	private String email;
	private String gender;
	private int salary;
	private int contactNumber;
	
	
	
	
	
	
	public Employee(int employeeId, String name, String department, String email, String gender, int salary,
			int contactNumber) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.department = department;
		this.email = email;
		this.gender = gender;
		this.salary = salary;
		this.contactNumber = contactNumber;
	}
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	
	
	

}
