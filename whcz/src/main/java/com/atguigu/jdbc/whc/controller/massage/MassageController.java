package com.atguigu.jdbc.whc.controller.massage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atguigu.jdbc.whc.common.JsonUtils;
import com.atguigu.jdbc.whc.common.ResponseUtils;
import com.atguigu.jdbc.whc.po.User;
import com.atguigu.jdbc.whc.service.ICommunityService;
import com.atguigu.jdbc.whc.service.IStutasService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
/**信息流*/
@Controller
public class MassageController{
	@Resource
	private IStutasService stutasService;
	@Resource
	private ICommunityService communityService;
	
	/**统计未读信息流个数*/
	@RequestMapping(value="massageCount.do")
	@ResponseBody
	public void findMassageCount(String user,HttpServletRequest request, HttpServletResponse response,HttpSession session){
		String staffCode=request.getParameter("staffCode");
		User users=JSON.parseObject(user,User.class);
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("staffCode", staffCode);
		Integer countMassage=communityService.getunlessMsgCount(users);
		Integer countFabulous=stutasService.selectFabulousNum(map);
		List<Integer> count=new ArrayList<Integer>();
		count.add(countMassage);
		count.add(countFabulous);
		ResponseUtils.renderJson(response, JsonUtils.toJson(count));
	}
	
}
