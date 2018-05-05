package com.huishu.controller;

import org.apache.shiro.SecurityUtils;

import com.huishu.commom.AjaxResult;
import com.huishu.security.ShiroUser;

public abstract class ShiroBaseController {
//	
	public ShiroUser getCurrentShiroUser() {
		return (ShiroUser)SecurityUtils.getSubject().getPrincipal();
	}
	
	public String getCurrentUserName() {
		return getCurrentShiroUser().getLoginName();
	}
	
	public AjaxResult success(Object data) {
		return AjaxResult.success(data);
	}
	
	public AjaxResult error(String errorMsg) {
		return AjaxResult.error(errorMsg);
	}

}
