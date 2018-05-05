package com.huishu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huishu.bean.SysCarInfo;
import com.huishu.repository.SysCarInfoRepository;
import com.huishu.service.SysCarInfoService;

@Service
public class SysCarInfoServiceImpl implements SysCarInfoService{

	@Autowired
	SysCarInfoRepository sysCarInfoRepository;

	@Override
	public void save(SysCarInfo info) {
		sysCarInfoRepository.save(info);
	}

	@Override
	public SysCarInfo findOne(Integer id) {
		return sysCarInfoRepository.findOne(id);
	}

	@Override
	public List<SysCarInfo> findAll() {
		return sysCarInfoRepository.findAll();
	}
}
