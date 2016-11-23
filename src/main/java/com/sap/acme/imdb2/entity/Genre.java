package com.sap.acme.imdb2.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="GENRE")
public class Genre implements Serializable{

	private static final long serialVersionUID = 2531600655023041628L;

	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_GENRE")
	private Long id;

	@Basic(optional=false)
	@Column(name="NAME")
	private String name;
	
	@JsonIgnore
	@ManyToMany(mappedBy="genres")
	private Set<Movie> movies;

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

	public Set<Movie> getMovies() {
		return movies;
	}

	public void setMovies(Set<Movie> movies) {
		this.movies = movies;
	}
}
