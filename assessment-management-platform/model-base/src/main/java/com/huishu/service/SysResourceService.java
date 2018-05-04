package com.huishu.service;

import java.util.List;

import com.huishu.bean.SysResource;
import com.huishu.bean.SysRole;

public interface SysResourceService {

	public List<SysResource> findByIds(List<Integer> ids);
	
	public SysResource findById(Integer id);
	
	void save(SysResource resource);
}
