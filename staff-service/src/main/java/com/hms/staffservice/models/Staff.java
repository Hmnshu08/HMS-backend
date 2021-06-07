package com.hms.staffservice.models;

public class Staff {
	
	private int employeeId;
	private String position;
	
	
	
	public Staff(int employeeId, String position) {
		super();
		this.employeeId = employeeId;
		this.position = position;
	}
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	
}
