package com.sap.acme.imdb2.entity;

import java.io.Serializable;
import java.time.LocalDate;
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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="MOVIE")
public class Movie implements Serializable{

	private static final long serialVersionUID = -6638432149950535084L;
	
	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_MOVIE")
	private Long id;
	
	@Basic(optional = false)
	@Column(name="TITLE")
	private String title;
	
	@Basic(optional = false)
	@Column(name="RL_DATE")
	private LocalDate releaseDate;
	
	@Basic(optional = false)
	@Column(name="SYNOPSIS")
	private String synopsis;
	
	@Basic(optional=false)
	@Column(name = "LENGTH")
	private double length;
	
	@Basic(optional=false)
	@Column(name = "THUMBNAIL")
	private String thumbnail;
	
	@Basic(optional=false)
	@Column(name = "RATING")
	private double rating;
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="MOVIE_GENRE")
	private Set<Genre> genres;

	@JsonIgnore
	@ManyToMany(mappedBy="wishlist")
	private Set<User> users;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public Set<Genre> getGenres() {
		return genres;
	}

	public void setGenres(Set<Genre> genres) {
		this.genres = genres;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
}
