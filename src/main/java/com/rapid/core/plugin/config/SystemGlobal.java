package com.rapid.core.plugin.config;

import java.util.Properties;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;

/**
 * 系统全局配置
 * @author wubei
 *
 */
public class SystemGlobal {

	/*
	 * spring.xml中注入Properties
	 * <util:properties id="properties" location="classpath:conf/config.properties"/>
	 */
	private Properties properties;
	
	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	/**
	 * 获取系统config.properties配置
	 * Key变量在全局类
	 * com.rapid.common.plugin.config.Config配置
	 * @param 
	 * 		configKey 配置Key
	 * @return 
	 * 		key对应的值
	 */
	public String getProperty(String configKey){
		return properties.getProperty(configKey);
	}
	
	/**
	 * 获取ApplicationContext上下文中注入的Bean对象
	 * @param 
	 * 		clazz Class
	 * @return
	 * 		T 泛型Bean对象
	 */
	public <T> T getBean(Class<T> clazz) {
		return getContext().getBean(clazz);
	}
	
	/**
	 * 获取ApplicationContext上下文中注入的Bean对象
	 * @param 
	 * 		arg Bean的路径
	 * @return
	 * 		Object 对象
	 */
	public Object getBean(String arg) {
		return getContext().getBean(arg);
	}
	
	/**
	 * Spring获得上下文
	 * @return
	 * 		spring ApplicationContext对象
	 */
	private ApplicationContext getContext() {
		return ContextLoader.getCurrentWebApplicationContext();
	}
}
