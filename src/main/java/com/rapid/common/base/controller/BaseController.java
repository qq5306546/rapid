package com.rapid.common.base.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;

/**
 * BaseController是所有控制器的基类,封装了常用返回的方法<br/>
 * 当返回JSON格式对象时,直接返回Object对象即可<br/>
 * 例:	@ResponseBody public Object json() { return obj; }<br/>
 * 返回的obj对象可以是List,Map,或一个实体
 * 
 * @author wubei
 *
 */
public class BaseController {
	
	protected final Logger logger = Logger.getLogger(getClass());
	
	protected ModelAndView render(String viewName) {
		return new ModelAndView(viewName);
	}
	
	protected ModelAndView render(String viewName, Object attributeValue) {
		return new ModelAndView(viewName).addObject(attributeValue);
	}
	
	protected ModelAndView render(String viewName, String attributeName, Object attributeValue) {
		return new ModelAndView(viewName).addObject(attributeName, attributeValue);
	}
	
	protected ModelAndView render(String viewName, Map<String, Object> attributeMap) {
		ModelAndView view = new ModelAndView(viewName);
		for (String key : attributeMap.keySet()) {
			view.addObject(key, attributeMap.get(key));
		}
		return view;
	}
}
