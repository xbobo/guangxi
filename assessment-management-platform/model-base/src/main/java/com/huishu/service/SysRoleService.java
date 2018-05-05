package com.huishu.service;

import java.util.List;

import com.huishu.bean.SysRole;

public interface SysRoleService {

	List<SysRole> findAll();
	
	void save(SysRole role);
	
	SysRole findOne(Integer id);
}
