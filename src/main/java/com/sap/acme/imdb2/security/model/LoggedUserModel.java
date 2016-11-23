package com.sap.acme.imdb2.security.model;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.sap.acme.imdb2.entity.Role;

public class LoggedUserModel extends User{

	private static final long serialVersionUID = -2329653300103615880L;
	
	private Long id;
	private String name;
	private LocalDateTime lastLogin;
	private Set<Role> roles;
	private String password;
	
	public LoggedUserModel(Long id, String username, String password, Collection<? extends GrantedAuthority> authorities,
			String name, LocalDateTime lastLogin) {
		super(username, password, authorities);
		this.id = id;
		this.name = name;
		this.lastLogin = lastLogin;
		this.roles = (Set<Role>) authorities;
		this.password = password;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
