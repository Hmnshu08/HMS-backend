package com.hms.staffservice.models;





import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="staff")
public class Staff {
	
//	@Transient
//	private static final String SEQUENCE_NAME="user_sequence";
	
	@Id	
	private String id;
	
//	@NotNull(message="EmpId cannot be null")
//	private String employeeId;
	
	@NotNull(message="Name cannot be null")
	private String name;
	
	@NotNull(message="Email cannot be null")
	private String email;
	private String gender;
	private String department;
	private String salary;
	private String contactNumber;
	private String position;
	
	
	
	public Staff(String id,/* String employeeId,*/ String name, String email, String gender, String department,
			String salary, String contactNumber, String position) {
		super();
		this.id = id;
//		this.employeeId = employeeId;
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.department = department;
		this.salary = salary;
		this.contactNumber = contactNumber;
		this.position = position;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
//	public String getEmployeeId() {
//		return employeeId;
//	}
//	public void setEmployeeId(String employeeId) {
//		this.employeeId = employeeId;
//	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	
	
	
	
	
}
