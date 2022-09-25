package com.upsidedown.dao;

import com.upsidedown.model.User;
import com.upsidedown.model.exception.UserAlreadyExistsException;
import com.upsidedown.model.exception.UserNotFoundException;

public interface UserDao {
	
	public boolean saveUser(User user) throws UserAlreadyExistsException;
	public User getUser(String username,String password) throws UserNotFoundException;
	public boolean userExists(String username);
}
