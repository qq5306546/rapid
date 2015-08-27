package com.rapid.common.utils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * Bean工具类
 * @author wubei
 *
 */
public class BeanUtil {

	/**
	 * 获取接口的泛型类型，如果不存在则返回null
	 * @param clazz
	 * @return
	 */
	public static Class<?> getGenericClass(Class<?> clazz) {
		Type t = clazz.getGenericSuperclass();
		if (t instanceof ParameterizedType) {
			Type[] p = ((ParameterizedType) t).getActualTypeArguments();
			return ((Class<?>) p[0]);
		}
		return null;
	}
	
	/**
     * 将一个 JavaBean 对象转化为一个  Map
     * @param bean 要转化的JavaBean 对象
     * @return 转化出来的  Map 对象
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map beanToMap(Object bean) {
        Class type = bean.getClass();
        Map returnMap = new HashMap();
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(type);
			PropertyDescriptor[] propertyDescriptors =  beanInfo.getPropertyDescriptors();
	        for (int i = 0; i< propertyDescriptors.length; i++) {
	            PropertyDescriptor descriptor = propertyDescriptors[i];
	            String propertyName = descriptor.getName();
	            if (!propertyName.equals("class")) {
	                Method readMethod = descriptor.getReadMethod();
	                Object result = readMethod.invoke(bean, new Object[0]);
	                if (result != null) {
	                    returnMap.put(propertyName, result);
	                } 
	            }
	        }
		} catch (IntrospectionException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} 
        return returnMap;
    }
    
    /**
     * 将一个 Map 对象转化为一个 JavaBean
     * @param type 要转化的类型
     * @param map 包含属性值的 map
     * @return 转化出来的 JavaBean 对象
     */
    @SuppressWarnings("rawtypes")
	public static Object mapToBean(Class type, Map map) {
    	try {
	        BeanInfo beanInfo = Introspector.getBeanInfo(type); // 获取类属性
	        Object obj = type.newInstance(); // 创建 JavaBean 对象
	
	        // 给 JavaBean 对象的属性赋值
	        PropertyDescriptor[] propertyDescriptors =  beanInfo.getPropertyDescriptors();
	        for (int i = 0; i< propertyDescriptors.length; i++) {
	            PropertyDescriptor descriptor = propertyDescriptors[i];
	            String propertyName = descriptor.getName();
	
	            if (map.containsKey(propertyName)) {
	                // 下面一句可以 try 起来，这样当一个属性赋值失败的时候就不会影响其他属性赋值。
	                Object value = map.get(propertyName);
	                Object[] args = new Object[1];
	                args[0] = value;
	                descriptor.getWriteMethod().invoke(obj, args);
	            }
	        }
	        return obj;
    	} catch (IntrospectionException e) {
    		e.printStackTrace();
    	} catch (IllegalAccessException e) {
    		e.printStackTrace();
    	} catch (InstantiationException e) {
    		e.printStackTrace();
    	} catch (InvocationTargetException e) {
    		e.printStackTrace();
    	}
    	return null;
    }
}