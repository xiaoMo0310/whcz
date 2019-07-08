package com.atguigu.jdbc.whc.controller.readClock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.jdbc.whc.common.CurrentTime;
import com.atguigu.jdbc.whc.common.EmojiUtil;
import com.atguigu.jdbc.whc.common.JsonUtils;
import com.atguigu.jdbc.whc.common.ResponseUtils;
import com.atguigu.jdbc.whc.po.NewLoginBean.ListAllFeeling;
import com.atguigu.jdbc.whc.po.NewLoginBean.NewLogin;
import com.atguigu.jdbc.whc.po.PageBean;
import com.atguigu.jdbc.whc.po.ReadClock;
import com.atguigu.jdbc.whc.service.NewLoginService;
import com.atguigu.jdbc.whc.service.ReadClockService;
import com.atguigu.jdbc.whc.utils.mybatis.paginator.domain.PageBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @author jxy
 *
 */
@Controller
public class ReadClockController {
	
	@Autowired
	private ReadClockService readClockService;
	
	@Autowired
	private NewLoginService newLoginService;
	
	/**
	 * 在readclock页面和"我的"页面查询读书感悟
	 * @param request
	 * @param response
	 */
 	 @RequestMapping(value = "/ReadClockInf.do")
	public void readClockCon( HttpServletRequest request, HttpServletResponse response) {
		String staffCode=request.getParameter("staffCode");
		String clockDate=request.getParameter("clockDate");
		System.out.println(clockDate);
		Map<String,Object> re=readClockService.getReadIndex(staffCode,clockDate);
		ResponseUtils.renderJson(response, JsonUtils.toJson(re));
	}
	
	/**
	 * 数据的插入即更新
	 * 填写读书感悟
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/tips.do")
	public void updateClock(HttpServletRequest request,HttpServletResponse response){
		String staffCode=request.getParameter("staffCode");//员工编码                                                  //计划读书日期
		String timeLength=request.getParameter("timeLength");  //读书时长
		String feeling=EmojiUtil.onlyEmojiToUnicode(request.getParameter("bookTips"));  //读书感悟
		String clockDate=request.getParameter("clockDate");   
		String reedNum=request.getParameter("num");      //读书的字数
		if(clockDate.equals("undefined")||clockDate==null){
			clockDate=CurrentTime.getCurrentTime();
		}
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("staffCode", staffCode);
		map.put("timeLength", timeLength);
		map.put("feeling", feeling);
		map.put("clockDate", clockDate);
		map.put("num", reedNum);
		readClockService.updateBook(map);
		System.out.println("插入或修改成功");	
	}
	
	/**
	 * 列表展现
	 * 展示读书页面中已读和需读的内容
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/listTips.do")
	public void ListClock(HttpServletRequest request,HttpServletResponse response){
		/*这儿再2.0做了修改注意查看*/
		String openId=request.getParameter("openId");//员工编码    
		//根据openIdc查询用户名
		List<NewLogin> login=newLoginService.getNewUser(openId);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("staffCode", login.get(0).getStaffCode());
		List<ReadClock> list=readClockService.getReadIndex1(map);
		ResponseUtils.renderJson(response, JsonUtils.toJson(list));
	}
	
	/**
	 * 展示首页面读书心得列表
	 * @param request
	 * @param response
	 * @param dep
	 */
	@ResponseBody
	@RequestMapping(value="/listAllFeeling.do")
	public void findAllFeeling(HttpServletRequest request,HttpServletResponse response){
		String staffCode=request.getParameter("staffCode");
		String dep= request.getParameter("dep");
		int page=Integer.valueOf(request.getParameter("page"));
		int limit=Integer.valueOf(request.getParameter("limit"));
		Map<String,Object> map =new HashMap<String,Object>();
		map.put("staffCode", staffCode);
		map.put("dep", dep);
		PageBounds pb = new PageBounds(page,limit);
		PageBean<ListAllFeeling> list=newLoginService.getAllFeeling(map,pb);
		System.out.println(list);
		ResponseUtils.renderJson(response, JsonUtils.toJson(list));	
	}
	
	/**在my页面查询头像、姓名和部门*/
	@ResponseBody
	@RequestMapping(value="/findbaseByCode.do")
	public void findbaseByCode(HttpServletRequest request,HttpServletResponse response){
		String staffCode=request.getParameter("staffCode");
		ResponseUtils.renderJson(response, JsonUtils.toJson( newLoginService.findbaseByCode(staffCode)));
	}
	
	
	/**
	 * 日历
	 * @param request
	 * @param response
	 */
	@ResponseBody
	@RequestMapping(value="/findCalendar.do")
	public void findCalendar(HttpServletRequest request,HttpServletResponse response){
		String staffCode=request.getParameter("staffCode");
		String yearMonth=request.getParameter("yearMonth");

		ResponseUtils.renderJson(response, JsonUtils.toJson(readClockService.getCalendar(staffCode,yearMonth)));
	}
	
	/**
	 * 日历假期
	 * @param request
	 * @param response
	 */
	@ResponseBody
	@RequestMapping(value="/dayRest.do")
	public void DayRest(HttpServletRequest request,HttpServletResponse response){
		String staffCode=request.getParameter("staffCode");
		String yearMonth=request.getParameter("yearMonth");
		ResponseUtils.renderJson(response, JsonUtils.toJson(readClockService.selectDayRest(staffCode, yearMonth,yearMonth,"dateLike")));
	}
	
	
	/***
	 * 查询读书积分
	 * @param request
	 * @param response
	 */
	@ResponseBody
	@RequestMapping(value="/integralRead.do")
	public void integralRead(HttpServletRequest request,HttpServletResponse response){
		String staffCode=request.getParameter("staffCode");
		String clockDate=request.getParameter("clockDate");
		ResponseUtils.renderJson(response, JsonUtils.toJson(readClockService.getIntegralRead(staffCode, clockDate)));
	}
	
	
	/**
	 * 绘制积分图案
	 * @param request
	 * @param response
	 */
	@ResponseBody
	@RequestMapping(value="/iconLevel.do")
	public void iconLevel(HttpServletRequest request,HttpServletResponse response){
		String staffCode=request.getParameter("staffCode");
		ResponseUtils.renderJson(response, JsonUtils.toJson(readClockService.getIconLevel(staffCode)));
	}
	
}










