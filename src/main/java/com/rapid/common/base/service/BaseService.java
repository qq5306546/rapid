package com.rapid.common.base.service;

import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

/**
 * 基于mybatis的BaseMapper封装的BaseService公共Service类，
 * Service基类封装了包含BaseMapper增、删、查、改下所有方法，
 * 在做多表关联处理时，不建议在Contoller层中调用，应实现自己的
 * Service类来控制多表操作之间的事务处理
 * @author wubei
 *
 * @param 
 * 		<T> 泛型对象
 * @param 
 * 		<ID> 对象的唯一标识
 */
@SuppressWarnings("rawtypes")
public interface BaseService<T, ID> {
	
	/**
	 * 查询数据库表中的总行数
	 * @return
	 * 		long 型的数据行数
	 */
	public long selectCount();

	/**
	 * 条件查询数据表中的总行数
	 * @param 
	 * 		params Map类型封装参数(K 字段名, V 字段值)
	 * @return 
	 * 		long 型的数据行数
	 */
	public long selectCount(Map params);
	
	/**
	 * 条件查询数据表中的总行数
	 * 底层调用selectCount(Map params)方法
	 * model对象通过BeanUtil转换成Map对象
	 * @param
	 * 		model 查询条件的实体封装
	 * @return
	 * 		long 型的数据行数
	 */
	public long selectCount(T model);
    
	/**
	 * 查询数据库表中的所有行
	 * @return
	 * 		List<T> 泛型的集合对象
	 */
	public List<T> select();
	
	/**
	 * 条件查询数据表中的所有行
	 * @param 
	 * 		params Map类型封装参数(K 字段名, V 字段值)
	 * @return 
	 * 		List<T> 泛型的集合对象
	 */
	public List<T> select(Map params);
	
	/**
	 * 条件查询数据表中的所有行
	 * 底层调用selectCount(Map params)方法
	 * model对象通过BeanUtil转换成Map对象
	 * @param 
	 * 		model 查询的实体条件
	 * @return 
	 * 		List<T> 泛型的集合对象
	 */
	public List<T> select(T model);
	
	/**
	 * 查询数据表中的分页后行数量
	 * 底层调用selectPage(Map params, PageBounds pageBounds)方法
	 * 该方法传递查询条为Null，默认查询所有数据
	 * @param 
	 * 		pageBounds 分页参数实体
	 * @return
	 * 		PageList<T> 分页后的实体
	 */
	public PageList<T> selectPage(PageBounds pageBounds);
	
	/**
	 * 条件查询数据表中的分页后行数量
	 * 底层调用selectPage(Map params, PageBounds pageBounds)方法
	 * @param 
	 * 		pageBounds 分页参数实体
	 * @return
	 * 		PageList<T> 分页后的实体
	 */
	public PageList<T> selectPage(Map params, PageBounds pageBounds);
	
	/**
	 * 条件查询数据表中的分页后行数量
	 * 底层调用selectPage(Map params, PageBounds pageBounds)方法
	 * model对象通过BeanUtil转换成Map对象
	 * @param 
	 * 		pageBounds 分页参数实体
	 * @return
	 * 		PageList<T> 分页后的实体
	 */
	public PageList<T> selectPage(T model, PageBounds pageBounds);
	
	/**
	 * 唯一标识查询数据表中的行
	 * @param 
	 * 		id 对象唯一标识
	 * @return 
	 * 		<T> 泛型的对象
	 */
	public T selectById(ID id);
    
	/**
	 * 删除数据表中所有行
	 * @return
	 * 		int 删除行总数
	 */
	public int delete();
     
	/**
	 * 条件删除数据表中所有行
	 * @param 
	 * 		params Map类型封装参数(K 字段名, V 字段值)
	 * @return 
	 * 		int 删除行总数
	 */
	public int delete(Map params);
	
	/**
	 * 条件删除数据表中所有行
	 * 底层调用delete(Map params)方法
	 * model对象通过BeanUtil转换成Map对象
	 * @param 
	 * 		model 被删除的对象
	 * @return 
	 * 		int 删除行总数
	 */
	public int delete(T model);
     
	/**
	 * 唯一标识删除数据表中所有行
	 * @param 
	 * 		id 对象唯一标识
	 * @return 
	 * 		int 删除行总数
	 */
	public int deleteById(ID id);
	
	/**
	 * 新增一条数据库记录
	 * 实体字段为空时，则不修改为空字段
	 * @param 
	 * 		model 新增的对象
	 * @return
	 * 		int 新增成功数量
	 */
	public int insertSelective(T model);
     
	/**
	 * 新增一条数据库记录
	 * 必须设置实体内所有字段
	 * @param 
	 * 		model 新增的数据实体
	 * @return
	 * 		int 大于0保存成功
	 */
	public int insert(T model);
	
	/**
	 * 修改一条数据库记录
	 * 实体字段为空时，则不修改为空字段
	 * @param 
	 * 		model 修改的数据实体
	 * @return
	 * 		int 大于1修改成功
	 */
	public int updateByIdSelective(T model);
     
	/**
	 * 修改一条数据库记录
	 * 必须传递实体对应所有字段
	 * @param 
	 * 		model 修改的数据实体
	 * @return
	 * 		int 大于1修改成功
	 */
	public int updateById(T model);
}
