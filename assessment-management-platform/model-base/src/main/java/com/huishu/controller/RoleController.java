package com.huishu.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huishu.bean.SysRole;
import com.huishu.commom.AjaxResult;
import com.huishu.service.SysRoleService;

@Controller
@RequestMapping("role")
public class RoleController {

	private static final Logger log=LoggerFactory.getLogger(RoleController.class);
	
	@Autowired
	SysRoleService sysRoleService;

	/**
	 * 用户角色查询
	 * @Title:RoleController
	 * @Description:TODO 
	 * @return
	 */
	@RequestMapping("findAll")
	@ResponseBody
	public AjaxResult findAll(){
		try {
			List<SysRole> lists = sysRoleService.findAll();
			return AjaxResult.success(lists);
		} catch (Exception e) {
			log.error("角色查询失败", e);
			e.printStackTrace();
			return AjaxResult.error("角色查询失败");
		}
	}
	/**
	 * 角色 添加 修改
	 * @Title:RoleController
	 * @Description:TODO 
	 * @param role
	 * @return
	 */
	@RequestMapping("save")
	@ResponseBody
	public AjaxResult save(SysRole role){
		try {
			if(role.getId()==null){
				role.setDateTimeStamp(new Date().getTime());
				role.setModifiedOn(new Date());
				role.setCreatedOn(new Date());
				sysRoleService.save(role);
			}else{
				//TODO 
				SysRole findOne = sysRoleService.findOne(role.getId());
				role.setDateTimeStamp(new Date().getTime());
				role.setModifiedOn(new Date());
				role.setCreatedOn(new Date());
				sysRoleService.save(role);
			}
			return AjaxResult.success(true);
		} catch (Exception e) {
			log.error("角色查询失败", e);
			e.printStackTrace();
			return AjaxResult.error("角色查询失败");
		}
	}
}
