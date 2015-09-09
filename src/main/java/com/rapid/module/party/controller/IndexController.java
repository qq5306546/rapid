package com.rapid.module.party.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.rapid.core.base.controller.BaseController;

@Controller
@RequestMapping("/party")
public class IndexController extends BaseController {
	
	
	@RequestMapping("/index")
	public ModelAndView index() {
		Map<String, Object> test = new HashMap<String, Object>();
		test.put("aa", "aa");
		test.put("bb", "bb");
		
		List<String> list = new ArrayList<String>();
		list.add("aa");
		list.add("bb");
		
 		return render("party/index", "test", test);
	}

	@RequestMapping("/test")
	@ResponseBody
	public Object test() {
		return renderJsonSucc();
	}
	
	@RequestMapping("/redirect")
	public ModelAndView redirectTest() {
		return redirect("http://www.baidu.com", "1111", "222");
	}
}
