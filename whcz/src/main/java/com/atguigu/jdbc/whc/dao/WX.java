package com.atguigu.jdbc.whc.dao;

import java.util.List;

import com.atguigu.jdbc.whc.po.demo.AccessProfile;
import com.atguigu.jdbc.whc.po.demo.DataDistribution;
import com.atguigu.jdbc.whc.po.demo.PageAccessTatal;
import com.atguigu.jdbc.whc.po.demo.VisitorTrending;
import org.apache.ibatis.annotations.Param;


public interface WX {
	public int add1(@Param("ref_date") String ref_date, @Param("visit_uv_new") Integer visit_uv_new, @Param("visit_uv") Integer visit_uv);
	public int add2(VisitorTrending vTrending);
	public int add3(AccessProfile aProfile);
	public int add4(
            @Param("dParams") List<DataDistribution> dParam,
            @Param("ref_date") String ref_date,
            @Param("type") String type,
            @Param("visit_uv_type") String visit_uv_type);
	public int add5(PageAccessTatal pTatal);
}
