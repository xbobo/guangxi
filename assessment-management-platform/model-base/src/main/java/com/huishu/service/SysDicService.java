package com.huishu.service;

import java.util.List;

import com.huishu.bean.SysDic;

public interface SysDicService {
	
	void save(SysDic dic);
	
	SysDic findOne(Integer id);
	
	List<SysDic> findAll();
	
	List<SysDic> findByTypeAndIsDeleted(String type,boolean isDeleted);
}
