package com.huishu;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.huishu.security.CustomizedToken;

/**
 * 
 * @Package: com.huishu.controller
 * @author: xiaobo
 * @date: 2018年4月26日 下午4:03:34
 *
 */
@Controller
@RequestMapping("/users")
public class UserController {

	private static final Logger log = LoggerFactory
			.getLogger(HomeDemoController.class);

	// @RequiresPermissions("user:create")
	@RequestMapping("/create")
	public String index(Model model) {
		/*
		 * Subject subject = SecurityUtils.getSubject(); ShiroUser shiroUser =
		 * (ShiroUser)subject.getPrincipal(); //add by jizhun at
		 * 重新修改权限后清楚缓存，调用doGetAuthorizationInfo重新取角色的权限信息
		 * DefaultWebSecurityManager securityManager =
		 * (DefaultWebSecurityManager) SecurityUtils.getSecurityManager();
		 * ShiroDbRealm shiroRealm =
		 * (ShiroDbRealm)securityManager.getRealms().iterator().next();
		 * //清楚所有用户权限 // shiroRealm.clearAllCachedAuthorizationInfo2();
		 * //第一个参数为用户名,第二个参数为realmName,test想要操作权限的用户
		 * shiroUser.setCurRole("user"); SimplePrincipalCollection principals =
		 * new SimplePrincipalCollection(shiroUser,shiroUser.getRealName());
		 * 
		 * subject.runAs(principals); // subject.releaseRunAs();
		 */return "index";
	}

	/**
	 * 普通用户登录入口
	 * @Title:UserController
	 * @Description:TODO 
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(@RequestParam("username") String username,
			@RequestParam("password") String password) {
		Subject currentUser = SecurityUtils.getSubject();
		if (!currentUser.isAuthenticated()) {
			CustomizedToken customizedToken = new CustomizedToken(username,
					password, "user");
			customizedToken.setRememberMe(false);
			try {
				currentUser.login(customizedToken);
				return "user";
			} catch (IncorrectCredentialsException ice) {
				System.out.println("邮箱/密码不匹配！");
			} catch (LockedAccountException lae) {
				System.out.println("账户已被冻结！");
			} catch (AuthenticationException ae) {
				System.out.println(ae.getMessage());
			}
		}
		return "redirect:/home/index";
	}
}
