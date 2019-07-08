package com.atguigu.jdbc.whc.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.atguigu.jdbc.whc.dao.ITrainDao;
import com.atguigu.jdbc.whc.po.Train;
import com.atguigu.jdbc.whc.service.ITrianService;
import org.springframework.stereotype.Service;

@Service
public class TrainServiceImpl implements ITrianService {
	
	@Resource
	private ITrainDao trainDao;
	/**查询培训内容*/
	@Override
	public List<Train> findTrain(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return trainDao.findTrain(map);
	}
	/**更新培训心得*/
	@Override
	public int updateTrain(Map<String, Object> map) {
		
		return trainDao.updateTrain(map);
	}

}
