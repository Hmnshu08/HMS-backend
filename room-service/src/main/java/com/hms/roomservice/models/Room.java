package com.hms.roomservice.models;

public class Room {
	private int roomNumber;
	private String name;
	private String block;
	private int floor;
	private String status;
	private String roomType;
	
	
	
	
	public Room(int roomNumber, String name, String block, int floor, String status, String roomType) {
		super();
		this.roomNumber = roomNumber;
		this.name = name;
		this.block = block;
		this.floor = floor;
		this.status = status;
		this.roomType = roomType;
	}
	
	
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBlock() {
		return block;
	}
	public void setBlock(String block) {
		this.block = block;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	
	
	
	
	
	
	
	
}
