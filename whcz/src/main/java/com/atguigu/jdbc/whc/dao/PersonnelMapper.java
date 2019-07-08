package com.atguigu.jdbc.whc.dao;

import java.util.List;

import com.atguigu.jdbc.whc.po.NewLoginBean.NewLogin;
import com.atguigu.jdbc.whc.po.Personnel;
import org.apache.ibatis.annotations.Param;

public interface PersonnelMapper {
	
	
	public List<Personnel> findAllPer();
	
	public Personnel findByCode(@Param("usercode") String usercode);
	
	public List<Personnel> findBybm(@Param("bumen") String bumen);
	
	public List<NewLogin> findbycode(@Param("staffcode") String staffcode);
	
	public List<Personnel> findBysyb(@Param("bumen") String bumen);
	
}
