package com.eternal.service.impl;

import java.util.List;

import com.eternal.dao.EmployeeDao;
import com.eternal.dao.impl.EmployeeDaoImpl;
import com.eternal.domain.UserInfo;
import com.eternal.service.EmployeeService;
import com.eternal.utils.PageBean;

	
public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDao employeeDao = new EmployeeDaoImpl() ;
	/* (non-Javadoc)
	 * @see com.eternal.service.impl.EmployeeService#upDate(com.eternal.domain.UserInfo)
	 */
	@Override
	public int upDate(UserInfo ui) {
		
		return this.employeeDao.upDate(ui);
	}
	/* (non-Javadoc)
	 * @see com.eternal.service.impl.EmployeeService#login(java.lang.String, java.lang.String)
	 */
	@Override
	public UserInfo login(String userNum, String userPw) {
		
		return this.employeeDao.login(userNum,userPw);
	}
	/* (non-Javadoc)
	 * @see com.eternal.service.impl.EmployeeService#delete(int)
	 */
	@Override
	public int delete(int user_id) {
		return this.employeeDao.delete(user_id);
		
	}
	/* (non-Javadoc)
	 * @see com.eternal.service.impl.EmployeeService#findAll()
	 */
	@Override
	public List<UserInfo> findAll() {
		return this.employeeDao.findAll();
	}
	/* (non-Javadoc)
	 * @see com.eternal.service.impl.EmployeeService#findById(int)
	 */
	@Override
	public UserInfo findById(int user_id) {
		
		return this.employeeDao.findById(user_id);
	}
	/* 
	 * 
	 * 分页查询
	 */
	/* (non-Javadoc)
	 * @see com.eternal.service.impl.EmployeeService#find(com.eternal.utils.PageBean, java.lang.String, java.lang.String)
	 */
	@Override
	public void find(PageBean<UserInfo> pageBean, String selectType,
			String selectContent) {
		int count = employeeDao.findRequiredCount(selectType,selectContent);
		pageBean.setTotalCount(count);
		int start = pageBean.getStartRow();
		int size = pageBean.getSize();
		List<UserInfo> list = employeeDao.findRequiredItems(start,size,selectType,selectContent);
		pageBean.setList(list);
		
		
	}

}
