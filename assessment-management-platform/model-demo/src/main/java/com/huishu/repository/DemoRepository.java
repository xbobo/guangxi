package com.huishu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.huishu.bean.Demo;

public interface DemoRepository extends JpaRepository<Demo, Long>{

}
