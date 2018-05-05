package com.huishu;

import io.swagger.annotations.ApiOperation;

import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.client.transport.TransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/home")
public class HomeDemoController {
	
	private static final Logger log = LoggerFactory.getLogger(HomeDemoController.class);
	
    @RequestMapping("/index")
    public String index(Model model) {
        return "2";
    }
	
	@RequiresPermissions("user:create")
	@RequestMapping(value = "/test.do")
	public String test(Map<String, Object> model,
			Integer pageNo) {
		try {
			return "index";
		} catch (Exception e) {
			e.printStackTrace();
			log.error("管理员---舆情数据研判-查看出错", e);
			return "/";
		}
	}
	@ApiOperation(value = "测试", notes = "测试", httpMethod = "GET")
	@RequestMapping(value = "/first.do")
	public String first(Map<String, Object> model,
			Integer pageNo) {
		try {
			return "test";
		} catch (Exception e) {
			e.printStackTrace();
			log.error("管理员---舆情数据研判-查看出错", e);
			return "/";
		}
	}
	
	public static void main(String[] args) {
		/*byte[] salt=Encodes.decodeHex("6722c37f2bfb72b5");
		String password="a123456";
		byte[] hashPassword = Digests.sha1(password.getBytes(),salt,Encodes.HASH_INTERATIONS);
		String passwordEncode=Encodes.encodeHex(hashPassword);
		System.out.println(passwordEncode);*/
		 
	}
}