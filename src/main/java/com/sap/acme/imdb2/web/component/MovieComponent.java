package com.sap.acme.imdb2.web.component;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.sap.acme.imdb2.entity.Movie;
import com.sap.acme.imdb2.entity.User;
import com.sap.acme.imdb2.repository.interfaces.MovieDao;
import com.sap.acme.imdb2.repository.interfaces.UserDao;
import com.sap.acme.imdb2.web.extension.MovieExtensions;
import com.sap.acme.imdb2.web.extension.UserExtensions;
import com.sap.acme.imdb2.web.model.MovieModel;

@Component
public class MovieComponent {

	private static final String MOVIES = "movies";
	private static final String MOVIE = "movie";
	private static final String IN_WISHLIST = "inWishlist";
	
	@Resource
	private MovieDao movieDao;
	
	@Resource
	private UserDao userDao;
	
	public void bindMoviesToModel(Model model){
		final List<Movie> movies;
		movies = movieDao.findMovies();
		
		model.addAttribute(MOVIES, movies);
	}
	
	public void bindExistingMovieToModel(Long id, Model model) throws Exception{
		final Movie movie;
		movie = movieDao.findMovieById(id);
		
		if(movie == null){
			throw new Exception();
		}
		
		final User loggedUser;
		loggedUser = UserExtensions.fromSecurityModel(UserExtensions.getLoggedUser());
		
		final Long loggedUserId;
		loggedUserId = loggedUser == null ? 0 : loggedUser.getId();
		
		final boolean userHasMovieOnWishlist;
		userHasMovieOnWishlist = userDao.haveMovieOnWishlist(loggedUserId, id);
		
		model.addAttribute(MOVIE, movie);
		model.addAttribute(IN_WISHLIST, userHasMovieOnWishlist);
	}
	
	public void bindNewMovieModelToModel(Model model){
		model.addAttribute(MOVIE, new MovieModel());
	}
	
	public void bindEditableMovieToModel(Long id, Model model) throws Exception{
		final Movie movie;
		movie = movieDao.findMovieById(id);

		if(movie == null){
			throw new Exception();
		}
		
		MovieModel movieModel = MovieExtensions.toModel(movie);
		
		model.addAttribute(MOVIE, movieModel);
	}
	
	public void bindFilteredMoviesToModel(Model model, String filter){
		final List<Movie> movies;
		movies = movieDao.findMoviesByName(filter);
		
		model.addAttribute(MOVIES, movies);
	}
	
	public void bindWishListToModel(Long movieId,Model model){
		final List<Movie> movies;
		movies = userDao.findWishlist(movieId);
		
		model.addAttribute(MOVIES, movies);
	}
	
	public void bindWishlistMoviesToModel(Model model){
		final User loggedUser;
		loggedUser = UserExtensions.fromSecurityModel(UserExtensions.getLoggedUser());
		
		final Long loggedUserId;
		loggedUserId = loggedUser == null ? 0 : loggedUser.getId();
		
		List<Movie> wishlist = userDao.findWishlist(loggedUserId);
		
		model.addAttribute(MOVIES, wishlist);
	}
}
