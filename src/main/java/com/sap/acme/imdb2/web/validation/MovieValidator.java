package com.sap.acme.imdb2.web.validation;

import org.springframework.stereotype.Component;

import com.sap.acme.imdb2.web.model.MovieModel;

@Component(value="movieValidator")
public class MovieValidator implements IMovieValidator{

	public boolean invalidRating(MovieModel movieModel) {
		return movieModel.getRating() <= 0.1 || movieModel.getRating() > 5;
	}
}	
