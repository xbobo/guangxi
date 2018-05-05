package com.huishu.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huishu.bean.SysCarInfo;
import com.huishu.commom.AjaxResult;
import com.huishu.service.SysCarInfoService;

@Controller
@RequestMapping("carInfo")
public class CarInfoController {
	private static final Logger log = LoggerFactory
			.getLogger(CarInfoController.class);
	
	@Autowired
	SysCarInfoService sysCarInfoService;
	
	/**
	 * 查询所有车型信息
	 * @Title:CarInfoController
	 * @Description:TODO 
	 * @return
	 */
	@RequestMapping("findAll")
	@ResponseBody
	public AjaxResult findAll() {
		try {
			List<SysCarInfo> lists = sysCarInfoService.findAll();
			return AjaxResult.success(lists);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("车型查询失败", e);
			return AjaxResult.error("车型查询失败");
		}
	}
}
