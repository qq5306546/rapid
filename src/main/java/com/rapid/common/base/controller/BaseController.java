package com.rapid.common.base.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;

/**
 * BaseController是所有控制器的基类
 * 封装了常用返回的方法
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
