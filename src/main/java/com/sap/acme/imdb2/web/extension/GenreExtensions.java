package com.sap.acme.imdb2.web.extension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sap.acme.imdb2.entity.Genre;
import com.sap.acme.imdb2.web.model.GenreModel;

public class GenreExtensions {

	public static Genre toGenreFromLong(Long id){
		Genre genre = new Genre();
		genre.setId(id);
		return genre;
	}
	
	public static Set<Genre> toGenreFromLong(List<Long> ids){
		Set<Genre> genres = new HashSet<Genre>();
		for(Long id : ids){
			genres.add(toGenreFromLong(id));
		}
		return genres;
	}
	
	public static List<Long> fromGenreToLong(Set<Genre> genres){
		List<Long> genresIds = new ArrayList<Long>();
		for(Genre genre : genres){
			genresIds.add(genre.getId());
		}
		return genresIds;
	}
	
	public static GenreModel toModel(Genre Genre){
		GenreModel genreModel = new GenreModel();
		genreModel.setId(Genre.getId());
		genreModel.setName(Genre.getName());
		return genreModel;
	}
	
	public static List<GenreModel> toModel(List<Genre> genres){
		List<GenreModel> genresToModel = new ArrayList<GenreModel>();
		for(Genre genre : genres){
			genresToModel.add(toModel(genre));
		}
		return genresToModel;
	}
}
