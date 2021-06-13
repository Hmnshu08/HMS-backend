package com.hms.roomservice.models;

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
@Document(collection="room")
public class Room {
	@Id	
	private String id;
	
	@NotNull(message="Room Number cannot be null")
	private int roomNumber;
	private String name;
	private String description;
	private String block;
	private int floor;
	private String status;
	private String roomType;
	private int standardPrice;
	private int festivePrice;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public int getStandardPrice() {
		return standardPrice;
	}
	public void setStandardPrice(int standardPrice) {
		this.standardPrice = standardPrice;
	}
	public int getFestivePrice() {
		return festivePrice;
	}
	public void setFestivePrice(int festivePrice) {
		this.festivePrice = festivePrice;
	}
	
	public Room(String id, @NotNull(message = "Room NUmber cannot be null") int roomNumber, String name,
			String description, String block, int floor, String status, String roomType, int standardPrice,
			int festivePrice) {
		super();
		this.id = id;
		this.roomNumber = roomNumber;
		this.name = name;
		this.description = description;
		this.block = block;
		this.floor = floor;
		this.status = status;
		this.roomType = roomType;
		this.standardPrice = standardPrice;
		this.festivePrice = festivePrice;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
