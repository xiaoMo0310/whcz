package com.atguigu.jdbc.whc.service;

import com.atguigu.jdbc.whc.po.Massage;
import com.atguigu.jdbc.whc.po.PageBean;
import com.atguigu.jdbc.whc.utils.mybatis.paginator.domain.PageBounds;

import java.util.Map;


public interface IMassageService {
	
	public PageBean<Massage> findMassage(Map<String, Object> map, PageBounds pb);/**查询所有信息流*/
	public Integer findCount(Map<String, Object> map);/**查询未读信息流的数量*/
	public int updateMassage(Map<String, Object> map);/**更新未读信息的状态*/

}
