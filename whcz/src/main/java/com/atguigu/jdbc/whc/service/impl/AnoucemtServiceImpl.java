package com.atguigu.jdbc.whc.service.impl;

import javax.annotation.Resource;

import com.atguigu.jdbc.whc.dao.AnoucemtDao;
import com.atguigu.jdbc.whc.po.Announcement;
import com.atguigu.jdbc.whc.service.AnoucemtService;
import org.springframework.stereotype.Service;

import java.util.List;

/**公告内容的实现类*/
@Service("AnoucemtService")
public class AnoucemtServiceImpl implements AnoucemtService {

	@Resource
	private AnoucemtDao actd;
	@Override
	public List<Announcement> nowdaytitle(String nowday) {
		// TODO Auto-generated method stub
		return actd.nowdaytitle(nowday);
	}

}
