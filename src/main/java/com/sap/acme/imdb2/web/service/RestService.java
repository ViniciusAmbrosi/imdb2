package com.sap.acme.imdb2.web.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sap.acme.imdb2.entity.Movie;
import com.sap.acme.imdb2.entity.User;
import com.sap.acme.imdb2.repository.interfaces.MovieDao;
import com.sap.acme.imdb2.repository.interfaces.UserDao;

@Service
public class RestService {

	@Resource
	private UserDao userDao;
	
	@Resource
	private	MovieDao movieDao;
	
	public User getUser(Long id){
		return userDao.findUserById(id);
	}
	
	public List<User> getUsers(){
		return userDao.findUsers();
	}
	
	public Movie getMovie(Long id){
		return movieDao.findMovieById(id);
	}
	
	public List<Movie> getMovies(){
		return movieDao.findMovies();
	}
}
