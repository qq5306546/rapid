package com.rapid.common.base.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.rapid.common.base.mybatis.dao.BaseDAO;
import com.rapid.common.base.mybatis.model.BaseModel;
import com.rapid.common.exception.BaseException;
import com.rapid.common.utils.BeanUtil;

@SuppressWarnings("rawtypes")
public class BaseServiceImpl<T extends BaseModel, ID extends Serializable> implements BaseService<T, ID> {
	
	protected final Logger logger = Logger.getLogger(getClass());
	
	@Autowired(required=true)
	private BaseDAO<T, ID> crudMapper;

	public long selectCount() {
		try {
			return crudMapper.selectCount();
		} catch (Exception e) {
			throw new BaseException(String.format("查询[BaseService.selectCount]错误：%s", e.getMessage()), e);
		}
	}

	public long selectCount(Map params) {
		try {
			return crudMapper.selectCount(params);
		} catch (Exception e) {
			throw new BaseException(String.format("查询[BaseService.selectCount]错误：%s", e.getMessage()), e);
		}
	}

	public long selectCount(T model) {
		try {
			return crudMapper.selectCount(BeanUtil.beanToMap(model));
		} catch (Exception e) {
			throw new BaseException(String.format("查询[BaseService.selectCount]错误：%s", e.getMessage()), e);
		}
	}

	public List<T> select() {
		try {
			return crudMapper.select();
		} catch (Exception e) {
			throw new BaseException(String.format("查询[BaseService.select]错误：%s", e.getMessage()), e);
		}
	}

	public List<T> select(Map params) {
		try {
			return crudMapper.select(params);
		} catch (Exception e) {
			throw new BaseException(String.format("查询[BaseService.select]错误：%s", e.getMessage()), e);
		}
	}

	public List<T> select(T model) {
		try {
			return crudMapper.select(BeanUtil.beanToMap(model));
		} catch (Exception e) {
			throw new BaseException(String.format("查询[BaseService.select]错误：%s", e.getMessage()), e);
		}
	}
	
	public PageList<T> selectPage(PageBounds pageBounds) {
		try {
			return crudMapper.select(null, pageBounds);
		} catch (Exception e) {
			throw new BaseException(String.format("查询[BaseService.selectPage]错误：%s", e.getMessage()), e);
		}
	}
	
	public PageList<T> selectPage(Map params, PageBounds pageBounds) {
		try {
			return crudMapper.select(params, pageBounds);
		} catch (Exception e) {
			throw new BaseException(String.format("查询[BaseService.selectPage]错误：%s", e.getMessage()), e);
		}
	}
	
	public PageList<T> selectPage(T model, PageBounds pageBounds) {
		try {
			return crudMapper.select(BeanUtil.beanToMap(model), pageBounds);
		} catch (Exception e) {
			throw new BaseException(String.format("查询[BaseService.selectPage]错误：%s", e.getMessage()), e);
		}
	}

	public T selectById(ID id) {
		try {
			return crudMapper.selectById(id);
		} catch (Exception e) {
			throw new BaseException(String.format("查询[BaseService.selectById]错误：%s", e.getMessage()), e);
		}
	}

	public int delete() {
		try {
			return crudMapper.delete();
		} catch (Exception e) {
			throw new BaseException(String.format("删除[BaseService.delete]错误：%s", e.getMessage()), e);
		}
	}

	public int delete(Map params) {
		try {
			return crudMapper.delete(params);
		} catch (Exception e) {
			throw new BaseException(String.format("删除[BaseService.delete]错误：%s", e.getMessage()), e);
		}
	}

	public int delete(T model) {
		try {
			return crudMapper.delete(BeanUtil.beanToMap(model));
		} catch (Exception e) {
			throw new BaseException(String.format("删除[BaseService.delete]错误：%s", e.getMessage()), e);
		}
	}

	public int deleteById(ID id) {
		try {
			return crudMapper.deleteById(id);
		} catch (Exception e) {
			throw new BaseException(String.format("删除[BaseService.deleteById]错误：%s", e.getMessage()), e);
		}
	}
	
	public int insertSelective(T model) {
		try {
			return crudMapper.insertSelective(model);
		} catch (Exception e) {
			throw new BaseException(String.format("新增[BaseService.insertSelective]错误：%s", e.getMessage()), e);
		}
	}

	public int insert(T model) {
		try {
			return crudMapper.insert(model);
		} catch (Exception e) {
			throw new BaseException(String.format("新增[BaseService.insert]错误：%s", e.getMessage()), e);
		}
	}

	public int updateByIdSelective(T model) {
		try {
			return crudMapper.updateByIdSelective(model);
		} catch (Exception e) {
			throw new BaseException(String.format("修改[BaseService.updateByIdSelective]错误：%s", e.getMessage()), e);
		}
	}
    
	public int updateById(T model) {
		try {
			return crudMapper.updateById(model);
		} catch (Exception e) {
			throw new BaseException(String.format("修改[BaseService.updateById]错误：%s", e.getMessage()), e);
		}
	}
	
	
}
