package com.atguigu.jdbc.whc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.atguigu.jdbc.whc.dao.NewLoginPage;
import com.atguigu.jdbc.whc.po.NewLoginBean.ListAllFeeling;
import com.atguigu.jdbc.whc.po.NewLoginBean.NewLogin;
import com.atguigu.jdbc.whc.po.PageBean;
import com.atguigu.jdbc.whc.service.NewLoginService;
import com.atguigu.jdbc.whc.utils.mybatis.paginator.domain.PageBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;



@Service(value="NewLoginService")
public class NewLoginImple implements NewLoginService {
	
	@Autowired
	private NewLoginPage newLoginPage;

	@Override
	public void insertUser(Map<String,Object> map) {
		newLoginPage.insertUser(map);
		
	}

	@Override
	public List<NewLogin> getUser(Map<String,Object> map) {
		return newLoginPage.findUser(map);
	}

	@Override
	public void regUser(String userId, String password, String openId) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("openId", openId);
		map.put("userId", userId);
		map.put("password", password);
		newLoginPage.updateUserNewe(map);
		newLoginPage.deleteUserByOpenId(map);
	}

	@Override
	public List<NewLogin> getNewUser(String openId) {		
		return newLoginPage.findNewUser(openId);
	}
   
	
	/**
	 * 显示用户的所有感想
	 */
	@Override
	public PageBean<ListAllFeeling> getAllFeeling(Map<String,Object> map, PageBounds pb) {
	    PageHelper.startPage(pb.getPage(), pb.getLimit());
		List<ListAllFeeling> list=newLoginPage.findAllFeeling(map);
		System.out.println(list);
		PageBean<ListAllFeeling>  pageBean  = new PageBean<>(list);
		return pageBean;
		
	}

	@Override
	public void deleteUser(Map<String,Object> map) {
		newLoginPage.deleteUser(map);
		
	}

	@Override
	public List<NewLogin> selectUser(Map<String,Object> map) {	
		return newLoginPage.selectUser(map);
	}
	
	@Override
	public ListAllFeeling findbaseByCode(String staffCode) {	
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("staffCode", staffCode);
		return newLoginPage.findbaseByCode(map);
	}

	@Override
	public void updateUser(Map<String,Object> map) {
		newLoginPage.updateUser(map);
		
	}
}












