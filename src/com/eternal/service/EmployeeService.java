package com.eternal.service;

import java.util.List;

import com.eternal.domain.UserInfo;
import com.eternal.utils.PageBean;

public interface EmployeeService {

	int upDate(UserInfo ui);

	UserInfo login(String userNum, String userPw);

	int delete(int user_id);

	List<UserInfo> findAll();

	UserInfo findById(int user_id);

	/* 
	 * 
	 * 分页查询
	 */
	void find(PageBean<UserInfo> pageBean, String selectType, String selectContent);

}