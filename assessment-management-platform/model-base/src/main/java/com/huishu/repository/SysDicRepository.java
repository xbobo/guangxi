package com.huishu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.huishu.bean.SysDic;

public interface  SysDicRepository extends JpaRepository<SysDic, Integer>{

	List<SysDic> findByTypeAndIsDeleted(String type,boolean isDeleted);
}
