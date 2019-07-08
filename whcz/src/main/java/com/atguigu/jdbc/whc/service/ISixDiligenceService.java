package com.atguigu.jdbc.whc.service;

import com.atguigu.jdbc.whc.po.Menus;
import com.atguigu.jdbc.whc.po.PageBean;
import com.atguigu.jdbc.whc.po.SixDiligence;
import com.atguigu.jdbc.whc.utils.mybatis.paginator.domain.PageBounds;

import java.util.List;
import java.util.Map;


public interface ISixDiligenceService {
	
	public Map<String, Object> findSixDiligence(Map<String, Object> map);
	public PageBean<SixDiligence> findReadingFeeling(Map<String, Object> map, PageBounds pb);
	public PageBean<SixDiligence> findTips(Map<String, Object> map, PageBounds pb);
	public List<Menus> findCustomcontent(Map<String, Object> map);//根据时间查找自主内容
	/**查询部门或者事业部的日总结或者感想*/
	public Map<String, Object> findbydaydiligence(String staffcode, String date, String bumen);

}
