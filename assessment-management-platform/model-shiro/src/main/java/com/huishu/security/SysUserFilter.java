package com.huishu.security;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.springframework.beans.factory.annotation.Autowired;

import com.huishu.service.SysUserService;

public class SysUserFilter extends PathMatchingFilter {

    @Autowired
    private SysUserService userService;

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {

    	ShiroUser shiroUser = (ShiroUser)SecurityUtils.getSubject().getPrincipal();
        request.setAttribute("user", userService.findByUsername(shiroUser.getLoginName()));
        return true;
    }
}
