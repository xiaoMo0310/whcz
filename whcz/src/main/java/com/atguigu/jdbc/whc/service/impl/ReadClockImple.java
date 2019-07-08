package com.atguigu.jdbc.whc.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.atguigu.jdbc.whc.common.CurrentTime;
import com.atguigu.jdbc.whc.dao.ReadClockDao;
import com.atguigu.jdbc.whc.po.DayRest;
import com.atguigu.jdbc.whc.po.NewLoginBean.Integral;
import com.atguigu.jdbc.whc.po.ReadClock;
import com.atguigu.jdbc.whc.po.ReadCount;
import com.atguigu.jdbc.whc.service.ReadClockService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

@Service("ReadClockService")
public class ReadClockImple implements ReadClockService {
	
	
	private static final Logger LOG = Logger.getLogger(ReadClockImple.class);

	@Resource
	private ReadClockDao readClockDao;

	/**
	 * 在readclock页面和"我的"页面查询读书感悟
	 */
	@Override

	public Map<String,Object> getReadIndex(String staffCode,String clockDate) {
		if(clockDate.equals("undefined")||clockDate==null){
			clockDate=CurrentTime.getCurrentTime();
		}
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("staffCode", staffCode);
		map.put("clockDate", clockDate);
		List<ReadClock> rc = readClockDao.findReadIndex(map);
		ReadCount rr = readClockDao.findCount(map);
		String r = readClockDao.findCountPeople(map);
		Map<String,Object> m=new HashMap<String,Object>();
		m.put("rc", rc);
		m.put("rr", rr);
		m.put("r", r);
		return m;
	}

	/**
	 * 数据的插入即更新 填写读书感悟
	 */
	@Override
	public void updateBook(Map<String,Object> map) {
		readClockDao.updateBook(map);
	}

	/**
	 * 展示读书页面中已读和需读的内容
	 */
	@Override
	public List<ReadClock> getReadIndex1(Map<String,Object> map) {
		map.put("beginClockDate", CurrentTime.getBeforeTime());
		map.put("endClockDate", CurrentTime.getAfterTime());
		return readClockDao.findReadIndex(map);
	}
	
	/**
	 * 该功能用来根据日历查询数据
	 */
	@Override
	public List<Map<String,Object>> getCalendar(Map<String,Object> map) {
	
		return 	readClockDao.selectCalendar(map);
	}

	/**
	 * 查询读书心得的积分
	 */
	@Override
	public String getIntegralRead(String staffCode, String clockDate) {
		return readClockDao.selectIntegralRead(staffCode, clockDate);
	}

	/**
	 * 绘制积分图案
	 */
	@Override
	public JSONObject getIconLevel(String staffCode) {
		Integral tconLevel = readClockDao.selectIconLevel(staffCode);
		JSONObject object=new JSONObject();
		String icon=tconLevel.getIcon();  //图标
		String[] icon1 = icon.split(",");
		object.put("icon1", icon1);
		object.put("integral", tconLevel);
		return object;
	}

	/**
	 * 该功能用来根据日历查询数据
	 */
	@Override
	public List <DayRest> getCalendar(String staffCode, String yearMonth ) {
		return readClockDao.selectCalendar(staffCode,yearMonth);
	}

	
	/**
	 * 根据假期判断 yearMonth:2019-02-01
	 */
	@Override
	public List<DayRest>  selectDayRest(String staffCode, String yearMonth,String yearDay,String status) {
	    Long beginCurrent=System.currentTimeMillis();
		String baseInfo = readClockDao.selectJibenxinxi(staffCode, yearDay);
		System.out.println(baseInfo==null||baseInfo.isEmpty());
		boolean flage=baseInfo==null||baseInfo.isEmpty();
		int i=1;
		while (flage) {
			i++;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			c.setTime(new Date());
			c.add(Calendar.MONTH, -1);
			Date m = c.getTime();
			String mon = sdf.format(m);
			yearDay=mon;
			baseInfo=readClockDao.selectJibenxinxi(staffCode, yearDay);
			flage=baseInfo==null||baseInfo.isEmpty();
			if(i>10){
				LOG.info("进入死循环被自动跳出");
				break;
			}
		}
		Long endCurrent=System.currentTimeMillis();
		List<DayRest>  dayRest=readClockDao.selectDayRest(staffCode, yearMonth,yearDay,status);
		LOG.info("----------selectDayRest---------用时"+(endCurrent-beginCurrent));
		 return dayRest;
	}
	
	

	
}








