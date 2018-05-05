package com.huishu.controller;

import java.security.interfaces.RSAPrivateKey;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huishu.bean.SysUser;
import com.huishu.commom.AjaxResult;
import com.huishu.commom.UtilHelper;
import com.huishu.security.Digests;
import com.huishu.security.Encodes;
import com.huishu.service.SysUserService;
import com.huishu.util.RSAUtils;

@Controller
@RequestMapping("user")
public class UserController {

	private static final Logger log=LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	SysUserService sysUserService;
	/**
	 * 
	 * 用户信息保存
	 * @Title:UserController
	 * @Description:TODO 
	 * @param user
	 * @return
	 */
	@RequestMapping("save")
	@ResponseBody
	public AjaxResult save(SysUser user){
		try {
			//TODO
			if(user.getId()==null){
				sysUserService.save(user);
			}else{
				SysUser findOne = sysUserService.findOne(user.getId());
				sysUserService.save(findOne);
			}
			return AjaxResult.success(true);
		} catch (Exception e) {
			log.error("用户信息保存失败", e);
			e.printStackTrace();
			return AjaxResult.error("用户信息保存失败");
		}
	}
	/**
	 * 用户权限添加
	 * @Title:UserController
	 * @Description:TODO 
	 * @param user
	 * @return
	 */
	@RequestMapping("resetPassword")
	@ResponseBody
	public AjaxResult resetPassword(SysUser user){
		try{
			SysUser findOne = sysUserService.findOne(user.getId());
			if(findOne==null){
				return AjaxResult.error("用于密码找回的用户账号不正确");
			}
			String password=user.getPassword();
			Object priKey = SecurityUtils.getSubject().getSession().getAttribute("privateKey");
			password = RSAUtils.decryptByPrivateKey(password,(RSAPrivateKey)priKey);
			password = new StringBuilder(password).reverse().toString();
			if(!StringUtils.isEmpty(password)){
				if(!UtilHelper.checkPassword(password)){
					return AjaxResult.error("密码应以字母开头，长度在6~18之间，只能包含字符、数字或下划线");
				}
			}else{
				return AjaxResult.error("新密码不能为空");
			}
			//获取当前用户的私钥
			
			byte[] salt=Encodes.decodeHex(user.getSalt());
			byte[] hashPassword = Digests.sha1(password.getBytes(),salt,Encodes.HASH_INTERATIONS);
			String passwordEncode=Encodes.encodeHex(hashPassword);
			
			findOne.setPassword(passwordEncode);
			sysUserService.save(findOne);
			
			return AjaxResult.success("密码更新成功");
		}catch(Exception e){
			return AjaxResult.error("密码更新失败");
		}
	}
}
