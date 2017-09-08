package com.eternal.service.impl;

import com.eternal.dao.UserDao;
import com.eternal.dao.impl.UserDaoImpl;
import com.eternal.domain.User;
import com.eternal.exception.UserExistException;
import com.eternal.exception.UserNotFoundException;
import com.eternal.utils.ServiceUtils;

public class UserServiceImpl {
	
	private UserDao dao = new UserDaoImpl();

	public void register(User user) throws UserExistException {
		boolean existFlag = dao.find(user.getUsername());
		if (existFlag) {
			throw new UserExistException();
		}
		user.setPassword(ServiceUtils.md5(user.getPassword()));
		dao.save(user);
	}
	
	public User	login(String username,String password) throws UserNotFoundException {
		password = ServiceUtils.md5(password);
		User user = dao.find(username, password);
		if(user==null) {
			throw new UserNotFoundException();
		}
		return user;
	}
}
