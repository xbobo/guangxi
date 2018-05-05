package com.huishu.conf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.Filter;

import org.apache.shiro.authc.pam.AtLeastOneSuccessfulStrategy;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.huishu.security.AdminRealm;
import com.huishu.security.CustomizedModularRealmAuthenticator;
import com.huishu.security.MyFormAuthenticationFilter;
import com.huishu.security.UserRealm;

/**
 * 
 * @Package: com.huishu.conf 
 * @author: xiaobo   
 * @date: 2018年4月25日 下午5:27:11 
 *
 */
//@Configuration
public class ShiroConfiguration {
	
	private final static Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
	private final static Map<String, Filter> filters = new LinkedHashMap<String, Filter>();
	
	@Bean(name = "adminRealm")
	public AdminRealm getAdminRealm() {
		return new AdminRealm();
	}
	
	@Bean(name = "userRealm")
	public UserRealm getUserRealm() {
		return new UserRealm();
	}

	@Bean(name = "lifecycleBeanPostProcessor")
	public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}

	@Bean(name = "securityManager")
	public DefaultWebSecurityManager getDefaultWebSecurityManager() {
		DefaultWebSecurityManager dwsm = new DefaultWebSecurityManager();
		Collection<Realm> realms=new ArrayList<Realm>();
		realms.add(getAdminRealm());
		realms.add(getUserRealm());
		dwsm.setRealms(realms);
		return dwsm;
	}
	
	@Bean(name="customizedModularRealmAuthenticator")
	public CustomizedModularRealmAuthenticator getCustomizedModularRealmAuthenticator(){
		CustomizedModularRealmAuthenticator authenticator=new CustomizedModularRealmAuthenticator();
		authenticator.setAuthenticationStrategy(new AtLeastOneSuccessfulStrategy());
		return authenticator;
	}
	
	/**
	 * 注解拦截权限管理
	 * @Title:ShiroConfiguration
	 * @Description:TODO 
	 * @param defaultWebSecurityManager
	 * @return
	 */
	@Bean(name = "authorizationAttributeSourceAdvisor")
	public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor(DefaultWebSecurityManager defaultWebSecurityManager){
		AuthorizationAttributeSourceAdvisor source =new AuthorizationAttributeSourceAdvisor();
		source.setSecurityManager(defaultWebSecurityManager);
		return source;
	}

	@Bean(name = "shiroFilter")
	public ShiroFilterFactoryBean getShiroFilterFactoryBean() {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		
		filterChainDefinitionMap.put("/logout", "logout");
		filterChainDefinitionMap.put("/login", "authc");
		filterChainDefinitionMap.put("/user/login", "anon");
		filterChainDefinitionMap.put("/admin/login", "anon");
		filterChainDefinitionMap.put("/img/**", "anon");
		filterChainDefinitionMap.put("/lib/**", "anon");
		filterChainDefinitionMap.put("/css/**", "anon");
		filterChainDefinitionMap.put("/js/**", "anon");
		//filterChainDefinitionMap.put("/**", "user");
		filterChainDefinitionMap.put("/**", "anon");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		
		filters.put("authc", getMyFormAuthenticationFilter());
		shiroFilterFactoryBean.setFilters(filters);
		
		shiroFilterFactoryBean.setSecurityManager(getDefaultWebSecurityManager());
		shiroFilterFactoryBean.setUnauthorizedUrl("/login");
		shiroFilterFactoryBean.setLoginUrl("/login");
		shiroFilterFactoryBean.setSuccessUrl("/home/index");
		return shiroFilterFactoryBean;
	}
	
	@Bean(name = "loginFormAuthenticationFilter")
	public MyFormAuthenticationFilter getMyFormAuthenticationFilter() {
		return new MyFormAuthenticationFilter();
	}

}
