package com.atguigu.jdbc.whc.controller.loginTest;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONException;
import com.atguigu.jdbc.whc.utils.Login.HttpRequest;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NewWXLoginController {



	@RequestMapping(value = "/decodeUserQY.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> decodeUserQYInfo(@RequestParam(value = "code") String code) {

		Map<String, Object> map = new HashMap<String, Object>();

		// 登录凭证不能为空
		if (code == null || code.length() == 0) {
			map.put("status", 0);
			map.put("msg", "code 不能为空");
			return map;
		}
		String accessToken="";
		try {
			accessToken=(String)accessToken().get("access_token");
		} catch (org.json.JSONException e) {
			e.printStackTrace();
		}

		// https://qyapi.weixin.qq.com/cgi-bin/miniprogram/jscode2session?access_token=ACCESS_TOKEN&js_code=CODE&grant_type=authorization_code
		 String params = "access_token=" + accessToken + "&js_code=" + code+ "&grant_type=" + "authorization_code";
		 String sr = HttpRequest.sendGet("https://qyapi.weixin.qq.com/cgi-bin/miniprogram/jscode2session", params);
		 System.out.println(sr);
		 JSONObject obj=null;

		try {
			obj=new JSONObject(sr);
		} catch (org.json.JSONException e) {
			e.printStackTrace();
		}

		map.put("status", 1);
		try {
			map.put("staffCode", obj.get("userid"));
		} catch (org.json.JSONException e) {
			e.printStackTrace();
		}
		System.out.println("++++++++++++++++++++++++++++++");
		System.out.println(map);
		System.out.println("++++++++++++++++++++++++++++++");
		return map;
	}


	
	//向服务器中要access_token
	public static JSONObject accessToken() {
		// 小程序唯一标识 (在微信小程序管理后台获取)
		String wxqyCorpid = "wx020f56c2a048cd2a";
		// 小程序的 app secret (在微信小程序管理后台获取)
		String wxqycorpsecret = "vilT_1Heb2l6brubKiwGFf9oxOqkAhNpbCKSOyxmoEo";
		// https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=wx020f56c2a048cd2a&corpsecret=vilT_1Heb2l6brubKiwGFf9oxOqkAhNpbCKSOyxmoEo
		String params = "corpid=" + wxqyCorpid + "&corpsecret=" + wxqycorpsecret;
		// 发送请求
		String sr = HttpRequest.sendGet("https://qyapi.weixin.qq.com/cgi-bin/gettoken", params);

		// 解析相应内容（转换成json对象）
		JSONObject json = null;
		try {
			json = new JSONObject(sr);
		} catch (org.json.JSONException e) {
			e.printStackTrace();
		}
		return json;
	}
	


    
    
    
    
    
    
    
    
    
}
