package com.huishu.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huishu.bean.SysPlatformSiteInfo;
import com.huishu.commom.AjaxResult;
import com.huishu.service.SysPlatformSiteInfoService;

@Controller
@RequestMapping("platformSiteInfo")
public class PlatformSiteInfoController {

	private static final Logger log=LoggerFactory.getLogger(PlatformSiteInfoController.class);
	
	@Autowired
	SysPlatformSiteInfoService sysPlatformSiteInfoService;
	
	@RequestMapping("findAll")
	@ResponseBody
	public AjaxResult findAll(){
		try {
			List<SysPlatformSiteInfo> lists = sysPlatformSiteInfoService.findAll();
			return AjaxResult.success(lists);
		} catch (Exception e) {
			log.error("系统平台站点信息查询失败", e);
			e.printStackTrace();
			return AjaxResult.error("系统平台站点信息查询失败");
		}
	}
}
