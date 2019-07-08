package com.atguigu.jdbc.whc.controller.readClock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.jdbc.whc.common.JsonUtils;
import com.atguigu.jdbc.whc.common.ResponseUtils;
import com.atguigu.jdbc.whc.service.linkageHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="calendar")
public class CalendarController {
	
	@Autowired
	private linkageHomeService inkageHomeService;
	
	@RequestMapping(value = "calContent.do")
	public void Linkage(HttpServletRequest request, HttpServletResponse response,String staffCode,String date) {
		ResponseUtils.renderJson(response, JsonUtils.toJson(inkageHomeService.selectCalendarContent(staffCode,date)));
	}
	
	@RequestMapping(value = "judgeReadCont.do")
	public void judgeRead(HttpServletRequest request, HttpServletResponse response,String staffCode,String clockDate){
		ResponseUtils.renderJson(response, JsonUtils.toJson(inkageHomeService.judgeRead(staffCode, clockDate)));
	}

}
