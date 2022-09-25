package com.upsidedown.service.impl;

import com.upsidedown.dao.UserDao;
import com.upsidedown.dao.impl.UserDaoImpl;
import com.upsidedown.factory.BeanFactory;
import com.upsidedown.model.User;
import com.upsidedown.model.exception.UserAlreadyExistsException;
import com.upsidedown.model.exception.UserNotFoundException;
import com.uspidedown.service.UserService;

public class UserServiceImpl implements UserService {
	UserDao userDao = new UserDaoImpl();
	
	@Override
	public boolean saveUser(User user) throws UserAlreadyExistsException {
		return userDao.saveUser(user);
	}

	@Override
	public User getUser(String username, String password) throws UserNotFoundException {
		return userDao.getUser(username, password);
	}

}
