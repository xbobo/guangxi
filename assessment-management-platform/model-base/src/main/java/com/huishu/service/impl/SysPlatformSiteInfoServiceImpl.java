package com.huishu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huishu.bean.SysPlatformSiteInfo;
import com.huishu.repository.SysPlatformSiteInfoRepository;
import com.huishu.service.SysPlatformSiteInfoService;

@Service
public class SysPlatformSiteInfoServiceImpl implements SysPlatformSiteInfoService{

	@Autowired
	SysPlatformSiteInfoRepository sysPlatformSiteInfoRepository;

	@Override
	public void save(SysPlatformSiteInfo info) {
		sysPlatformSiteInfoRepository.save(info);
	}

	@Override
	public SysPlatformSiteInfo findOne(Integer id) {
		return sysPlatformSiteInfoRepository.findOne(id);
	}

	@Override
	public List<SysPlatformSiteInfo> findAll() {
		return sysPlatformSiteInfoRepository.findAll();
	}

	 
}
