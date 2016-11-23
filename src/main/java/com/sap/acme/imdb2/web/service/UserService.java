package com.sap.acme.imdb2.web.service;

import javax.annotation.Resource;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sap.acme.imdb2.entity.User;
import com.sap.acme.imdb2.repository.interfaces.UserDao;
import com.sap.acme.imdb2.web.extension.UserExtensions;
import com.sap.acme.imdb2.web.model.UserModel;
import com.sap.acme.imdb2.web.validation.IUserValidation;

@Service
public class UserService {

	@Resource
	private UserDao userDao;
	
	@Resource
	private IUserValidation userValidator;
	
	public void saveOrUpdateUser(UserModel userModel) throws Exception{
		User user = UserExtensions.fromModel(userModel);
		if(userValidator.invalidPasswords(userModel.getPassword(), userModel.getPasswordConfirmation())){
			throw new Exception("The passwords must not be empty or whitespaces.");
		}
		if(!userValidator.passwordsMatch(userModel.getPassword(), userModel.getPasswordConfirmation())){
			throw new Exception("The password and password confirmation must match.");
		}
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		if(user.getId() == null){
			userDao.save(user);
		}
		else{
			userDao.update(user);
		}
	}
}
