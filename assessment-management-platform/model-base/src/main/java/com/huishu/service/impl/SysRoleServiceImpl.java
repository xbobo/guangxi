package com.huishu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huishu.bean.SysRole;
import com.huishu.repository.SysRoleRepository;
import com.huishu.service.SysRoleService;

@Service
public class SysRoleServiceImpl implements SysRoleService {

	@Autowired
	private SysRoleRepository sysRoleRepository;
	
	@Override
	public List<SysRole> findAll() {
		return sysRoleRepository.findAll();
	}

	@Override
	public void save(SysRole role) {
		sysRoleRepository.save(role);
	}

	@Override
	public void delete(Integer id) {
		sysRoleRepository.delete(id);
	}

}
