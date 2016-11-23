package com.sap.acme.imdb2.web.validation;

import org.springframework.stereotype.Component;

@Component(value="userValidator")
public class UserValidation implements IUserValidation{

	@Override
	public boolean passwordsMatch(String password, String passwordConfirmation) {
		return password.equals(passwordConfirmation);
	}

	@Override
	public boolean invalidPasswords(String password, String passwordConfirmation) {
		return password == null && passwordConfirmation == null ||
			   password.trim().isEmpty() && passwordConfirmation.trim().isEmpty() ;
	}
}
