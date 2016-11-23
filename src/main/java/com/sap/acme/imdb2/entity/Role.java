package com.sap.acme.imdb2.entity;

import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.springframework.security.core.GrantedAuthority;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="ROLE")
public class Role implements GrantedAuthority{

	private static final long serialVersionUID = 1001368266674089730L;

	@Id
	@Basic(optional=false)
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="ID_ROLE")
	private Long id;
	
	@Basic(optional=false)
	@Column(name = "NAME")
	private String name;
	
	@JsonIgnore
	@ManyToMany(mappedBy="roles")
	private Set<User> users;

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

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public String getAuthority() {
		return name;
	}
}