package com.sap.acme.imdb2.repository.interfaces;

import java.util.List;

import com.sap.acme.imdb2.entity.Movie;
import com.sap.acme.imdb2.entity.User;

public interface UserDao {

	User findByUsername(String username);
	
	User findUserById(Long id);
	
	void save(User user);
	
	void update(User user);
	
	boolean haveMovieOnWishlist(Long userId, Long movieId);
	
	List<Movie> findWishlist(Long id);
	
	List<User> findUsers();
}
