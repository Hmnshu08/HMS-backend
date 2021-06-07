package com.hms.staffservice.resources;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.staffservice.models.Staff;



@RestController
@RequestMapping("/staff")
public class StaffResources {
	@RequestMapping("/{staffId}")
	public List<Staff> getStaff(@PathVariable("staffId") String staffId){
		
		return Collections.singletonList(
				new Staff(102564, "receptionist")
				);
	}

}
