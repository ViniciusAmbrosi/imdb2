package com.sap.acme.imdb2.web.controllers;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.sap.acme.imdb2.web.component.MovieComponent;

@Controller
public class HomeController {

	@Resource
	private MovieComponent movieComponent;
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String home(Model model){
		movieComponent.bindMoviesToModel(model);
		return "home";
	}
}
