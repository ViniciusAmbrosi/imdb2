package com.sap.acme.imdb2.web.component;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sap.acme.imdb2.web.model.MovieModel;

@Component
public class ModelComponent {

	private static final String MOVIE = "movie";
	private static final String ATTRIBUTE = "attribute";
	private static final String MESSAGE = "message";
	
	@Resource
	private GenreComponent genreComponent;
	
	public void bindModelForRedirectOnSaveError(MovieModel movieModel, RedirectAttributes redirectAttributes,
												String attribute, String message){
		redirectAttributes.addFlashAttribute(ATTRIBUTE, attribute);
		redirectAttributes.addFlashAttribute(MESSAGE, message);
		redirectAttributes.addFlashAttribute(MOVIE, movieModel);
	}
}
