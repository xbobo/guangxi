package com.huishu.service;

import java.util.List;

import com.huishu.bean.SysPlatformSiteInfo;

public interface SysPlatformSiteInfoService {
	
	void save(SysPlatformSiteInfo info);
	
	SysPlatformSiteInfo findOne(Integer id);
	
	List<SysPlatformSiteInfo> findAll();
}
