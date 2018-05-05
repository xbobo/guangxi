package com.huishu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="advertisement")
public class TestController {

	@RequestMapping(value="demo")
	@ResponseBody
	public String demo(){
		return "demo";
	}
}
