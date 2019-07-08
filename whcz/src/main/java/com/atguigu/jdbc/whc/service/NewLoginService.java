package com.atguigu.jdbc.whc.service;

import com.atguigu.jdbc.whc.po.NewLoginBean.ListAllFeeling;
import com.atguigu.jdbc.whc.po.NewLoginBean.NewLogin;
import com.atguigu.jdbc.whc.po.PageBean;
import com.atguigu.jdbc.whc.utils.mybatis.paginator.domain.PageBounds;

import java.util.List;
import java.util.Map;


public interface NewLoginService {
	
	/*插入用户信息*/
	void insertUser(Map<String, Object> map);
	void deleteUser(Map<String, Object> map);
	
	public List<NewLogin> getUser(Map<String, Object> map);
	
	void regUser(String userId, String password, String openId);
	
	public List<NewLogin> getNewUser(String openId);
	
	/**
	 * 用于展示用户的感想
	 */
	PageBean<ListAllFeeling> getAllFeeling(Map<String, Object> map, PageBounds pb);
	
	List<NewLogin> selectUser(Map<String, Object> map);
	/**
	 * 用于头像的显示
	 * */
	ListAllFeeling findbaseByCode(String staffCode);
	
	/**
	 * 若用户信息已存在更新
	 * @param map
	 */
	void updateUser(Map<String, Object> map);
	
	

}
