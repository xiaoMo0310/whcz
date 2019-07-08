package com.atguigu.jdbc.whc.service;

import com.atguigu.jdbc.whc.po.Calendar;
import com.atguigu.jdbc.whc.po.ReadClock;

import java.util.List;
import java.util.Map;


public interface linkageHomeService {

	/** 首页点击封面获取书单 */
	
	
	/**
	 * 日历
	 * @param staffCode
	 * @param date
	 * @return
	 */
	List<Calendar> selectCalendarContent(String staffCode, String date);
	
	
	/**
	 * 考勤
	 * @param staffCode
	 * @param date
	 * @return
	 */
	List<Calendar> getAttendance(String staffCode, String date);
	
	String judgeRead(String staffCode, String date);
	

	public List<ReadClock>  getLinkage(Map<String, Object> map);

}


