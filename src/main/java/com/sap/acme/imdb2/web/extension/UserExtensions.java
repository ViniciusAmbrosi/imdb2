package com.sap.acme.imdb2.web.extension;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;

import com.sap.acme.imdb2.entity.User;
import com.sap.acme.imdb2.security.model.LoggedUserModel;
import com.sap.acme.imdb2.web.model.UserModel;

public class UserExtensions {

	public static User fromModel(UserModel userModel){
		User user = new User();
		user.setId(userModel.getId());
		user.setLastLogin(userModel.getLastLogin());
		user.setName(userModel.getName());
		user.setPassword(userModel.getPassword());
		user.setRoles(RoleExtensions.fromModel(userModel.getRoles()));
		user.setUsername(userModel.getUsername());
		return user;
	}
	
	public static List<User> fromModel(List<UserModel> usersModel){
		List<User> users = new ArrayList<User>();
		for(UserModel userModel : usersModel){
			users.add(fromModel(userModel));
		}
		return users;
	}
	
	public static UserModel toModel(User user){
		UserModel userModel = new UserModel();
		userModel.setId(user.getId());
		userModel.setLastLogin(user.getLastLogin());
		userModel.setName(user.getName());
		userModel.setPassword(user.getPassword());
		userModel.setRoles(RoleExtensions.toModel(user.getRoles()));
		userModel.setUsername(user.getUsername());
		return userModel;
	}
	
	public static List<UserModel> toModel(List<User> users){
		List<UserModel> usersModel = new ArrayList<UserModel>();
		for(User user : users){
			usersModel.add(toModel(user));
		}
		return usersModel;
	}
	
	public static User fromSecurityModel(LoggedUserModel model){
		if(model == null){
			return null;
		}
		User user = new User();
		user.setId(model.getId());
		user.setLastLogin(model.getLastLogin());
		user.setName(model.getName());
		user.setPassword(model.getPassword());
		user.setRoles(model.getRoles() == null ? null : model.getRoles());
		user.setUsername(model.getUsername());
		return user;
	}
	
	public static LoggedUserModel getLoggedUser(){
		try{
			return (LoggedUserModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch(Exception e){
			return null;
		}
	}
}
