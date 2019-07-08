package com.atguigu.jdbc.whc.service;

import com.atguigu.jdbc.whc.po.Community;
import com.atguigu.jdbc.whc.po.feedback.FeedBackInfo;

import java.util.List;


public interface CommunityService {
	
	List<String> getCommunityDep();
	
	
	void insertCommunits(Community community);
	
	
	/**
	 * 插入圖片 
	 * @param infoId
	 * @param infoImg
	 */
	void insertInfoImage(Integer infoId, String trueFileName);
	
	
	List<String>getTypeName(String staffCode);
	
	
	/**
	 * 根据人员编码查询
	 * @param staffCode
	 * @return
	 */
	List<String> getDepID(String staffCode);
	
	
	
	public void  getOnid(String department);
	
	
	/**
	 * 插入意见反馈
	 * @return
	 */
	Integer insertFeedBack(FeedBackInfo fbIf);
	
	
	void insertFeedBackImg(Integer foreign, String trueFileName);
	


}





