package com.sap.acme.imdb2.web.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sap.acme.imdb2.entity.Movie;
import com.sap.acme.imdb2.entity.User;
import com.sap.acme.imdb2.repository.interfaces.UserDao;
import com.sap.acme.imdb2.web.extension.UserExtensions;

@Service
public class WishlistService {

	@Resource
	private UserDao userDao;

	public void updateWishlist(Long movieId){
		User user = UserExtensions.fromSecurityModel(UserExtensions.getLoggedUser());
		Set<Movie> wishlist = new HashSet<Movie>(findWishlist(user.getId()));
		Movie movie = new Movie();
		movie.setId(movieId);
		wishlist.add(movie);
		user.setWishlist(wishlist);
		userDao.update(user);
	}
	
	public boolean haveMovieOnTheWishlist(Long movieId){
		User user = UserExtensions.fromSecurityModel(UserExtensions.getLoggedUser());
		return userDao.haveMovieOnWishlist(user.getId(), movieId);
	}
	
	public void removeFromWishlist(Long movieId){
		User user = UserExtensions.fromSecurityModel(UserExtensions.getLoggedUser());
		Set<Movie> wishlist = new HashSet<Movie>(findWishlist(user.getId()));
		wishlist = wishlist.stream().filter(x -> x.getId() != movieId).collect(Collectors.toSet());
		user.setWishlist(wishlist);
		userDao.update(user);
	}
	
	private List<Movie> findWishlist(Long id){
		return userDao.findWishlist(id);
	}
}
