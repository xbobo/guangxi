package com.huishu.service.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huishu.bean.SysUser;
import com.huishu.repository.SysUserRepository;
import com.huishu.service.SysUserService;

@Service
public class SysUserServiceImpl implements SysUserService{

	@Autowired
	SysUserRepository sysUserRepository;
	
	@Autowired
	EntityManager em;
	
	@Override
	public SysUser findByUsername(String username) {
		List<SysUser> result = sysUserRepository.findByUsername(username);
		if(result!=null&&result.size()>0){
			return result.get(0);
		}
		return null;
	}

	@Override
	public void save(SysUser user) {
		sysUserRepository.save(user);
	}

	@Override
	public SysUser findOne(Integer id) {
		return sysUserRepository.findOne(id);
	}

}
