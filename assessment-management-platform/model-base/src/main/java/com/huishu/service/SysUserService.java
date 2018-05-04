package com.huishu.service;

import com.huishu.bean.SysUser;

public interface SysUserService {
	
	SysUser findByUsername(String username);
	
	void save(SysUser user);
}
