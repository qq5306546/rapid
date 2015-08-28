package com.rapid.module.party.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.rapid.common.base.controller.BaseController;
import com.rapid.common.plugin.config.Config;
import com.rapid.common.plugin.config.SystemGlobal;

@Controller
@RequestMapping("/party")
public class IndexController extends BaseController {
	
	@Autowired
	private SystemGlobal systemGlobal;
	
	@RequestMapping("/index")
	@ResponseBody
	public String index() {
		return "hello 你好" + systemGlobal.getProperty(Config.CONFIG_FILE_UPLOAD);
	}

	@RequestMapping("/test")
	@ResponseBody
	public Object test() {
		JSONObject json = new JSONObject();
		json.put("11", "22222");
        
		return json;
	}
	
}
