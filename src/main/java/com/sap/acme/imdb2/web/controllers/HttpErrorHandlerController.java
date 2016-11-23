package com.sap.acme.imdb2.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HttpErrorHandlerController {

	@RequestMapping(value="/400")
	public String error400(){
		return "error-400";
	}
	
	@RequestMapping(value="/404")
	public String error404(){
		return "redirect:/home";
	}
}
