package com.atguigu.jdbc.whc.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.atguigu.jdbc.whc.dao.IUserUserDao;
import com.atguigu.jdbc.whc.po.User;
import com.atguigu.jdbc.whc.service.UserService;
import org.springframework.stereotype.Service;

@Service("UserService")
public  class UserServiceImple implements UserService {

	@Resource
	private IUserUserDao iUserUserDao;

	@Override
	public User getUserByIdAndName(Map<String, Object> map) {
		User user=iUserUserDao.findUserByIdAndName(map);
		return user;
	}
   
	/**
	 * 查询部门
	 */
	@Override
	public List<String> getDepartment(Map<String, Object> map) {
		List<String> lists=iUserUserDao.findDepartment(map);
		return lists;
	}
    
	
	/**
	 * 通过部门查询部门中的人
	 */
	@Override
	public List<User> getDepartmentPeople(Map<String, Object> map) {
		List<User> lists =iUserUserDao.findDepartmentPeople(map);
		return lists;
	}
	
	




}




