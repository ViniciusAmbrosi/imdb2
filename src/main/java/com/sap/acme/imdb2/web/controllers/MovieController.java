package com.sap.acme.imdb2.web.controllers;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.sap.acme.imdb2.web.component.GenreComponent;
import com.sap.acme.imdb2.web.component.ModelComponent;
import com.sap.acme.imdb2.web.component.MovieComponent;
import com.sap.acme.imdb2.web.model.MovieModel;
import com.sap.acme.imdb2.web.service.MovieService;
import com.sap.acme.imdb2.web.upload.service.UploadService;
import com.sap.acme.imdb2.web.validation.IMovieValidator;

@Controller
@RequestMapping(value="/movie")
public class MovieController {
	
	@Resource
	private MovieComponent movieComponent;
	
	@Resource
	private GenreComponent genreComponent;
	
	@Resource
	private MovieService movieService;
	
	@Resource
	private IMovieValidator movieValidator;
	
	@Resource
	private ModelComponent modelComponent;
	
	@Resource
	private UploadService uploadService;
	
	@RequestMapping(value="/details/{id}", method=RequestMethod.GET)
	public String details(@PathVariable("id") Long id, Model model){
		try {
			movieComponent.bindExistingMovieToModel(id, model);
		} catch (Exception e) {
			return "movie-error";
		}
		return "movie-details";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String create(Model model){
		movieComponent.bindNewMovieModelToModel(model);
		genreComponent.bindGenresModelToModel(model);
		return "movie-form";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String save(@Valid @ModelAttribute("movie") MovieModel movie, 
					   BindingResult result, Model model, 
					   HttpServletRequest request,
					   RedirectAttributes redirectAttributes){
		if(result.hasErrors()){
			genreComponent.bindGenresModelToModel(model);
			return "movie-form";
		}
		String referer = request.getHeader("Referer").replaceAll("/error", "");
		String filePath = "";
		if(movieValidator.invalidRating(movie)){
			modelComponent.bindModelForRedirectOnSaveError(movie, redirectAttributes, "rating", "The rating value must be greater than zero and less than or equal to 5. Please try again.");
			return "redirect:"+ referer + "/error";
		}
		try {
			filePath = uploadService.saveFileAndReturnPath(movie);
		} catch (Exception ex) {
			modelComponent.bindModelForRedirectOnSaveError(movie, redirectAttributes, "thumbnail", ex.getMessage());
			return "redirect:"+ referer + "/error";
		}
		movieService.saveOrUpdateMovie(movie, filePath);
		return "redirect:/home";
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String edit(@PathVariable("id") Long id, Model model){
		try {
			movieComponent.bindEditableMovieToModel(id, model);
		} catch (Exception e) {
			return "movie-error";
		}
		genreComponent.bindGenresModelToModel(model);
		return "movie-form";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(MovieModel movieModel){
		movieService.delete(movieModel);
		return "redirect:/home";
	}
	
	@RequestMapping(value="/register/error")
	public String newRegisterError(Model model, @Valid @ModelAttribute("movie") MovieModel movie, BindingResult result,
								  @ModelAttribute("attribute") String attribute, @ModelAttribute("message") String message){
		result.rejectValue(attribute, "400", message);
		genreComponent.bindGenresModelToModel(model);
		return "movie-form";
	}
	
	@RequestMapping(value="/edit/{id}/error")
	public String editError(@PathVariable("id") Long id, Model model, @Valid @ModelAttribute("movie") MovieModel movie, BindingResult result,
							@ModelAttribute("attribute") String attribute, @ModelAttribute("message") String message){
		result.rejectValue(attribute, "400", message);
		genreComponent.bindGenresModelToModel(model);
		return "movie-form";
	}
	
	@RequestMapping(value="/filterByName", method=RequestMethod.GET)
	public String filterByName(String filter, Model model){
		movieComponent.bindFilteredMoviesToModel(model, filter);
		return "movie-list";
	}
}

