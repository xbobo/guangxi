package com.huishu.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huishu.bean.SysDic;
import com.huishu.commom.AjaxResult;
import com.huishu.service.SysDicService;

@Controller
@RequestMapping("dic")
public class DicInfoController {

	private static final Logger log = LoggerFactory
			.getLogger(DicInfoController.class);

	@Autowired
	SysDicService sysDicService;
	/**
	 * 字典表根据类型查询
	 * @Title:DicInfoController
	 * @Description:TODO 
	 * @param type
	 * @return
	 */
	@RequestMapping("findByType")
	@ResponseBody
	public AjaxResult findByType(String type) {
		try {
			List<SysDic> lists = sysDicService.findByTypeAndIsDeleted(type,
					false);
			return AjaxResult.success(lists);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("字典查询失败", e);
			return AjaxResult.error("字典查询失败");
		}
	}
}
