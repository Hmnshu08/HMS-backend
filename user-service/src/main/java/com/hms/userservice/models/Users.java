package com.hms.userservice.models;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ApiModel(description="User Model" )
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="users")
public class Users {

	@Id	
	@ApiModelProperty(notes="ID of the user", name="id", required = true, value="60c09475jhbf4a51fe8a96e6f")
	private String id;
	
	@ApiModelProperty(notes="username of the user", name="username", required = true, value="hmnshu")
	@NotNull(message="Name cannot be null")
	private String username;
	
	@ApiModelProperty(notes="Password of the user", name="pass", required = true, value="12345")
	@NotNull(message="Name cannot be null")
	private String pass;
	
	@ApiModelProperty(notes="User Type of the user", name="userType", required = true, value="Manager")
	@NotNull(message="Name cannot be null")
	private String userType;
	
	@ApiModelProperty(notes="Email Type of the user", name="email", required = true, value="abc@xyz.com")
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
