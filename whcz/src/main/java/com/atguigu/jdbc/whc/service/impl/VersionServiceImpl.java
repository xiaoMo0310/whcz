package com.atguigu.jdbc.whc.service.impl;

import javax.annotation.Resource;

import com.atguigu.jdbc.whc.dao.IVersionDao;
import com.atguigu.jdbc.whc.service.IVersionService;
import org.springframework.stereotype.Service;

@Service("VersionServiceImpl")
public class VersionServiceImpl implements IVersionService {

	@Resource
	private IVersionDao versionDao;
	@Override
	public int findVersion() {
		return versionDao.findVersion();
	}

}
