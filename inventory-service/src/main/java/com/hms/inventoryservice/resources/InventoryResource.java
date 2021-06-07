package com.hms.inventoryservice.resources;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hms.inventoryservice.models.Inventory;



@RestController
@RequestMapping("/inventory")
public class InventoryResource {

	@Autowired
	private RestTemplate restTemplate;
	
	
	@RequestMapping("/{inventoryId}")
public List<Inventory> getResource(@PathVariable("inventoryId") String resourceId){
		
		return Collections.singletonList(
				new Inventory(11, "soap", 100)
				);
	}
}
