package com.huishu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.huishu.bean.SysUser;

public interface  SysUserRepository extends JpaRepository<SysUser, Integer>{
	
	List<SysUser> findByUsername(String username);
}
