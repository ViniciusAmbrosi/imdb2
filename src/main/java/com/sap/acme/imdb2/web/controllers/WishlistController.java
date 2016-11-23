package com.sap.acme.imdb2.web.controllers;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sap.acme.imdb2.web.component.MovieComponent;
import com.sap.acme.imdb2.web.service.UserService;
import com.sap.acme.imdb2.web.service.WishlistService;

@Controller
@RequestMapping(value="/wishlist")
public class WishlistController {

	@Resource
	private MovieComponent movieComponent;
	
	@Resource
	private WishlistService wishlistService;
	
	@Resource
	private UserService userService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String findWishlist(Model model){
		movieComponent.bindWishlistMoviesToModel(model);
		return "wishlist";
	}
	
	@ResponseBody
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addMovieToWishlist(Long movieId){
		if(wishlistService.haveMovieOnTheWishlist(movieId)){
			throw new IllegalArgumentException();
		}
		wishlistService.updateWishlist(movieId);
		return movieId.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public String removeMovieFromWishlist(Long movieId){
		if(wishlistService.haveMovieOnTheWishlist(movieId)){
			wishlistService.removeFromWishlist(movieId);
			return movieId.toString();
		}
		throw new IllegalArgumentException();
	}
}
