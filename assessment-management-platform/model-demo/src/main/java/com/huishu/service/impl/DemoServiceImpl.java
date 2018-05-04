package com.huishu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huishu.bean.Demo;
import com.huishu.repository.DemoRepository;
import com.huishu.service.DemoService;

@Service
public class DemoServiceImpl implements DemoService{

	@Autowired
	DemoRepository demoRepository;
	
	@Override
	public List<Demo> findAll() {
		return demoRepository.findAll();
	}

	
}
