package com.sap.acme.imdb2.web.validation;

import com.sap.acme.imdb2.web.model.MovieModel;

public interface IMovieValidator {

	boolean invalidRating(MovieModel movieModel);
}
