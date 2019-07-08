package com.atguigu.jdbc.whc.dao;

import java.util.List;

import com.atguigu.jdbc.whc.po.Announcement;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
/**公告内容的dao接口*/
@Mapper
public interface AnoucemtDao {
	List<Announcement> nowdaytitle(@Param("nowday") String nowday);
}
