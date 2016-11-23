package com.sap.acme.imdb2.web.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserModel {
	
	private Long id;
	
	@NotNull(message="The name field is mandatory.")
	@Size(min=1,message="The name field must not be empty")
	private String name;
	
	private LocalDateTime lastLogin;
	
	@NotNull(message="The username field is mandatory.")
	@Size(min=1,message="The username field must not be empty")
	private String username;
	
	@NotNull(message="The password field is mandatory.")
	@Size(min=1,message="The password field must not be empty")
	@Pattern(regexp="(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}", message="The password must contain at least on digit, one lower case, one upper case and at least 8 characters.")
	private String password;
	
	@NotNull(message="The password confirmation field is mandatory.")
	@Size(min=1,message="The password confirmation field must not be empty")
	@Pattern(regexp="(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}", message="The password must contain at least on digit, one lower case, one upper case and at least 8 characters.")
	private String passwordConfirmation;
	
	private List<RoleModel> roles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(LocalDateTime lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public List<RoleModel> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleModel> roles) {
		this.roles = roles;
	}
}
