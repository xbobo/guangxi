package com.huishu.security;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import com.huishu.bean.SysRole;

public class ShiroUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3463156268677281735L;
	
	private Integer id;

	private String loginName;
	
	private String realName;
	
	private String curRole;
	
	private Set<SysRole> roles;

	public ShiroUser(Integer id,String loginName, String realName, Set<SysRole> roles) {
		this.loginName = loginName;
		this.realName = realName;
		this.roles = roles;
		this.id=id;
	}
	
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Set<SysRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<SysRole> roles) {
		this.roles = roles;
	}

	/**
	 * 本函数输出将作为默认的<shiro:principal/>输出.
	 */
	@Override
	public String toString() {
		return loginName;
	}

	/**
	 * 重载hashCode,只计算loginName;
	 */
	@Override
	public int hashCode() {
		return Objects.hash(loginName);
	}

	/**
	 * 重载equals,只计算loginName;
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		ShiroUser other = (ShiroUser) obj;
		if (loginName == null) {
			if (other.loginName != null) {
				return false;
			}
		} else if (!loginName.equals(other.loginName)) {
			return false;
		}
		return true;
	}

	public String getCurRole() {
		return curRole;
	}

	public void setCurRole(String curRole) {
		this.curRole = curRole;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
