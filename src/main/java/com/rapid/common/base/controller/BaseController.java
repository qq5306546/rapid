package com.rapid.common.base.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

/**
 * BaseController是所有控制器的基类,封装了常用返回的方法
 * @author wubei
 *
 */
public class BaseController {
	
	private static final String KEY_SUCCESS = "succ";   // 返回json对象结果的key
	private static final String KEY_MESSAGE = "msg";    // 返回json对象消息的key
	private static final String KEY_DATA = "data";      // 返回json对象的key
	protected final Logger logger = Logger.getLogger(getClass());
	private final JSONObject json = new JSONObject();
	
	/**
	 * 返回一个ModelAndView
	 * @return
	 * 		spring ModelAndView
	 */
	protected ModelAndView render() {
		return new ModelAndView();
	}
	
	/**
	 * 返回指定的视图
	 * @param 
	 * 		viewPath 视图路径
	 * @return
	 * 		spring ModelAndView
	 */
	protected ModelAndView render(String viewPath) {
		return new ModelAndView(viewPath);
	}
	
	/**
	 * 返回指定的视图
	 * @param 
	 * 		viewPath 视图路径
	 * @param 
	 * 		attributeValue 返回的对象
	 * @return
	 * 		spring ModelAndView
	 */
	protected ModelAndView render(String viewPath, Object attributeValue) {
		return render(viewPath).addObject(attributeValue);
	}
	
	/**
	 * 返回指定的视图
	 * @param 
	 * 		viewPath 视图路径
	 * @param 
	 * 		attributeName 返回对象的键
	 * @param 
	 * 		attributeValue 返回的对象
	 * @return
	 * 		spring ModelAndView
	 */
	protected ModelAndView render(String viewPath, String attributeName, Object attributeValue) {
		return render(viewPath).addObject(attributeName, attributeValue);
	}
	
	/**
	 * 返回指定的视图
	 * @param 
	 * 		viewPath 视图路径
	 * @param 
	 * 		attributeMap 返回Map对象
	 * @return
	 * 		spring ModelAndView
	 */
	protected ModelAndView render(String viewPath, Map<String, Object> attributeMap) {
		ModelAndView view = new ModelAndView(viewPath);
		if (attributeMap != null && !attributeMap.isEmpty()){
			for (String key : attributeMap.keySet()) {
				view.addObject(key, attributeMap.get(key));
			}
		}
		return view;
	}
	
	/**
	 * 返回succ为true的json格式<br>
	 * Controller方法注解@ResponseBody,返回Object
	 * @return
	 * 		{"success": true}
	 */
	protected Object renderJsonSucc() {
		json.clear();
		json.put(KEY_SUCCESS, true);
		return json;
	}
	
	/**
	 * 返回succ为true的json格式<br>
	 * Controller方法注解@ResponseBody,返回Object
	 * @param 
	 * 		value 返回的json对象
	 * @return
	 * 		{"success": true, "data": "Object or List"}
	 */
	protected Object renderJsonSucc(Object value) {
		json.clear();
		json.put(KEY_SUCCESS, true);
		json.put(KEY_DATA, value);
		return json;
	}
	
	/**
	 * 返回succ为true的json格式<br>
	 * Controller方法注解@ResponseBody,返回Object
	 * @param 
	 * 		msg 返回的消息内容
	 * @param 
	 * 		value 返回的json对象
	 * @return
	 * 		{"success": true, "msg","your message", "data": "Object or List"}
	 */
	protected Object renderJsonSucc(String msg, Object value) {
		json.clear();
		json.put(KEY_SUCCESS, true);
		json.put(KEY_MESSAGE, msg);
		json.put(KEY_DATA, value);
		return json;
	}
	
	/**
	 * 返回succ为false的json格式<br>
	 * Controller方法注解@ResponseBody,返回Object
	 * @return
	 * 		{"success": false}
	 */
	protected Object renderJsonError() {
		json.clear();
		json.put(KEY_SUCCESS, false);
		return json;
	}
	
	/**
	 * 返回succ为false的json格式<br>
	 * Controller方法注解@ResponseBody,返回Object
	 * @param 
	 * 		value 返回的json对象
	 * @return
	 * 		{"success": false, "data": "Object or List"}
	 */
	protected Object renderJsonError(Object value) {
		json.clear();
		json.put(KEY_SUCCESS, false);
		json.put(KEY_DATA, value);
		return json;
	}
	
	/**
	 * 返回succ为false的json格式<br>
	 * Controller方法注解@ResponseBody,返回Object
	 * @param 
	 * 		msg 返回的消息内容
	 * @param 
	 * 		value 返回的json对象
	 * @return
	 * 		{"success": false, "msg","your message", "data": "Object or List"}
	 */
	protected Object renderJsonError(String msg, Object value) {
		json.clear();
		json.put(KEY_SUCCESS, false);
		json.put(KEY_MESSAGE, msg);
		json.put(KEY_DATA, value);
		return json;
	}
	
	/**
	 * 返回指定键值的json格式<br>
	 * Controller方法注解@ResponseBody,返回Object
	 * @param 
	 * 		key json格式的键
	 * @param 
	 * 		value 返回的json对象
	 * @return
	 * 		{"your custom key": "Object or List"}
	 */
	protected Object renderJson(String key, Object value) {
		json.clear();
		json.put(key, value);
		return json;
	}
	
}
