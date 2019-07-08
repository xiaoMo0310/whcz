package com.atguigu.jdbc.whc.dao;

import com.atguigu.jdbc.whc.po.feedback.FeedBackInfo;
import org.apache.ibatis.annotations.Param;


public interface FeedBackDao {
	
	
	int insertFeedBack(FeedBackInfo fbIf);
	
	
	void insertFeedBackImg(@Param(value = "foreign") Integer foreign, @Param(value = "path") String trueFileName);

}
