package com.hms.employeeservice.resources;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.employeeservice.models.Employee;



@RestController
@RequestMapping("/employee")
public class EmployeeResource {
	@RequestMapping("/{employeeId}")
	public List<Employee> getEmployee(@PathVariable("employeeId") String employeeId){
		return Collections.singletonList(
		new Employee(10245, "shilpa", "receptionist", "abcdc@gmail.com", "F", 20000, 1236547890)
		);
	}

}
