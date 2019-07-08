package com.atguigu.jdbc.whc.service;

import com.atguigu.jdbc.whc.po.Personnel;

import java.util.List;
import java.util.Map;



public interface PerService {
	 
  
  public List<Personnel> findAllPer();
  
  public Personnel findByCode(String usercode);
  
  public Map<String, Object> findbydaydiligence(String staffcode, String date, String bumen);
}
