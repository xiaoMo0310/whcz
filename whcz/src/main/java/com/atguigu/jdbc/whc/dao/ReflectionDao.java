package com.atguigu.jdbc.whc.dao;

import java.util.List;

import com.atguigu.jdbc.whc.po.Reflection;
import org.apache.ibatis.annotations.Param;

public interface ReflectionDao {
	List<Reflection> findbydayrc(@Param("staffcode") String staffcode, @Param("date") String date);
}
