package com.huishu;

import java.util.HashSet;
import java.util.List;

import org.elasticsearch.client.transport.TransportClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.huishu.bean.SysRole;
import com.huishu.bean.SysUser;
import com.huishu.service.DemoService;
import com.huishu.service.SysResourceService;
import com.huishu.service.SysRoleService;
import com.huishu.service.SysUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class ServiceTest {
	
	@Autowired
    private TransportClient transportClient;
	
	@Autowired
	SysUserService sysUserService;
	
	@Autowired
	SysRoleService sysRoleService;
	
	@Autowired
	SysResourceService sysResourceService;
	
	@Autowired
	DemoService demoService;
	
/*	@Test
	public void demoTest(){
		List<Demo> findAll = demoService.findAll();
		System.out.println(findAll.size());
	}*/
	
	@Test
	@Rollback(false)
	public void oneFirstTest(){
		
 
		/*SysUser user=new SysUser();
		user.setUsername("xb2");
		sysUserService.save(user);
		
		SysRole role=new SysRole();
		role.setName("user");
		sysRoleService.save(role);
		
		SysRole role2=new SysRole();
		role2.setName("admin");
		sysRoleService.save(role2);*/
		
		SysUser findByUsername = sysUserService.findByUsername("xb1");
		List<SysRole> findAll = sysRoleService.findAll();
		findByUsername.setRoles(null);
		sysUserService.save(findByUsername);
		
		/*SysRole role2=new SysRole();
		role2.setName("test");
		SysUser findByUsername = sysUserService.findByUsername("xb1");
		HashSet<SysUser> hashSet = new HashSet<SysUser>();
		hashSet.add(findByUsername);
		role2.setUsers(hashSet);
		sysRoleService.save(role2);*/
		
		 //sysRoleService.delete(2);
		
		 
		
		/*SysUser user=new SysUser();
		user.setUsername("xb4");
		List<SysRole> findAll = sysRoleService.findAll();
		HashSet<SysRole> hashSet = new HashSet<SysRole>(findAll);
		user.setRoles(hashSet);
		sysUserService.save(user);*/
		/*SysRole role=new SysRole();
		role.setName("test");
		HashSet<SysResource> hashSet = new HashSet<SysResource>();
		hashSet.add(sysResourceService.findById(1));
		role.setResources(hashSet);
		sysRoleService.save(role);*/
		/*SysUser findByUsername = sysUserService.findByUsername("lisi");
		Set<SysRole> roles = findByUsername.getRoles();
		for(SysRole role:roles){
			System.out.println(role.getName());
		}
		System.out.println(findByUsername.getRoles().size());
		List<SysRole> findAll = sysRoleService.findAll();
		for(SysRole role:findAll){
			Set<SysResource> resources = role.getResources();
			for(SysResource resource:resources){
				System.out.println(resource.getName());
			}
		}
		System.out.println(findAll.size());
		SysResource findById = sysResourceService.findById(1);
		Set<SysRole> roles2 = findById.getRoles();
		for(SysRole role:roles2){
			System.out.println(role.getName());
		}
		
		SearchRequestBuilder searchRequestBuilder = transportClient.prepareSearch("test_alias").setTypes("doc");
		 
		SearchResponse actionGet = searchRequestBuilder.execute().actionGet();
		System.out.println(actionGet.getHits().getTotalHits());*/
	}
 
}
