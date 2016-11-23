package com.sap.acme.imdb2.repository.interfaces;

import java.util.List;
import com.sap.acme.imdb2.entity.Movie;

public interface MovieDao {

	List<Movie> findMovies();
	
	Movie findMovieById(Long id);
	
	void save(Movie movie);
	
	void update(Movie movie);
	
	void remove(Movie movie);
	
	List<Movie> findMoviesByName(String filter);
}
