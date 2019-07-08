package com.atguigu.jdbc.whc.controller.basicInformation;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.jdbc.whc.common.JsonUtils;
import com.atguigu.jdbc.whc.common.ResponseUtils;
import com.atguigu.jdbc.whc.service.AnoucemtService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**公告内容的控制器*/
@Controller
public class AnoucemtWeb {

	@Resource
	private AnoucemtService actService;
	@RequestMapping("findnowdaytitle.do")
	public void findnowdaytitle(HttpServletRequest request,HttpServletResponse response,String nowday){
		ResponseUtils.renderJson(response, JsonUtils.toJson(actService.nowdaytitle(nowday)));
	}
	
}
