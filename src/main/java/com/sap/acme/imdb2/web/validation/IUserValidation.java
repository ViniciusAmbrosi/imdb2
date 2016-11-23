package com.sap.acme.imdb2.web.validation;

public interface IUserValidation {

	boolean invalidPasswords(String password, String passwordConfirmation);
	boolean passwordsMatch(String password, String passwordConfirmation);
}
