package com.atguigu.jdbc.whc.service.impl;

import java.util.List;
import java.util.Map;

import com.atguigu.jdbc.whc.dao.IStutasDao;
import com.atguigu.jdbc.whc.po.NewLoginBean.ListAllFeeling;
import com.atguigu.jdbc.whc.service.IStutasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("IStutasService")
public class StutasServiceImpl implements IStutasService {
	
	@Autowired
	private IStutasDao stutaDao;
	/**将点赞超赞收藏信息添加到数据库*/
	@Override
	public int addStutas(ListAllFeeling listAllFeeling) {

		List<Integer> listEnshrine=stutaDao.selectEnshrine(listAllFeeling);
		List<Integer> listFabulous=stutaDao.selectFabulous(listAllFeeling);
		List<Integer> listPraise=stutaDao.selectPraise(listAllFeeling);
		Integer id=listAllFeeling.getId();
		if (listAllFeeling.getPraise()==null) {
			listAllFeeling.setPraise("0");
		}
		if (listAllFeeling.getEnshrine()==null) {
			listAllFeeling.setEnshrine("0");
		}
		if (listAllFeeling.getFabulous()==null) {
			listAllFeeling.setFabulous("0");
		}
		
		
		if (listAllFeeling.getPraise().equals("1")) {
			if (!listPraise.contains(listAllFeeling.getId())) {
				stutaDao.addPraise(listAllFeeling);
				
				//像新表中插入数据
				stutaDao.insertLike(listAllFeeling);
				System.out.println("++++++++++++++++++++++");
				System.out.println(listAllFeeling.getId());
				stutaDao.insertLikeAccept(listAllFeeling);
				System.out.println("++++++++++++++++++++++");
			}
		}else {
			stutaDao.deletePraise(listAllFeeling);
		}
		if (listAllFeeling.getFabulous().equals("1")) {
			if (!listFabulous.contains(listAllFeeling.getId())) {
				listAllFeeling.setId(id);
				stutaDao.addFabulous(listAllFeeling);
				stutaDao.insertFabulousInfo(listAllFeeling);
				stutaDao.insertFabulousInfoAccpet(listAllFeeling);
			}
		}else {
			stutaDao.deleteFabulous(listAllFeeling);
		}
		if (listAllFeeling.getEnshrine().equals("1")) {
			if (!listEnshrine.contains(listAllFeeling.getId())) {//判断list集合中是否存在某个值
				listAllFeeling.setId(id);
				stutaDao.addEnshrine(listAllFeeling);
				stutaDao.insertEnshrineInfo(listAllFeeling);
				stutaDao.insertEnshrineInfoAccpet(listAllFeeling);
			}
		}else{
			stutaDao.deleteEnshrine(listAllFeeling);
		}
		return 1;
	}
	/**查询全部收藏信息*/
	@Override
	public List<ListAllFeeling> selectEnshrines(String staffCode) {
		// TODO Auto-generated method stub
		return stutaDao.selectEnshrines(staffCode);
	}
	/**根据id删除收藏信息*/
	@Override
	public int deleteEnshrineById(Map<String, Object> map) {
		
		return stutaDao.deleteEnshrineById(map);
	}
	/**查询当天个人超赞数量*/
	@Override
	public Integer selectFabulousNum(Map<String, Object> map) {
		
		return stutaDao.selectFabulousNum(map);
	}

}
