package com.atguigu.jdbc.whc.dao;

import java.util.List;

import com.atguigu.jdbc.whc.po.Calendar;
import org.apache.ibatis.annotations.Param;


public interface CalendarDao {
	
	/**
	 * 日历模块
	 * @param staffCode
	 * @param date
	 * @return
	 */
	List<Calendar> selectCalendarContent(@Param(value = "staffCode") String staffCode, @Param(value = "date") String date);
	
	
	
	
	
	/**
	 * 考勤模块
	 * @param staffCode
	 * @param date
	 * @return
	 */
	List<String> selectAttendance(@Param(value = "staffCode") String staffCode, @Param(value = "date") String date);
	
	
	/**
	 * 查询前一天的日期
	 * @param staffCode
	 * @param date
	 * @return
	 */
	Calendar selectBefore(@Param(value = "staffCode") String staffCode, @Param(value = "beforeDay") String beforeDay);
	
	
	/**
	 * 判断指定日期是否有读书内容
	 * @param staffCode
	 * @param date
	 * @return
	 */
	String judgeRead(@Param(value = "staffCode") String staffCode, @Param(value = "date") String date);
	

	
}
