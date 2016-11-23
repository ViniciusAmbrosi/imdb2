package com.sap.acme.imdb2.web.controllers;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.sap.acme.imdb2.entity.Movie;
import com.sap.acme.imdb2.entity.User;
import com.sap.acme.imdb2.web.service.RestService;

@RestController
@RequestMapping(value="/rest")
public class WebServiceController {

	@Resource
	private RestService restService;
	
	@RequestMapping(value="/movie/{id}", method=RequestMethod.GET)
	public Movie getMovie(@PathVariable("id") Long id){
		return restService.getMovie(id);
	}
	
	@RequestMapping(value="/movies", method=RequestMethod.GET)
	public List<Movie> getMovies(){
		return restService.getMovies();
	}
	
	@RequestMapping(value="/user/{id}", method=RequestMethod.GET)
	public User getUser(@PathVariable("id") Long id){
		return restService.getUser(id);
	}
	
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public List<User> getUsers(){
		return restService.getUsers();
	}
}
