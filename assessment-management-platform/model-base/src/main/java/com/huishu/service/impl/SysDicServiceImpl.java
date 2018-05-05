package com.huishu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huishu.bean.SysDic;
import com.huishu.bean.SysUser;
import com.huishu.repository.SysDicRepository;
import com.huishu.service.SysDicService;

@Service
public class SysDicServiceImpl implements SysDicService{

	@Autowired
	SysDicRepository sysDicRepository;

	@Override
	public void save(SysDic dic) {
		sysDicRepository.save(dic);
	}

	@Override
	public SysDic findOne(Integer id) {
		return sysDicRepository.findOne(id);
	}

	@Override
	public List<SysDic> findAll() {
		return sysDicRepository.findAll();
	}

	@Override
	public List<SysDic> findByTypeAndIsDeleted(String type, boolean isDeleted) {
		return sysDicRepository.findByTypeAndIsDeleted(type, isDeleted);
	}
}
