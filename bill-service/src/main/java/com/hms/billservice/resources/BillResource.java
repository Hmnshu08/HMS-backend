package com.hms.billservice.resources;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hms.billservice.models.Bill;




@RestController
@RequestMapping("/bill")
public class BillResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/{billId}")
	public List<Bill> getBill(@PathVariable("billId") String billId){
		return Collections.singletonList(
		new Bill(1, "Arman", "2021-06-05" , "2021-12-05", 5, "standard", 2, 1, 4.0, 2000.0, 455565959, "visa")
		);
		
		
//		new Bill(1, "Arman", "2021-06-05" , "2021-12-05", 5, "standard", 2, 1, 4.0, 2000.0, 455565959, "visa")
	}
}
