package com.sap.acme.imdb2.web.controllers;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sap.acme.imdb2.web.component.UserComponent;
import com.sap.acme.imdb2.web.model.UserModel;
import com.sap.acme.imdb2.web.service.UserService;

@Controller
public class LoginController {

	@Resource
	private UserComponent userComponent;
	
	@Resource
	private UserService userService;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(){
		return "login";
	}
	
	@RequestMapping(value="/Access_Denied", method=RequestMethod.GET)
	public String acessDenied(){
		return "access-denied";
	}
	
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String register(Model model){
		userComponent.bindNewUserModelToRegister(model);
		return "user-form";
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String saveNewUser(@ModelAttribute("user") @Valid UserModel userModel, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return "user-form";
		}
		try {
			userService.saveOrUpdateUser(userModel);
		} catch (Exception e) {
			bindingResult.rejectValue("password", "400", e.getMessage().toString());
			bindingResult.rejectValue("passwordConfirmation", "400" ,e.getMessage().toString());
			return "user-form";
		}
		return "login";
	}
}
