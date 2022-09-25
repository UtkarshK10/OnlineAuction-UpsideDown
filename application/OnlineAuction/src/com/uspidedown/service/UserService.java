package com.uspidedown.service;

import com.upsidedown.model.User;
import com.upsidedown.model.exception.UserAlreadyExistsException;
import com.upsidedown.model.exception.UserNotFoundException;

public interface UserService {
	public boolean saveUser(User user) throws UserAlreadyExistsException;
	public User getUser(String username,String password) throws UserNotFoundException;
}
