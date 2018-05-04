package com.huishu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huishu.bean.SysResource;
import com.huishu.repository.SysResourceRepository;
import com.huishu.service.SysResourceService;

@Service
public class SysResourceServiceImpl implements SysResourceService{

	@Autowired
	private SysResourceRepository sysResourceRepository;
	
	@Override
	public List<SysResource> findByIds(List<Integer> ids) {
		return sysResourceRepository.findAll(ids);
	}

	@Override
	public SysResource findById(Integer id) {
		return sysResourceRepository.findOne(id);
	}

	@Override
	public void save(SysResource resource) {
		sysResourceRepository.save(resource);
	}
}
