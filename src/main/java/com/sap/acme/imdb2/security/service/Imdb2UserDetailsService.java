package com.sap.acme.imdb2.security.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sap.acme.imdb2.entity.User;
import com.sap.acme.imdb2.repository.interfaces.UserDao;
import com.sap.acme.imdb2.security.model.LoggedUserModel;

@Service
public class Imdb2UserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username.isEmpty()) {
            throw new UsernameNotFoundException(String.format("User with username=%s was not found", username));
        }
        User user = userDao.findByUsername(username);
        user.setLastLogin(LocalDateTime.now());
        userDao.update(user);
        return new LoggedUserModel(user.getId(), user.getUsername(), user.getPassword(), user.getRoles(),
        					 user.getName(),user.getLastLogin());
    }
}
