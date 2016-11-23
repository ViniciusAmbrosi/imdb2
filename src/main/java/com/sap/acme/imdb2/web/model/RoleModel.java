package com.sap.acme.imdb2.web.model;

import java.util.List;
import com.sap.acme.imdb2.entity.User;

public class RoleModel {

	private Long id;
	
	private String name;
	
	private List<User> users;

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

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
}
