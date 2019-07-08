package com.atguigu.jdbc.whc.service;

import com.atguigu.jdbc.whc.po.Train;

import java.util.List;
import java.util.Map;



public interface ITrianService {
	public List<Train> findTrain(Map<String, Object> map);
	public int updateTrain(Map<String, Object> map);
}
