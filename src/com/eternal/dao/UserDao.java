package com.eternal.dao;

import com.eternal.domain.User;

public interface UserDao {

	void save(User user);

	User find(String username, String password);

	boolean find(String username);

}