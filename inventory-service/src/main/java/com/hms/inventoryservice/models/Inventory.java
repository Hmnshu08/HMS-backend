package com.hms.inventoryservice.models;

public class Inventory {

	
	private int itemid;
	private String itemName;
	private int quantity;
	
	
	
	
	public Inventory(int itemid, String itemName, int quantity) {
		super();
		this.itemid = itemid;
		this.itemName = itemName;
		this.quantity = quantity;
	}
	
	
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
}
