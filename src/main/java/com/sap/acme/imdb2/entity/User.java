package com.sap.acme.imdb2.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="USER")
 public class User implements Serializable{

	private static final long serialVersionUID = 4155014660763629695L;
	
	@Id
	@Basic(optional=false)
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="ID_USER")
	private Long id;
	
	@Basic(optional=false)
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "LASTLOGIN")
	private LocalDateTime lastLogin;
	
	@Basic(optional=false)
	@Column(name = "USERNAME")
	private String username;
	
	@Basic(optional=false)
	@Column(name = "PASSWORD")
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="USER_ROLE")
	private Set<Role> roles;
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="USER_MOVIE")
	private Set<Movie> wishlist;

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

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<Movie> getWishlist() {
		return wishlist;
	}

	public void setWishlist(Set<Movie> wishlist) {
		this.wishlist = wishlist;
	}
}
