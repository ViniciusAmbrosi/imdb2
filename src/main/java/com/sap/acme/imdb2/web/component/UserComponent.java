package com.sap.acme.imdb2.web.component;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import com.sap.acme.imdb2.web.model.UserModel;

@Component
public class UserComponent {
	
	private static final String USER = "user";
	
	public void bindNewUserModelToRegister(Model model){
		model.addAttribute(USER, new UserModel());
	}
}
