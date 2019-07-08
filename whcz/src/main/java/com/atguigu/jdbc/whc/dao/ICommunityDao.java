package com.atguigu.jdbc.whc.dao;
/**社区内容接口*/

import java.util.List;

import com.atguigu.jdbc.whc.po.User;
import com.atguigu.jdbc.whc.po.community.CommunityInfo;
import com.atguigu.jdbc.whc.po.community.CommunityInfoRead;
import com.atguigu.jdbc.whc.po.community.CommunityInfoType;
import org.apache.ibatis.annotations.Param;

public interface ICommunityDao {
	
	public List<CommunityInfoType> getCommunityMsgType();/**获取社区信息类型*/
	public List<CommunityInfo> getCommunityMsg(
            @Param("user") User user,
            @Param("typeName") String typeName,
            @Param("infoTitle") String infoTitle
    );/**获取社区信息*/
	
	public Integer getReadInfo(CommunityInfoRead communityInfoRead);
	public Integer addReadInfo(CommunityInfoRead communityInfoRead);
	public List<CommunityInfoType> getUnlessMsgCount(@Param("user") User user);
	public String getAuthority(@Param("staffCode") String staffCode);
	public List<Integer> getUnlessMsgId(@Param("user") User user);//未读信息id
	public int addReadInfos(@Param("ids") List<Integer> ids, @Param("staffCode") String staffCode);//未读信息id
	
}
