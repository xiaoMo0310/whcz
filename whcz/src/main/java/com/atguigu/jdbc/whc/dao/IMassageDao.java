package com.atguigu.jdbc.whc.dao;

import com.atguigu.jdbc.whc.po.Massage;

import java.util.List;
import java.util.Map;


public interface IMassageDao {
	
	public Integer findCount(Map<String, Object> map);/**查询信息的数量*/
	public List<Massage> findMassage(Map<String, Object> map);/**查询个人所有未读信息*/
	public int updateMassage(Map<String, Object> map);/**更新信息的状态*/

}
