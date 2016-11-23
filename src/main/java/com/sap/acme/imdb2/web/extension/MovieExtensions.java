package com.sap.acme.imdb2.web.extension;

import java.util.ArrayList;
import java.util.List;

import com.sap.acme.imdb2.entity.Movie;
import com.sap.acme.imdb2.web.model.MovieModel;

public class MovieExtensions {
	
	public static Movie fromModel(MovieModel movieModel, String filePath){
		Movie movie = new Movie();
		movie.setGenres(GenreExtensions.toGenreFromLong(movieModel.getGenres()));
		movie.setId(movieModel.getId() == null ? 0 : movieModel.getId());
		movie.setLength(movieModel.getLength());
		movie.setRating(movieModel.getRating());
		movie.setReleaseDate(movieModel.getReleaseDate());
		movie.setSynopsis(movieModel.getSynopsis());
		movie.setThumbnail(filePath.isEmpty() ? movieModel.getThumbnailPath() : filePath);
		movie.setTitle(movieModel.getTitle());
		return movie;
	}
	
	public static MovieModel toModel(Movie movie){
		MovieModel movieModel = new MovieModel();
		movieModel.setGenres(GenreExtensions.fromGenreToLong(movie.getGenres()));
		movieModel.setId(movie.getId());
		movieModel.setLength(movie.getLength());
		movieModel.setRating(movie.getRating());
		movieModel.setReleaseDate(movie.getReleaseDate());
		movieModel.setSynopsis(movie.getSynopsis());
		movieModel.setThumbnail(ImageExtensions.getMultipartFileFromFile(movie.getThumbnail()));
		movieModel.setThumbnailPath(movie.getThumbnail());
		movieModel.setTitle(movie.getTitle());
		return movieModel;
	}
	
	public static List<MovieModel> toModel(List<Movie> movies){
		List<MovieModel> moviesToModel = new ArrayList<MovieModel>();
		for(Movie movieModel : movies){
			moviesToModel.add(toModel(movieModel));
		}
		return moviesToModel;
	}
}
