package com.atguigu.jdbc.whc.dao;

import com.atguigu.jdbc.whc.po.ReadClock;

import java.util.List;
import java.util.Map;

/** 首页点击封面获取书单 */
public interface LinkageHomeDao {
	
	public List<ReadClock> findLinkage(Map<String, Object> map);

}
