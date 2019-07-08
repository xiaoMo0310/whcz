package com.atguigu.jdbc.whc.controller.version;

import javax.annotation.Resource;

import com.atguigu.jdbc.whc.service.IVersionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**控制版本的显示隐藏*/
@Controller
public class VersionController {

	@Resource
	private IVersionService iVersionService;
	
	@RequestMapping(value="version.do")
	@ResponseBody
	public int findVersion(){
		return iVersionService.findVersion();
	}
}
