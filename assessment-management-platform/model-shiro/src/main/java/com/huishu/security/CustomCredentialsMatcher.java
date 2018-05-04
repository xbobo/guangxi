package com.huishu.security;

import java.security.interfaces.RSAPrivateKey;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.huishu.bean.SysUser;
import com.huishu.service.SysUserService;
import com.huishu.util.RSAUtils;

/**
 * 自定义密码验证类
 * 
 */
public class CustomCredentialsMatcher extends SimpleCredentialsMatcher {

	@Autowired
	SysUserService sysUserService;
 
	public CustomCredentialsMatcher(SysUserService sysUserService) {
		this.sysUserService = sysUserService;
	}

	@Override
	public boolean doCredentialsMatch(AuthenticationToken authcToken, AuthenticationInfo info) {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		Object tokenCredentials = getUserPassword(token);
		Object accountCredentials = getCredentials(info);
		// 将密码加密与系统加密后的密码校验，内容一致就返回true,不一致就返回false
		boolean equals = equals(tokenCredentials, accountCredentials);
		//return true;
		return equals;
	}

	private String getUserPassword(UsernamePasswordToken token) {
		String pass = String.valueOf(token.getPassword());
		Subject currentUser = SecurityUtils.getSubject();
		String descrypedPwd = null;
		try {
			// 获取当前用户的私钥
			Object priKey = currentUser.getSession().getAttribute("privateKey");
			descrypedPwd = RSAUtils.decryptByPrivateKey(pass, (RSAPrivateKey) priKey);
			descrypedPwd = new StringBuilder(descrypedPwd).reverse().toString();
			System.out.println(descrypedPwd);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		SysUser user = sysUserService.findByUsername(token.getUsername());
		if(user!=null){
			byte[] salt = Encodes.decodeHex(user.getSalt());
			byte[] hashPassword = Digests.sha1(descrypedPwd.getBytes(), salt, Encodes.HASH_INTERATIONS);
			return Encodes.encodeHex(hashPassword);
		}
		return descrypedPwd;
	}
}
