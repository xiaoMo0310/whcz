package com.atguigu.jdbc.whc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.atguigu.jdbc.whc.dao.ISixDiligenceDao;
import com.atguigu.jdbc.whc.dao.PersonnelMapper;
import com.atguigu.jdbc.whc.po.Personnel;
import com.atguigu.jdbc.whc.po.SixList;
import com.atguigu.jdbc.whc.service.PerService;
import org.springframework.stereotype.Service;


@Service("PerService")
public class PerServiceImpl implements PerService {

	@Resource
	private PersonnelMapper permapper;
	
	@Resource
	private ISixDiligenceDao iSixDiligenceDao;


	@Override
	public List<Personnel> findAllPer() {
		// TODO Auto-generated method stub
		return permapper.findAllPer();
	}



	@Override
	public Personnel findByCode(String usercode) {
		// TODO Auto-generated method stub
		return permapper.findByCode(usercode);
	}

	@Override
	public Map<String, Object> findbydaydiligence(String staffcode, String date,String bumen) {
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("staffCode", staffcode);
		map.put("date", date);
		map.put("bumen", bumen);
		List<String> staffCodes=iSixDiligenceDao.findStaffCode(map);
		map.put("staffCodes", staffCodes);
		List<SixList> sixLists=iSixDiligenceDao.find(map);
		System.out.println(sixLists.size());
		map.put("sixLists", sixLists);
		return map;
	}
}
