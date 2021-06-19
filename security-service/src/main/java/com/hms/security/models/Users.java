package com.hms.security.models;
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
@Document(collection="users")
public class Users {

	@Id	
	private String id;
	
	@NotNull(message="Name cannot be null")
	private String username;
	@NotNull(message="Name cannot be null")
	private String pass;
	@NotNull(message="Name cannot be null")
	private String userType;
	@NotNull(message="Name cannot be null")
	private String email;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Users(String id, @NotNull(message = "Name cannot be null") String username,
			@NotNull(message = "Name cannot be null") String pass,
			@NotNull(message = "Name cannot be null") String userType,
			@NotNull(message = "Name cannot be null") String email) {
		super();
		this.id = id;
		this.username = username;
		this.pass = pass;
		this.userType = userType;
		this.email = email;
	}
}