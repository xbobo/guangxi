package com.huishu.service;

import java.util.List;

import com.huishu.bean.SysCarInfo;

public interface SysCarInfoService {
	
	void save(SysCarInfo info);
	
	SysCarInfo findOne(Integer id);
	
	List<SysCarInfo> findAll();
}
