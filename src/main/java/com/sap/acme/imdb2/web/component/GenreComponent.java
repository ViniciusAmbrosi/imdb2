package com.sap.acme.imdb2.web.component;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import com.sap.acme.imdb2.repository.interfaces.GenreDao;
import com.sap.acme.imdb2.web.extension.GenreExtensions;
import com.sap.acme.imdb2.web.model.GenreModel;

@Component
public class GenreComponent {
	
	private static final String GENRES = "genresList";
	
	@Resource
	private GenreDao genreDao;
	
	public void bindGenresModelToModel(Model model){
		final List<GenreModel> genres;
		genres = GenreExtensions.toModel(genreDao.findGenres());
		
		model.addAttribute(GENRES, genres);
	}
}
