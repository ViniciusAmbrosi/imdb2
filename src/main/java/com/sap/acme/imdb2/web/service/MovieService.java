package com.sap.acme.imdb2.web.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.sap.acme.imdb2.entity.Movie;
import com.sap.acme.imdb2.repository.interfaces.MovieDao;
import com.sap.acme.imdb2.web.extension.MovieExtensions;
import com.sap.acme.imdb2.web.model.MovieModel;

@Service
public class MovieService {

	@Resource
	private MovieDao movieDao;
	
	public void saveOrUpdateMovie(MovieModel movieModel, String filePath){
		Movie movie = MovieExtensions.fromModel(movieModel, filePath);
		if(movie.getId() > 0){
			movieDao.update(movie);
		}
		else{
			movieDao.save(movie);
		}
	}
	
	public void delete(MovieModel movieModel){
		Movie movie = new Movie();
		movie.setId(movieModel.getId());
		movieDao.remove(movie);
	}
}
