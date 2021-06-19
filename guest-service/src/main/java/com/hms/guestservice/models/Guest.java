package com.hms.guestservice.models;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@ApiModel(description="Guest Model" )
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="guest")
public class Guest {
	
	@Id	
	@ApiModelProperty(notes="ID of the user", name="id", required = true, value="60c09475jhbf4a51fe8a96e6f")
	private String id;
	
	@ApiModelProperty(notes="ID of the guestCode", name="guestCode", required = true, value="1206")
	@NotNull(message="Guest Code cannot be null")
	private int guestCode;
	
	@ApiModelProperty(notes="name of the guest", name="name", required = true, value="Aman")
	@NotNull(message="Name cannot be null")
	private String name;
	
	
	@ApiModelProperty(notes="Gender of the guest", name="gender", value="M")
	private String gender;
	
	@ApiModelProperty(notes="email of the guest", name="email",required = true, value="abc@xyz.com")
	@NotNull(message="Email cannot be null")
	private String email;
	
	@ApiModelProperty(notes="City of the guest", name="city", value="delhi")
	private String city;
	
	@ApiModelProperty(notes="State of the guest", name="state", value="delhi")
	private String state;
	
	@ApiModelProperty(notes="country of the guest", name="country", value="India")
	private	String country;
	
	@ApiModelProperty(notes="Postal Code of the guest", name="postalCode",required = true, value="110096")
	@NotNull(message="postal code cannot be null")
	private String postalCode;
	
	@ApiModelProperty(notes="ID type Code of the guest", name="idType",required = true, value="Voter Card")
	@NotNull(message="IdType cannot be null")
	private String idType;
	
	
	@ApiModelProperty(notes="Gov ID of the guest", name="govId",required = true, value="EKIN08HU")
	@NotNull(message="Gov ID cannot be null")
	private String govId;
	
	@ApiModelProperty(notes="Address of the guest", name="addresss", value="A658 B LivingSomewhere")
	private String addresss;
	
	@ApiModelProperty(notes="Contact number of the guest", name="contact",required = true, value="325698741")
	@NotNull(message="Contact cannot be null")
	private String contact;
	
	@ApiModelProperty(notes="Phone number of the guest", name="phone", value="22598674")
	private String phone;
	
	
	
	
	
	
	
	
	
	
	public Guest(String id, @NotNull(message = "Guest Code cannot be null") int guestCode,
			@NotNull(message = "Name cannot be null") String name, String gender,
			@NotNull(message = "Email cannot be null") String email, String city, String state, String country,
			@NotNull(message = "postal code cannot be null") String postalCode,
			@NotNull(message = "IdType cannot be null") String idType,
			@NotNull(message = "Gov ID cannot be null") String govId, String addresss,
			@NotNull(message = "Contact cannot be null") String contact, String phone) {
		super();
		this.id = id;
		this.guestCode = guestCode;
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.city = city;
		this.state = state;
		this.country = country;
		this.postalCode = postalCode;
		this.idType = idType;
		this.govId = govId;
		this.addresss = addresss;
		this.contact = contact;
		this.phone = phone;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getGuestCode() {
		return guestCode;
	}
	public void setGuestCode(int guestCode) {
		this.guestCode = guestCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getIdType() {
		return idType;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}
	public String getGovId() {
		return govId;
	}
	public void setGovId(String govId) {
		this.govId = govId;
	}
	public String getAddresss() {
		return addresss;
	}
	public void setAddresss(String addresss) {
		this.addresss = addresss;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	






//
//@Setter
//@Getter
//@AllArgsConstructor
//@NoArgsConstructor
//@Document(collection="guest")
//public class Guest {
//	@Id	
//	private String id;
//	
//	@NotNull(message="Guest Code cannot be null")
//	private int guestCode;
//	
//	@NotNull(message="Name cannot be null")
//	private String name;
//	
//	private String gender;
//	
//	@NotNull(message="Email cannot be null")
//	private String email;
//	private String city;
//	private String state;
//	private	String country;
//	
//	@NotNull(message="postal code cannot be null")
//	private String postalCode;
//	
//	@NotNull(message="IdType cannot be null")
//	private String idType;
//	
//	@NotNull(message="Gov ID cannot be null")
//	private String govId;
//	private String addresss;
//	
//	@NotNull(message="Contact cannot be null")
//	private String contact;
//	private String phone;
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	public Guest(String id, @NotNull(message = "Guest Code cannot be null") int guestCode,
//			@NotNull(message = "Name cannot be null") String name, String gender,
//			@NotNull(message = "Email cannot be null") String email, String city, String state, String country,
//			@NotNull(message = "postal code cannot be null") String postalCode,
//			@NotNull(message = "IdType cannot be null") String idType,
//			@NotNull(message = "Gov ID cannot be null") String govId, String addresss,
//			@NotNull(message = "Contact cannot be null") String contact, String phone) {
//		super();
//		this.id = id;
//		this.guestCode = guestCode;
//		this.name = name;
//		this.gender = gender;
//		this.email = email;
//		this.city = city;
//		this.state = state;
//		this.country = country;
//		this.postalCode = postalCode;
//		this.idType = idType;
//		this.govId = govId;
//		this.addresss = addresss;
//		this.contact = contact;
//		this.phone = phone;
//	}
//	public String getId() {
//		return id;
//	}
//	public void setId(String id) {
//		this.id = id;
//	}
//	public int getGuestCode() {
//		return guestCode;
//	}
//	public void setGuestCode(int guestCode) {
//		this.guestCode = guestCode;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getGender() {
//		return gender;
//	}
//	public void setGender(String gender) {
//		this.gender = gender;
//	}
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	public String getCity() {
//		return city;
//	}
//	public void setCity(String city) {
//		this.city = city;
//	}
//	public String getState() {
//		return state;
//	}
//	public void setState(String state) {
//		this.state = state;
//	}
//	public String getCountry() {
//		return country;
//	}
//	public void setCountry(String country) {
//		this.country = country;
//	}
//	public String getPostalCode() {
//		return postalCode;
//	}
//	public void setPostalCode(String postalCode) {
//		this.postalCode = postalCode;
//	}
//	public String getIdType() {
//		return idType;
//	}
//	public void setIdType(String idType) {
//		this.idType = idType;
//	}
//	public String getGovId() {
//		return govId;
//	}
//	public void setGovId(String govId) {
//		this.govId = govId;
//	}
//	public String getAddresss() {
//		return addresss;
//	}
//	public void setAddresss(String addresss) {
//		this.addresss = addresss;
//	}
//	public String getContact() {
//		return contact;
//	}
//	public void setContact(String contact) {
//		this.contact = contact;
//	}
//	public String getPhone() {
//		return phone;
//	}
//	public void setPhone(String phone) {
//		this.phone = phone;
//	}
//	
//	
//	
	
	
	
	
}