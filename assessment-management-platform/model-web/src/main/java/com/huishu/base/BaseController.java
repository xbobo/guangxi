package com.huishu.base;

import org.apache.shiro.SecurityUtils;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.beans.factory.annotation.Autowired;

import com.huishu.security.ShiroUser;
import com.huishu.util.Constants;

public abstract class BaseController {
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
