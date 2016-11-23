package com.sap.acme.imdb2.web.model;

import java.io.Serializable;
import java.util.List;

import com.sap.acme.imdb2.entity.Genre;
import com.sap.acme.imdb2.entity.Movie;

public class GenreModel implements Serializable{

	private static final long serialVersionUID = 3512693473863946968L;

	private Long id;

	private String name;
	
	private List<MovieModel> movies;

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

	public List<MovieModel> getMovies() {
		return movies;
	}

	public void setMovies(List<MovieModel> movies) {
		this.movies = movies;
	}
}
