package com.atguigu.jdbc.whc.dao;

import com.atguigu.jdbc.whc.po.Train;

import java.util.List;
import java.util.Map;

/**培训模块*/
public interface ITrainDao {
	public List<Train> findTrain(Map<String, Object> map);/**查找培训内容*/
	
	public int updateTrain(Map<String, Object> map);/**更新培训感悟*/
}
