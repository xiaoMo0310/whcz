package com.atguigu.jdbc.whc.service;


import com.atguigu.jdbc.whc.po.Announcement;

import java.util.List;

public interface AnoucemtService {
	
	List<Announcement> nowdaytitle(String nowday);
}
