package com.huishu.security;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.huishu.bean.SysResource;
import com.huishu.bean.SysRole;
import com.huishu.bean.SysUser;
import com.huishu.service.SysUserService;

public class UserRealm extends AuthorizingRealm  {

	@Autowired
	private SysUserService sysUserShiroService;
	
//	@Autowired
//	SysResourceService sysResourceService;

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		  // 1. 把AuthenticationToken转换为CustomizedToken
        CustomizedToken customizedToken = (CustomizedToken) token;
        // 2. 从CustomizedToken中获取email
        String username = customizedToken.getUsername();
        // 3. 若用户不存在，抛出UnknownAccountException异常
        SysUser user = sysUserShiroService.findByUsername(username);
        if (user == null)
            throw new UnknownAccountException("用户不存在！");
        // 4.
        // 根据用户的情况，来构建AuthenticationInfo对象并返回，通常使用的实现类为SimpleAuthenticationInfo
        // 以下信息从数据库中获取
        // （1）principal：认证的实体信息，可以是email，也可以是数据表对应的用户的实体类对象
        Object principal = user;
        // （2）credentials：密码
        Object credentials = user.getPassword();
        // （3）realmName：当前realm对象的name，调用父类的getName()方法即可
        String realmName = getName();
        // （4）盐值：取用户信息中唯一的字段来生成盐值，避免由于两个用户原始密码相同，加密后的密码也相同
         byte[] salt = Encodes.decodeHex(user.getSalt());
		 return new SimpleAuthenticationInfo(new ShiroUser(user.getId(),user.getUsername(),user.getRealname(), user.getRoles()
				), user.getPassword(), ByteSource.Util.bytes(salt), getName());
	}
	
	@PostConstruct
	public void initCredentialsMatcher() {
		HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(Encodes.HASH_ALGORITHM);
		matcher.setHashIterations(Encodes.HASH_INTERATIONS);
		// setCredentialsMatcher(new CustomCredentialsMatcher(userBaseService));
		setCredentialsMatcher(new CustomCredentialsMatcher(sysUserShiroService));
	}
	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		ShiroUser shiroUser = (ShiroUser) principals.getPrimaryPrincipal();
		SysUser user = sysUserShiroService.findByUsername(shiroUser.getLoginName());
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		Set<SysRole> roles = user.getRoles();
		Set<String> roleList=new HashSet<String>();
		//List<Integer> resourcesIds=new ArrayList<Integer>();
		if(roles!=null&&roles.size()>0){
			for(SysRole role:roles){
				 roleList.add(role.getName());
//				 Set<SysResource> resources = role.getResources();
//				 for(SysResource resource:resources){
//					 resourcesIds.add(resource.getId());
//				 }			
			}
		}
		info.addRoles(roleList);
		//设置权限
//		List<SysResource> resources = sysResourceService.findByIds(resourcesIds);
//		List<String> permissions=new ArrayList<String>();
//		if(resources!=null&&resources.size()>0){
//			for(SysResource resource:resources){
//				permissions.add(resource.getPermission());
//			}
//		}
//		info.addStringPermissions(permissions);
		return info;
	}

}
