package com.atguigu.jdbc.whc.controller.loginTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atguigu.jdbc.whc.common.ErrorCode;
import com.atguigu.jdbc.whc.common.JsonUtils;
import com.atguigu.jdbc.whc.common.ResponseUtils;
import com.atguigu.jdbc.whc.common.ReturnResult;
import com.atguigu.jdbc.whc.po.NewLoginBean.NewLogin;
import com.atguigu.jdbc.whc.po.User;
import com.atguigu.jdbc.whc.service.NewLoginService;
import com.atguigu.jdbc.whc.service.ReadClockService;
import com.atguigu.jdbc.whc.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value="/user")
public class WXRegController {
	
	
	@Autowired
	private NewLoginService newLoginService;
	
	@Autowired
	private ReadClockService readClockService;
	
	@Autowired
	private UserService userService;
	/**登录*/
	@ResponseBody
	@RequestMapping(value="/reg.do",method=RequestMethod.POST)
	public String regController(HttpServletRequest request, HttpServletResponse response,HttpSession session){
		String userId=request.getParameter("userId");
		String password=request.getParameter("pwd");
		String openId=request.getParameter("openId");
		Map<String,Object> map=new HashMap<String,Object>();
	    map.put("staffCode", userId);
	    map.put("staffPwd", password);
		User user = null;
		if(!StringUtils.isEmpty(userId) && !StringUtils.isEmpty(password)){
			user = userService.getUserByIdAndName(map);
			if(user != null){
				session.setAttribute("staffCode", userId);	
				newLoginService.regUser(userId,  password,  openId);
				return ReturnResult.successJson(null);
			}else{
				return ReturnResult.failJson(ErrorCode.NO_AUTH);
			}
		}else{
			return ReturnResult.failJson(ErrorCode.PARAM_EMPTY);
		}
		
		
		
     	}
	
	
	/**
	 * 
	 * 查询当天的读书内容信息
	 * @param request
	 * @param response
	 */
	 @RequestMapping(value = "/ClockInf.do")
		public void readClockCon( HttpServletRequest request, HttpServletResponse response) {
			String staffCode=request.getParameter("staffCode");
			String clockDate=request.getParameter("clockDate");
				Map<String,Object> re=readClockService.getReadIndex(staffCode,clockDate);
				ResponseUtils.renderJson(response, JsonUtils.toJson(re));
		}
	 
	 /**根据openId查询用户信息*/
	 @ResponseBody
	 @RequestMapping(value = "/newUser.do")
		public void getNewUser( HttpServletRequest request, HttpServletResponse response) {
			String openId= request.getParameter("openId");
			List<NewLogin> nn=newLoginService.getNewUser(openId);
			ResponseUtils.renderJson(response, JsonUtils.toJson(nn.get(0).getStaffCode()));	
		}
	 
	 
	 

}
