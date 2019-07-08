package com.atguigu.jdbc.whc.service;

import com.atguigu.jdbc.whc.po.User;

import java.util.List;
import java.util.Map;


public interface UserService {

	
	public User getUserByIdAndName(Map<String, Object> map);
	
	public List<String>getDepartment(Map<String, Object> map);
	
	public List<User> getDepartmentPeople(Map<String, Object> map);
	
}
