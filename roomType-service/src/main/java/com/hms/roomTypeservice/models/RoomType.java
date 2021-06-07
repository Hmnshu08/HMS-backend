package com.hms.roomTypeservice.models;

public class RoomType {

		private String name;
		private String description;
		private String status;
		private int standardPrice;
		private int festivePrice;
		
		
		
		public RoomType(String name, String description, String status, int standardPrice, int festivePrice) {
			super();
			this.name = name;
			this.description = description;
			this.status = status;
			this.standardPrice = standardPrice;
			this.festivePrice = festivePrice;
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
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
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
		
		
		
		
}
